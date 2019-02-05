package com.uday.android.spacexorg.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.CapsuleEntity;
import com.uday.android.spacexorg.database.entity.RocketEntity;
import com.uday.android.spacexorg.database.entity.ShipEntity;
import com.uday.android.spacexorg.network.model.ship.Mission;
import com.uday.android.spacexorg.ui.activity.VehiclesActivity;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VehicleListAdapter extends RecyclerView.Adapter<VehicleListAdapter.VehicleViewHolder> {

    private List<RocketEntity> mRockets;
    private List<CapsuleEntity> mCapsules;
    private List<ShipEntity> mShips;
    private int mSectionNumber;
    private OnAdapterItemClickListener mOnAdapterItemClickListener;

    public VehicleListAdapter(int mSectionNumber, OnAdapterItemClickListener mOnAdapterItemClickListener) {
        this.mSectionNumber = mSectionNumber;
        this.mOnAdapterItemClickListener = mOnAdapterItemClickListener;
    }

    public class VehicleViewHolder extends RecyclerView.ViewHolder {

        Context context;
        @BindView(R.id.txt_adapter_vehicle_header)
        TextView mTxtRocketName;
        @BindView(R.id.txt_adapter_vehicle_sub_header)
        TextView mTxtRocketFirstFlight;

        public VehicleViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        void bindRocket(RocketEntity rocket){
            mTxtRocketName.setText(rocket.getRocketName());
            String firstFlight = context.getString(R.string.text_first_flight) + rocket.getFirstFlight();
            mTxtRocketFirstFlight.setText(firstFlight);

            itemView.setOnClickListener(v -> {
                mOnAdapterItemClickListener.onItemClicked(rocket);
            });
        }

        void bindCapsule(CapsuleEntity capsule) {
            mTxtRocketName.setText(capsule.getName());
            String firstFlight = context.getString(R.string.text_first_flight) + capsule.getFirstFlight();
            mTxtRocketFirstFlight.setText(firstFlight);

            itemView.setOnClickListener(v -> {
                mOnAdapterItemClickListener.onItemClicked(capsule);
            });
        }

        void bindShip(ShipEntity ship) {
            mTxtRocketName.setText(ship.getShipName());

            String buildIn;
            if(ship.getYearBuilt()!=null)
                buildIn = context.getString(R.string.text_ship_year) + ship.getYearBuilt();
            else
                buildIn = context.getString(R.string.text_no_data_available);
            mTxtRocketFirstFlight.setText(buildIn);

            Moshi moshi = new Moshi.Builder().build();
            Type type3 = Types.newParameterizedType(List.class, Mission.class);
            JsonAdapter<List<Mission>> jsonAdapter = moshi.adapter(type3);
            List<Mission> missionsList;
            StringBuilder stringMissions = new StringBuilder();

            try {
                missionsList = jsonAdapter.fromJson(Objects.requireNonNull(ship.getMissions()));

                if(missionsList!=null && missionsList.size()>0) {
                    for (int i = 0; i < missionsList.size(); i++) {

                        if(i==0) {
                            if(missionsList.size() == 1){
                                stringMissions.append(context.getString(R.string.text_participated)).append(missionsList.get(i).getName());
                            } else {
                                stringMissions.append(context.getString(R.string.text_participated)).append(missionsList.get(i).getName()).append(", ");
                            }
                        }
                        else if(i == missionsList.size()-1)
                            stringMissions.append(missionsList.get(i).getName());
                        else
                            stringMissions.append(missionsList.get(i).getName()).append(context.getString(R.string.text_comma));
                    }
                } else {
                    stringMissions.append(context.getString(R.string.text_comma)).append(context.getString(R.string.text_no_mission));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            itemView.setOnClickListener(v -> {
                mOnAdapterItemClickListener.onItemClicked(ship);
            });
        }
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_vehicle_list,viewGroup,false);
        view.setFocusable(true);
        return new VehicleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VehicleViewHolder vehicleViewHolder, int i) {

        if(mSectionNumber == VehiclesActivity.RL_SECTION_NUMBER)
            vehicleViewHolder.bindRocket(mRockets.get(i));
        if(mSectionNumber == VehiclesActivity.CL_SECTION_NUMBER)
            vehicleViewHolder.bindCapsule(mCapsules.get(i));
        if(mSectionNumber == VehiclesActivity.SL_SECTION_NUMBER)
            vehicleViewHolder.bindShip(mShips.get(i));
    }

    @Override
    public int getItemCount() {

        if(mSectionNumber == VehiclesActivity.RL_SECTION_NUMBER)
            return mRockets == null ? 0 : mRockets.size();
        if(mSectionNumber == VehiclesActivity.CL_SECTION_NUMBER)
            return mCapsules == null ? 0 : mCapsules.size();
        if(mSectionNumber == VehiclesActivity.SL_SECTION_NUMBER)
            return mShips == null ? 0 : mShips.size();
        else
            return 0;

    }

    public void setRockets(List<RocketEntity> rocketEntityList) {
        this.mRockets = rocketEntityList;
        notifyDataSetChanged();
    }

    public void setCapsules(List<CapsuleEntity> capsuleEntityList) {
        this.mCapsules = capsuleEntityList;
        notifyDataSetChanged();
    }

    public void setShips(List<ShipEntity> shipEntityList) {
        this.mShips = shipEntityList;
        notifyDataSetChanged();
    }

}
