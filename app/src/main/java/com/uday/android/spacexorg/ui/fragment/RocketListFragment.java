package com.uday.android.spacexorg.ui.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.ui.activity.VehiclesActivity;
import com.uday.android.spacexorg.ui.adapter.OnAdapterItemClickListener;
import com.uday.android.spacexorg.ui.adapter.VehicleListAdapter;
import com.uday.android.spacexorg.ui.viewmodel.RocketListViewModel;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class RocketListFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int mSectionNumber;
    private RocketListViewModel mViewModel;
    private Unbinder mUnBinder;
    private VehicleListAdapter mVehicleListAdapter;

    @BindView(R.id.recycler_view_rockets)
    RecyclerView mListRockets;
    @BindView(R.id.lyt_rocket_connection)
    FrameLayout mNoConnectionLayout;
    @BindView(R.id.txt_rockets_no_connection)
    TextView mTxtNoConnection;
    @BindView(R.id.progress_bar_rockets)
    ProgressBar mProgressBar;


    public RocketListFragment() {
        // Required empty public constructor
    }

    public static RocketListFragment newInstance(int sectionNumber) {
        RocketListFragment fragment = new RocketListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mSectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rocket_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, view);
        mVehicleListAdapter = new VehicleListAdapter(mSectionNumber,new AdapterListener());
        mListRockets.setHasFixedSize(true);
        mListRockets.setAdapter(mVehicleListAdapter);
        mListRockets.addItemDecoration(
                new DividerItemDecoration(
                        Objects.requireNonNull(getContext()),
                        DividerItemDecoration.VERTICAL));
        mListRockets.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RocketListViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {
        mViewModel.getAllRocketData().observe(this, rocketEntities -> {
            if (rocketEntities != null && rocketEntities.size() != 0) {
                mVehicleListAdapter.setRockets(rocketEntities);
                mListRockets.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
                mNoConnectionLayout.setVisibility(View.GONE);
            } else {
                mProgressBar.setVisibility(View.VISIBLE);
                mNoConnectionLayout.setVisibility(View.VISIBLE);
                mViewModel.insertAllRocketData();
            }
        });
    }

    private class AdapterListener implements OnAdapterItemClickListener {

        @Override
        public void onItemClicked(Object objectEntity) {
            if(getActivity() != null) {
                ((VehiclesActivity) getActivity()).showDetails(mSectionNumber,objectEntity);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnBinder != null) {
            mUnBinder.unbind();
            mUnBinder = null;
        }
    }
}
