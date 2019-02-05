package com.uday.android.spacexorg.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.ui.utils.AboutAppDetails;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class AboutAppListAdapter extends RecyclerView.Adapter<AboutAppListAdapter.CreditsViewHolder> {

    private List<AboutAppDetails> mCredits;

    public class CreditsViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image_adapter_about_app)
        ImageView mImgIcon;
        @BindView(R.id.txt_adapter_about_app_author)
        TextView mTxtAuthor;
        @BindView(R.id.txt_adapter_about_app_provider)
        TextView mTxtProvider;

        public CreditsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(AboutAppDetails aboutAppDetails){

            mImgIcon.setImageResource(aboutAppDetails.getIcon());
            mTxtAuthor.setText(aboutAppDetails.getAuthor());
            mTxtProvider.setText(aboutAppDetails.getProvider());

        }

    }

    @NonNull
    @Override
    public CreditsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_about_app_list,viewGroup,false);
        view.setFocusable(true);
        return new CreditsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CreditsViewHolder viewHolder, int i) {
        viewHolder.bind(mCredits.get(i));
    }

    @Override
    public int getItemCount() {
        return mCredits == null ? 0 : mCredits.size();
    }

    public void setCredits(List<AboutAppDetails> credits) {
        this.mCredits = credits;
        notifyDataSetChanged();
    }
}
