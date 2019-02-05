package com.uday.android.spacexorg.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.net.Uri;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uday.android.spacexorg.MainActivity;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.ui.adapter.HistoryListAdapter;
import com.uday.android.spacexorg.ui.adapter.OnWeblinkClickListener;
import com.uday.android.spacexorg.ui.viewmodel.HistoryListViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HistoryActivity extends MainActivity  {

    private HistoryListViewModel mHistoryListViewModel;
    private HistoryListAdapter mHistoryListAdapter;
    private InterstitialAd mInterstitialAd;
    private Unbinder mUnBinder;

    @BindView(R.id.toolbar_history)
    Toolbar toolbar;
    @BindView(R.id.recycler_view_history_list)
    RecyclerView mRecyclerViewAllHistoryList;
    @BindView(R.id.txt_history_no_connection)
    TextView mTxtNoConnection;
    @BindView(R.id.progress_bar_history)
    ProgressBar mProgressBar;
    @BindView(R.id.lyt_history_no_connection)
    FrameLayout mNoConnectionLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_history,mFrameLayoutContentHolder);
        mUnBinder = ButterKnife.bind(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mHistoryListViewModel = ViewModelProviders.of(this).get(HistoryListViewModel.class);

        mRecyclerViewAllHistoryList.setLayoutManager(new LinearLayoutManager(this));
        mHistoryListAdapter = new HistoryListAdapter(new AdapterListener());
        mRecyclerViewAllHistoryList.setAdapter(mHistoryListAdapter);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(getString(R.string.test_device_id)).build());

    }

    @Override
    protected void onResume() {
        super.onResume();
        observeLiveData();
    }

    private void observeLiveData() {
        mHistoryListViewModel.getAllHistoryData().observe(this,
            historyEntities ->  {
                if (historyEntities != null && historyEntities.size() != 0) {
                    mHistoryListAdapter.setAllHistoryList(historyEntities);
                    mRecyclerViewAllHistoryList.setVisibility(View.VISIBLE);
                    mProgressBar.setVisibility(View.GONE);
                    mNoConnectionLayout.setVisibility(View.GONE);

                } else {
                    mRecyclerViewAllHistoryList.setVisibility(View.GONE);
                    mProgressBar.setVisibility(View.VISIBLE);
                    mNoConnectionLayout.setVisibility(View.VISIBLE);
                    mHistoryListViewModel.insertAllHistoryData();
                }
        });
    }

    private void showInterstitial() {
        if (mInterstitialAd != null && mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }

    private class AdapterListener implements OnWeblinkClickListener {

        private CustomTabsIntent.Builder builder;
        private CustomTabsIntent customTabsIntent;

        @Override
        public void onArticleLinkClicked(String url) {
            this.builder = new CustomTabsIntent.Builder();
            builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
            customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }

        @Override
        public void onWikiLinkClicked(String url) {
            this.builder = new CustomTabsIntent.Builder();
            builder.setToolbarColor(getResources().getColor(R.color.colorPrimary));
            customTabsIntent = builder.build();
            customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(url));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        showInterstitial();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null) {
            mUnBinder.unbind();
            mUnBinder = null;
        }
    }
}
