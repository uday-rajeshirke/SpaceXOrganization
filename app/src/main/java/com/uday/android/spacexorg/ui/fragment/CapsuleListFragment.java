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
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.ui.activity.VehiclesActivity;
import com.uday.android.spacexorg.ui.adapter.OnAdapterItemClickListener;
import com.uday.android.spacexorg.ui.adapter.VehicleListAdapter;
import com.uday.android.spacexorg.ui.viewmodel.CapsulesListViewModel;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CapsuleListFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int mSectionNumber;
    private CapsulesListViewModel mViewModel;
    private Unbinder mUnBinder;
    private VehicleListAdapter mVehicleListAdapter;

    @BindView(R.id.recycler_view_capsules)
    RecyclerView mListCapsules;
    @BindView(R.id.txt_capsules_no_connection)
    TextView mTxtNoConnection;
    @BindView(R.id.progress_bar_capsules)
    ProgressBar mProgressBar;

    public CapsuleListFragment() {

    }

    public static CapsuleListFragment newInstance(int sectionNumber) {
        CapsuleListFragment fragment = new CapsuleListFragment();
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
        return inflater.inflate(R.layout.fragment_capsule_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, view);
        mVehicleListAdapter = new VehicleListAdapter(mSectionNumber,new AdapterListener());
        mListCapsules.setHasFixedSize(true);
        mListCapsules.setAdapter(mVehicleListAdapter);
        mListCapsules.addItemDecoration(
                new DividerItemDecoration(
                        Objects.requireNonNull(getContext()),
                        DividerItemDecoration.VERTICAL));
        mListCapsules.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CapsulesListViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {
        mViewModel.getAllCapsuleData().observe(this, capsuleEntities -> {
            if (capsuleEntities != null  && capsuleEntities.size() != 0) {
                mVehicleListAdapter.setCapsules(capsuleEntities);
                mListCapsules.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            } else {
                mListCapsules.setVisibility(View.GONE);
                mProgressBar.setVisibility(View.VISIBLE);
                mViewModel.insertAllCapsuleData();
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
