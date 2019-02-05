package com.uday.android.spacexorg.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.CoreEntity;
import com.uday.android.spacexorg.network.model.core.Mission;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoresListAdapter extends RecyclerView.Adapter<CoresListAdapter.CoresViewHolder> {

    private List<CoreEntity> mCores;
    private Boolean mIsExpanded = false;

    public class CoresViewHolder extends RecyclerView.ViewHolder {

        Context context;
        @BindView(R.id.txt_adapter_core_serial)
        TextView mTxtCoreSerial;
        @BindView(R.id.txt_adapter_core_status)
        TextView mTxtCoreStatus;
        @BindView(R.id.txt_adapter_core_block)
        TextView mTxtCoreBlock;
        @BindView(R.id.txt_adapter_core_missions)
        TextView mTxtAdapterCoreMissions;
        @BindView(R.id.txt_adapter_core_details)
        TextView mTxtAdapterCoreDetails;
        @BindView(R.id.btn_adapter_core_expand)
        ImageButton mBtnExpandDetails;
        @BindView(R.id.lyt_adapter_core_expand)
        LinearLayout mLytCoreDetails;

        public CoresViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();

            mBtnExpandDetails.setOnClickListener(v -> {

                if (mIsExpanded) {
                    mLytCoreDetails.setVisibility(View.GONE);
                    mBtnExpandDetails.setImageResource(R.drawable.ic_expand_more);
                    mIsExpanded = false;
                } else {
                    mLytCoreDetails.setVisibility(View.VISIBLE);
                    mBtnExpandDetails.setImageResource(R.drawable.ic_expand_less);
                    mIsExpanded = true;
                }

            });
        }

        void bind(CoreEntity core) {
            mTxtCoreSerial.setText(core.getCoreSerial());
            String status = context.getString(R.string.core_status) + " " + core.getStatus();
            mTxtCoreStatus.setText(status);

            if(core.getBlock()!=null && core.getBlock()>0)
                mTxtCoreBlock.setText(String.valueOf(core.getBlock()));
            else
                mTxtCoreBlock.setText(context.getString(R.string.tag_to_be_decided));

            Moshi moshi = new Moshi.Builder().build();
            Type type1 = Types.newParameterizedType(List.class, Mission.class);
            JsonAdapter<List<Mission>> jsonAdapter = moshi.adapter(type1);
            List<Mission> missionsList;
            StringBuilder stringMissions = new StringBuilder();

            try {
                missionsList = jsonAdapter.fromJson(Objects.requireNonNull(core.getMissions()));

                if(missionsList!=null && missionsList.size()>0) {
                    for (int i = 0; i < missionsList.size(); i++) {

                        if(i==0) {
                            if(missionsList.size() == 1){
                                stringMissions.append(missionsList.get(i).getName());
                            } else {
                                stringMissions.append(missionsList.get(i).getName()).append(context.getString(R.string.text_comma));
                            }
                        }
                        else if(i == missionsList.size()-1)
                            stringMissions.append(missionsList.get(i).getName());
                        else
                            stringMissions.append(missionsList.get(i).getName()).append(context.getString(R.string.text_comma));
                    }
                } else {
                    stringMissions.append(context.getString(R.string.text_no_mission));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            mTxtAdapterCoreMissions.setText(stringMissions);

            if(core.getDetails()!=null)
                mTxtAdapterCoreDetails.setText(core.getDetails());
            else
                mTxtAdapterCoreDetails.setText(context.getString(R.string.text_no_details));
        }

    }

    @NonNull
    @Override
    public CoresViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_cores_list,viewGroup,false);
        view.setFocusable(true);
        return new CoresViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CoresViewHolder coresViewHolder, int i) {
        coresViewHolder.bind(mCores.get(i));
    }

    @Override
    public int getItemCount() {
        return mCores == null ? 0 : mCores.size();

    }

    public void setCores(List<CoreEntity> coreEntityList) {
        this.mCores = coreEntityList;
        notifyDataSetChanged();
    }

}
