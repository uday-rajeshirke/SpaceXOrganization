package com.uday.android.spacexorg.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.uday.android.spacexorg.ui.utils.DateConverter;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.HistoryEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoryListAdapter extends RecyclerView.Adapter<HistoryListAdapter.ListViewHolder> {

    private List<HistoryEntity> mAllHistoryList;
    private OnWeblinkClickListener mOnWebLinkItemClickListener;

    public HistoryListAdapter(OnWeblinkClickListener onWeblinkClickListener) {
        this.mOnWebLinkItemClickListener = onWeblinkClickListener;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.adapter_history_list,viewGroup,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        listViewHolder.bind(mAllHistoryList.get(i));
    }

    @Override
    public int getItemCount() {
        return mAllHistoryList == null ? 0 : mAllHistoryList.size();
    }

    public void setAllHistoryList(List<HistoryEntity> mAllHistoryList) {
        this.mAllHistoryList = mAllHistoryList;
        notifyDataSetChanged();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_adapter_history_date)
        TextView mTxtHistoryDate;
        @BindView(R.id.txt_adapter_history_title)
        TextView mTxtHistoryTitle;
        @BindView(R.id.txt_adapter_history_details)
        TextView mTxtHistoryDetails;
        @BindView(R.id.btn_adapter_history_article)
        Button mBtnHistoryArticle;
        @BindView(R.id.btn_adapter_history_wikipedia)
        Button mBtnWikipedia;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.btn_adapter_history_article)
        public void articleClicked() {
            mOnWebLinkItemClickListener.onArticleLinkClicked(mAllHistoryList.get(getAdapterPosition()).getArticle());
        }

        @OnClick(R.id.btn_adapter_history_wikipedia)
        public void wikiClicked() {
            mOnWebLinkItemClickListener.onWikiLinkClicked(mAllHistoryList.get(getAdapterPosition()).getWikipedia());
        }

        void bind(HistoryEntity historyEntity){
            mTxtHistoryDate.setText(DateConverter.convertHistoryToDateSimpleFormat(historyEntity.getEventDateUtc()));
            mTxtHistoryTitle.setText(historyEntity.getTitle());
            mTxtHistoryDetails.setText(historyEntity.getDetails());
        }
    }
}
