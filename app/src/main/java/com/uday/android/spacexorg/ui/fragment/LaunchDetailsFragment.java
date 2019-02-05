package com.uday.android.spacexorg.ui.fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.uday.android.spacexorg.ui.utils.DateConverter;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.LaunchEntity;
import com.uday.android.spacexorg.ui.activity.LaunchesActivity;
import com.uday.android.spacexorg.ui.viewmodel.LaunchDetailsViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.squareup.picasso.Picasso;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LaunchDetailsFragment extends Fragment {

    private static final String ARG_PARAM_LAUNCH_ID = "param_launch_id";

    private Unbinder mUnBinder;
    private LaunchDetailsViewModel mViewModel;
    private int mParamLaunchId;
    private LaunchEntity mLaunchEntity;

    @BindView(R.id.toolbar_launches_details)
    Toolbar mToolbar;

    @BindView(R.id.view_launch_location)
    CardView mViewLaunchLocation;

    @BindView(R.id.image_launches_details)
    ImageView mImageMissionPatch;

    @BindView(R.id.txt_title_launches_details)
    TextView mTxtLaunchTitle;

    @BindView(R.id.txt_date_launches_details)
    TextView mTxtLaunchDate;

    @BindView(R.id.txt_site_name_launch_details)
    TextView mTxtLaunchSite;

    @BindView(R.id.txt_details_launches_details)
    TextView mTxtLaunchDetails;

    @BindView(R.id.txt_rocket_name_launches_details)
    TextView mTxtRocketName;

    @BindView(R.id.txt_rocket_type_launches_details)
    TextView mTxtRocketType;

    @BindView(R.id.txt_launch_success_launches_details)
    TextView mTxtLaunchSuccess;

    @BindView(R.id.txt_core_serial_launches_details)
    TextView mTxtCoreSerial;

    @BindView(R.id.txt_core_reused_launches_details)
    TextView mTxtCoreReused;

    @BindView(R.id.txt_landing_type_launches_details)
    TextView mTxtLandingType;

    @BindView(R.id.txt_landing_vehicle_launches_details)
    TextView mTxtLandingVehicle;

    @BindView(R.id.txt_landing_success_launches_details)
    TextView mTxtLandingSuccess;

    @BindView(R.id.txt_payload_name_launches_details)
    TextView mTxtPayloadName;

    @BindView(R.id.txt_manufacturer_launches_details)
    TextView mTxtManufacturer;

    @BindView(R.id.txt_customer_launches_details)
    TextView mTxtCustomer;

    @BindView(R.id.txt_nationality_launches_details)
    TextView mTxtNationality;

    @BindView(R.id.txt_payload_mass_launches_details)
    TextView mTxtPayloadMass;

    @BindView(R.id.txt_payload_orbit_launches_details)
    TextView mTxtPayloadOrbit;

    @BindView(R.id.txt_fairings_reused_launches_details)
    TextView mTxtFairingsReused;

    @BindView(R.id.txt_recovery_attempt_launches_details)
    TextView mTxtRecoveryAttempt;

    @BindView(R.id.ad_view)
    AdView adView;

    public LaunchDetailsFragment() {
        // Required empty public constructor
    }

    public static LaunchDetailsFragment newInstance(int paramLaunchId) {
        LaunchDetailsFragment fragment = new LaunchDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM_LAUNCH_ID, paramLaunchId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamLaunchId = getArguments().getInt(ARG_PARAM_LAUNCH_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_launch_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LaunchDetailsViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {

        mViewModel.getLaunchData(mParamLaunchId).observe(this,
                launchEntity -> {
                    if(launchEntity!=null) {
                        mLaunchEntity = launchEntity;
                        updateUI();
                    }
        });

    }

    private void updateUI() {
        if(mLaunchEntity.getMissionPatch() != null)
            Picasso.get().load(mLaunchEntity.getMissionPatch()).into(mImageMissionPatch);

        mTxtLaunchTitle.setText(mLaunchEntity.getMissionName());
        mTxtLaunchDate.setText(DateConverter.convertToDateSimpleFormat(mLaunchEntity.getLaunchDateUtc()));
        mTxtLaunchSite.setText(mLaunchEntity.getLaunchSiteName());
        mTxtRocketName.setText(mLaunchEntity.getRocketName());
        mTxtRocketType.setText(mLaunchEntity.getRocketType());
        mTxtPayloadName.setText(mLaunchEntity.getPayloadId());
        mTxtNationality.setText(mLaunchEntity.getNationality());
        mTxtPayloadOrbit.setText(mLaunchEntity.getOrbit());

        if(mLaunchEntity.getDetails()!=null)
            mTxtLaunchDetails.setText(mLaunchEntity.getDetails());
        else
            mTxtLaunchDetails.setText(getString(R.string.empty_text_details));

        if(mLaunchEntity.getLaunchSuccess()!=null && mLaunchEntity.getLaunchSuccess())
            mTxtLaunchSuccess.setText(getString(R.string.text_true_boolean_value));
        else if(mLaunchEntity.getLaunchSuccess()!=null && !mLaunchEntity.getLaunchSuccess())
            mTxtLaunchSuccess.setText(getString(R.string.text_false_boolean_value));
        else
            mTxtLaunchSuccess.setText(getString(R.string.text_unknown_value));

        if(mLaunchEntity.getCoreSerial()!=null)
            mTxtCoreSerial.setText(mLaunchEntity.getCoreSerial());
        else
            mTxtCoreSerial.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getCoreReused()!=null && mLaunchEntity.getCoreReused())
            mTxtCoreReused.setText(getString(R.string.text_true_boolean_value));
        else if(mLaunchEntity.getCoreReused()!=null && !mLaunchEntity.getCoreReused())
            mTxtCoreReused.setText(getString(R.string.text_false_boolean_value));
        else
            mTxtCoreReused.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getLandingType()!=null)
            mTxtLandingType.setText(mLaunchEntity.getLandingType());
        else
            mTxtLandingType.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getLandingVehicle()!=null)
            mTxtLandingVehicle.setText(mLaunchEntity.getLandingVehicle());
        else
            mTxtLandingVehicle.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getLandSuccess()!=null && mLaunchEntity.getLandSuccess())
            mTxtLandingSuccess.setText(getString(R.string.text_true_boolean_value));
        else if(mLaunchEntity.getLandSuccess()!=null && !mLaunchEntity.getLandSuccess())
            mTxtLandingSuccess.setText(getString(R.string.text_false_boolean_value));
        else
            mTxtLandingSuccess.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getManufacturer()!=null)
            mTxtManufacturer.setText(mLaunchEntity.getManufacturer());
        else
            mTxtManufacturer.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getCustomers()!=null)
            mTxtCustomer.setText(mLaunchEntity.getCustomers());
        else
            mTxtCustomer.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getPayloadMassKg()!=null) {
            String massInKg = mLaunchEntity.getPayloadMassKg() + getString(R.string.kg);
            mTxtPayloadMass.setText(massInKg);
        }
        else
            mTxtPayloadMass.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getFairingsReused()!=null && mLaunchEntity.getFairingsReused())
            mTxtFairingsReused.setText(getString(R.string.text_true_boolean_value));
        else if(mLaunchEntity.getFairingsReused()!=null && !mLaunchEntity.getFairingsReused())
            mTxtFairingsReused.setText(getString(R.string.text_false_boolean_value));
        else
            mTxtFairingsReused.setText(getString(R.string.data_empty));

        if(mLaunchEntity.getFairingsRecoveryAttempt()!=null && mLaunchEntity.getFairingsRecoveryAttempt())
            mTxtRecoveryAttempt.setText(getString(R.string.text_true_boolean_value));
        else if(mLaunchEntity.getFairingsRecoveryAttempt()!=null && !mLaunchEntity.getFairingsRecoveryAttempt())
            mTxtRecoveryAttempt.setText(getString(R.string.text_false_boolean_value));
        else
            mTxtRecoveryAttempt.setText(getString(R.string.data_empty));
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
                if(getActivity()!=null)
                    getActivity().onBackPressed();
            }
        });

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        adView.loadAd(adRequest);

        mViewLaunchLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mLaunchEntity.getLaunchSiteId()!=null) {
                    if (getActivity() != null) {
                        ((LaunchesActivity) getActivity()).openFragment(LaunchesActivity.FRAGMENT_TYPE_MAP,mLaunchEntity);
                    }
                } else {
                    Toast.makeText(getContext(), getString(R.string.text_no_data_available), Toast.LENGTH_SHORT).show();
                }
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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
