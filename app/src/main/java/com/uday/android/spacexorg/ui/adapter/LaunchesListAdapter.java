package com.uday.android.spacexorg.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uday.android.spacexorg.ui.utils.DateConverter;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.LaunchEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LaunchesListAdapter extends RecyclerView.Adapter<LaunchesListAdapter.LaunchesViewHolder> {

    private List<LaunchEntity> mLaunches;
    private OnAdapterItemClickListener mOnLaunchListItemClickListener;

    public LaunchesListAdapter(OnAdapterItemClickListener listItemClickListener) {
        this.mOnLaunchListItemClickListener = listItemClickListener;
    }

    public class LaunchesViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_adapter_launch_patch)
        ImageView mImgLaunchPatch;
        @BindView(R.id.txt_adapter_launch_title)
        TextView mTxtLaunchTitle;
        @BindView(R.id.txt_adapter_launch_date)
        TextView mTxtLaunchDate;

        public LaunchesViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnLaunchListItemClickListener.onItemClicked(mLaunches.get(getAdapterPosition()));
                }
            });
        }

        void bind(LaunchEntity launch){
            if(launch.getMissionPatch()!=null) {
                Picasso.get().load(launch.getMissionPatch()).into(mImgLaunchPatch);
            }
            mTxtLaunchTitle.setText(launch.getMissionName());
            mTxtLaunchDate.setText(DateConverter.convertToDateSimpleFormat(launch.getLaunchDateUtc()));
        }

    }

    @NonNull
    @Override
    public LaunchesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_launch_list,viewGroup,false);
        view.setFocusable(true);
        return new LaunchesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaunchesViewHolder viewHolder, int i) {
        viewHolder.bind(mLaunches.get(i));
    }

    @Override
    public int getItemCount() {
        return mLaunches == null ? 0 : mLaunches.size();
    }

    public void setLaunches(List<LaunchEntity> launches) {
        this.mLaunches = launches;
        notifyDataSetChanged();

    }

}
