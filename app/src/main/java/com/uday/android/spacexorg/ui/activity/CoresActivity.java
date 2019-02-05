package com.uday.android.spacexorg.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uday.android.spacexorg.MainActivity;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.ui.adapter.CoresListAdapter;
import com.uday.android.spacexorg.ui.viewmodel.CoreListViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CoresActivity extends MainActivity {

    private Unbinder mUnBinder;
    private CoreListViewModel mViewModel;
    private CoresListAdapter mCoresListAdapter;

    @BindView(R.id.toolbar_cores)
    Toolbar mToolbar;
    @BindView(R.id.recycler_view_cores)
    RecyclerView mListCores;
    @BindView(R.id.lyt_cores_connection)
    FrameLayout mNoConnectionLayout;
    @BindView(R.id.txt_cores_no_connection)
    TextView mTxtNoConnection;
    @BindView(R.id.progress_bar_cores)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_cores,mFrameLayoutContentHolder);
        mUnBinder = ButterKnife.bind(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        mCoresListAdapter = new CoresListAdapter();
        mListCores.setHasFixedSize(true);
        mListCores.setAdapter(mCoresListAdapter);
        mListCores.addItemDecoration(
                new DividerItemDecoration(
                        this,
                        DividerItemDecoration.VERTICAL));
        mListCores.setLayoutManager(new LinearLayoutManager(this));

        mViewModel = ViewModelProviders.of(this).get(CoreListViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {

        mViewModel.getAllCoreData().observe(this,
            coreEntities -> {
                if(coreEntities!=null && coreEntities.size() != 0) {
                    mCoresListAdapter.setCores(coreEntities);
                    mListCores.setVisibility(View.VISIBLE);
                    mProgressBar.setVisibility(View.GONE);
                    mNoConnectionLayout.setVisibility(View.GONE);
                } else {
                    mViewModel.insertAllCoreData();
                    mProgressBar.setVisibility(View.VISIBLE);
                    mNoConnectionLayout.setVisibility(View.VISIBLE);
                    mListCores.setVisibility(View.GONE);
                }
            });
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
