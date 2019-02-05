package com.uday.android.spacexorg.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.CapsuleEntity;
import com.uday.android.spacexorg.database.entity.RocketEntity;
import com.uday.android.spacexorg.database.entity.ShipEntity;
import com.uday.android.spacexorg.network.model.capsule.Thruster;
import com.uday.android.spacexorg.network.model.ship.Mission;
import com.uday.android.spacexorg.ui.viewmodel.VehicleDetailsViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VehicleDetailsFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "param_section_number";
    private static final String ARG_VEHICLE_ID = "param_vehicle_id";

    private VehicleDetailsViewModel mViewModel;
    private Unbinder mUnBinder;

    private RocketEntity mRocketEntity;
    private CapsuleEntity mCapsuleEntity;
    private ShipEntity mShipEntity;

    private int mVehicleType;
    private String mVehicleId;

    @BindView(R.id.collapsing_toolbar_vehicle_details)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    @BindView(R.id.toolbar_vehicle_details)
    Toolbar mToolbar;

    @BindView(R.id.toolbar_vehicle_details_title)
    TextView mTxtVehicleTitle;

    @BindView(R.id.txt_vehicle_details)
    TextView mTxtVehicleDetails;

    @BindView(R.id.txt_details_header_1)
    TextView mTxtDetailsHeader1;

    @BindView(R.id.txt_details_title_1)
    TextView mTxtDetailsTitle1;

    @BindView(R.id.txt_details_header_2)
    TextView mTxtDetailsHeader2;

    @BindView(R.id.txt_details_title_2)
    TextView mTxtDetailsTitle2;

    @BindView(R.id.txt_details_header_3)
    TextView mTxtDetailsHeader3;

    @BindView(R.id.txt_details_title_3)
    TextView mTxtDetailsTitle3;

    @BindView(R.id.txt_details_header_4)
    TextView mTxtDetailsHeader4;

    @BindView(R.id.txt_details_title_4)
    TextView mTxtDetailsTitle4;

    @BindView(R.id.txt_details_header_5)
    TextView mTxtDetailsHeader5;

    @BindView(R.id.txt_details_title_5)
    TextView mTxtDetailsTitle5;

    @BindView(R.id.txt_details_header_6)
    TextView mTxtDetailsHeader6;

    @BindView(R.id.txt_details_title_6)
    TextView mTxtDetailsTitle6;

    @BindView(R.id.txt_details_header_7)
    TextView mTxtDetailsHeader7;

    @BindView(R.id.txt_details_title_7)
    TextView mTxtDetailsTitle7;

    @BindView(R.id.txt_details_header_8)
    TextView mTxtDetailsHeader8;

    @BindView(R.id.txt_details_title_8)
    TextView mTxtDetailsTitle8;

    @BindView(R.id.ad_view)
    AdView adView;

    public VehicleDetailsFragment() {
        // Required empty public constructor
    }

    public static VehicleDetailsFragment newInstance(int paramSectionNumber, String paramVehicleId) {
        VehicleDetailsFragment fragment = new VehicleDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, paramSectionNumber);
        args.putString(ARG_VEHICLE_ID, paramVehicleId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mVehicleType = getArguments().getInt(ARG_SECTION_NUMBER);
            mVehicleId = getArguments().getString(ARG_VEHICLE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_vehicle_details_header, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, view);

        if(getActivity()!=null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(VehicleDetailsViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {

        switch (mVehicleType) {

            case 1:
                mViewModel.getRocketData(mVehicleId).observe(this, rocketEntity -> {
                    mRocketEntity = rocketEntity;
                    updateUI();
                });
                break;

            case 2:
                mViewModel.getCapsuleData(mVehicleId).observe(this,capsuleEntity -> {
                    mCapsuleEntity = capsuleEntity;
                    updateUI();
                });
                break;

            case 3:
                mViewModel.getShipsData(mVehicleId).observe(this,shipEntity -> {
                    mShipEntity = shipEntity;
                    updateUI();
                });
                break;

        }

    }

    private void updateUI() {

        Moshi moshi = new Moshi.Builder().build();

        switch (mVehicleType) {

            case 1:

                if(mRocketEntity != null) {
                    mTxtVehicleTitle.setText(mRocketEntity.getRocketName());
                    mTxtVehicleDetails.setText(mRocketEntity.getDescription());
                    String[] rocketDataHeaders = getResources().getStringArray(R.array.list_rocket_header);
                    setHeaders(rocketDataHeaders);
                    String engine = mRocketEntity.getEnginesType() + " " + mRocketEntity.getEnginesVersion();
                    mTxtDetailsTitle1.setText(engine);
                    String fuel = mRocketEntity.getFirstStageFuelAmountTons() + getString(R.string.tones);
                    mTxtDetailsTitle2.setText(fuel);
                    String rocketHeight = mRocketEntity.getHeightMeters() + getString(R.string.meter);
                    mTxtDetailsTitle3.setText(rocketHeight);
                    String rocketWeight = mRocketEntity.getMassKg() + getString(R.string.kg);
                    mTxtDetailsTitle4.setText(rocketWeight);
                    String rocketDiameter = mRocketEntity.getDiameterMeters() + getString(R.string.meter);
                    mTxtDetailsTitle5.setText(rocketDiameter);
                    if(mRocketEntity.getActive()!=null && mRocketEntity.getActive())
                        mTxtDetailsTitle6.setText(getString(R.string.text_true_boolean_value));
                    else
                        mTxtDetailsTitle6.setText(getString(R.string.text_false_boolean_value));
                    String seaLevelThrust = mRocketEntity.getThrustSeaLevel() + getString(R.string.kn);
                    mTxtDetailsTitle7.setText(seaLevelThrust);
                    String vacuumThrust = mRocketEntity.getThrustVacuum() + getString(R.string.kn);
                    mTxtDetailsTitle8.setText(vacuumThrust);
                }
                break;

            case 2:

                if(mCapsuleEntity != null) {
                    String[] capsuleDataHeaders = getResources().getStringArray(R.array.list_capsule_header);
                    setHeaders(capsuleDataHeaders);
                    mTxtVehicleTitle.setText(mCapsuleEntity.getName());
                    mTxtVehicleDetails.setText(mCapsuleEntity.getDescription());

                    String crewCapacity;
                    if(mCapsuleEntity.getCrewCapacity()!=null && mCapsuleEntity.getCrewCapacity()>0)
                        crewCapacity = mCapsuleEntity.getCrewCapacity() + getString(R.string.text_people);
                    else
                        crewCapacity = getString(R.string.text_unknown_value);
                    mTxtDetailsTitle1.setText(crewCapacity);

                    if(mCapsuleEntity.getFirstFlight() != null)
                        mTxtDetailsTitle2.setText(mCapsuleEntity.getFirstFlight());
                    else
                        mTxtDetailsTitle2.setText(getString(R.string.text_unknown_value));

                    Type type1 = Types.newParameterizedType(List.class, Thruster.class);
                    JsonAdapter<List<Thruster>> jsonThrusterAdapter = moshi.adapter(type1);
                    String thrusters = getString(R.string.text_unknown_value);
                    try {
                        List<Thruster> capsuleList = jsonThrusterAdapter.fromJson(Objects.requireNonNull(mCapsuleEntity.getThrusters()));
                        thrusters = (capsuleList != null ? capsuleList.size() : 0) + "";
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mTxtDetailsTitle3.setText(thrusters);

                    String capsuleWeight = mCapsuleEntity.getDryMassKg() + getString(R.string.kg);
                    mTxtDetailsTitle4.setText(capsuleWeight);
                    String capsuleDiameter = mCapsuleEntity.getDiameter() + getString(R.string.meter);
                    mTxtDetailsTitle5.setText(capsuleDiameter);

                    if(mCapsuleEntity.getActive()!=null && mCapsuleEntity.getActive())
                        mTxtDetailsTitle6.setText(getString(R.string.text_true_boolean_value));
                    else
                        mTxtDetailsTitle6.setText(getString(R.string.text_false_boolean_value));

                    String launchPayloadMass = mCapsuleEntity.getLaunchPayloadMass() + getString(R.string.kg);
                    mTxtDetailsTitle7.setText(launchPayloadMass);

                    String returnPayloadMass = mCapsuleEntity.getReturnPayloadMass() + getString(R.string.kg);
                    mTxtDetailsTitle8.setText(returnPayloadMass);
                }
                break;

            case 3:

                if(mShipEntity != null) {
                    String[] shipDataHeaders = getResources().getStringArray(R.array.list_ship_header);
                    setHeaders(shipDataHeaders);

                    mTxtVehicleTitle.setText(mShipEntity.getShipName());

                    Type type3 = Types.newParameterizedType(List.class, Mission.class);
                    JsonAdapter<List<Mission>> jsonAdapter = moshi.adapter(type3);
                    List<Mission> missionsList;
                    StringBuilder stringMissions = new StringBuilder();

                    try {
                        missionsList = jsonAdapter.fromJson(Objects.requireNonNull(mShipEntity.getMissions()));

                        if(missionsList!=null && missionsList.size()>0) {
                            for (int i = 0; i < missionsList.size(); i++) {

                                if(i==0) {
                                    if(missionsList.size() == 1){
                                        stringMissions.append(getString(R.string.text_participated)).append(missionsList.get(i).getName());
                                    } else {
                                        stringMissions.append(getString(R.string.text_participated)).append(missionsList.get(i).getName()).append(getString(R.string.text_comma));
                                    }
                                }
                                else if(i == missionsList.size()-1)
                                    stringMissions.append(missionsList.get(i).getName());
                                else
                                    stringMissions.append(missionsList.get(i).getName()).append(getString(R.string.text_comma));
                            }
                        } else {
                            stringMissions.append(getString(R.string.text_no_mission));
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mTxtVehicleDetails.setText(stringMissions);

                    mTxtDetailsTitle1.setText(mShipEntity.getShipType());

                    Type type2 = Types.newParameterizedType(List.class, String.class);
                    JsonAdapter<List<String>> jsonRolesAdapter = moshi.adapter(type2);
                    String primaryRole = getString(R.string.text_unknown_value);
                    try {
                        List<String> roles = jsonRolesAdapter.fromJson(Objects.requireNonNull(mShipEntity.getRoles()));
                        primaryRole = roles.get(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    mTxtDetailsTitle2.setText(primaryRole);

                    String currentSpeed = mShipEntity.getSpeedKn() + getString(R.string.kmperhour);
                    mTxtDetailsTitle3.setText(currentSpeed);

                    String shipWeight = mShipEntity.getWeightKg() + getString(R.string.kg);
                    mTxtDetailsTitle4.setText(shipWeight);

                    mTxtDetailsTitle5.setText(mShipEntity.getStatus());
                    mTxtDetailsTitle6.setText(mShipEntity.getHomePort());
                }
                break;

        }

    }

    private void setHeaders(String[] dataHeaders) {

        mTxtDetailsHeader1.setText(dataHeaders[0]);
        mTxtDetailsHeader2.setText(dataHeaders[1]);
        mTxtDetailsHeader3.setText(dataHeaders[2]);
        mTxtDetailsHeader4.setText(dataHeaders[3]);
        mTxtDetailsHeader5.setText(dataHeaders[4]);
        mTxtDetailsHeader6.setText(dataHeaders[5]);
        if(dataHeaders.length==8) {
            mTxtDetailsHeader7.setText(dataHeaders[6]);
            mTxtDetailsHeader8.setText(dataHeaders[7]);
        } else {
            mTxtDetailsHeader7.setVisibility(View.GONE);
            mTxtDetailsHeader8.setVisibility(View.GONE);
            mTxtDetailsTitle7.setVisibility(View.GONE);
            mTxtDetailsTitle8.setVisibility(View.GONE);
        }

    }

    @Override
    public void onPause() {
        if (adView != null) {
            adView.pause();
        }
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adView != null) {
            adView.resume();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (adView != null) {
            adView.destroy();
        }

        if (mUnBinder != null) {
            mUnBinder.unbind();
            mUnBinder = null;
        }
    }

}
