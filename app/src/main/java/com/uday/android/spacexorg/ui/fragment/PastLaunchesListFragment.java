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
import com.uday.android.spacexorg.database.entity.LaunchEntity;
import com.uday.android.spacexorg.ui.activity.LaunchesActivity;
import com.uday.android.spacexorg.ui.adapter.LaunchesListAdapter;
import com.uday.android.spacexorg.ui.adapter.OnAdapterItemClickListener;
import com.uday.android.spacexorg.ui.viewmodel.LaunchesListViewModel;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class PastLaunchesListFragment extends Fragment {

    private LaunchesListViewModel mViewModel;
    private Unbinder mUnBinder;
    private LaunchesListAdapter mLaunchesListAdapter;

    @BindView(R.id.recycler_view_past_launches)
    RecyclerView mListPastLaunches;
    @BindView(R.id.txt_past_launches_no_connection)
    TextView mTxtNoConnection;
    @BindView(R.id.progress_bar_past_launches)
    ProgressBar mProgressBar;

    public static PastLaunchesListFragment newInstance() {
        return new PastLaunchesListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_launch_past_list, container, false);
        mUnBinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(LaunchesListViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {

        mViewModel.getAllPastLaunchData().observe(this,launchEntities -> {
            mProgressBar.setVisibility(View.VISIBLE);
            mListPastLaunches.setVisibility(View.GONE);
            if (launchEntities != null && launchEntities.size() != 0) {
                mLaunchesListAdapter.setLaunches(launchEntities);
                mListPastLaunches.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mLaunchesListAdapter = new LaunchesListAdapter(new AdapterListener());
        mListPastLaunches.setHasFixedSize(true);
        mListPastLaunches.setAdapter(mLaunchesListAdapter);
        mListPastLaunches.addItemDecoration(
                new DividerItemDecoration(
                        Objects.requireNonNull(getContext()),
                        DividerItemDecoration.VERTICAL));
        mListPastLaunches.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private class AdapterListener implements OnAdapterItemClickListener {
        @Override
        public void onItemClicked(Object objectEntity) {
            if(getActivity() != null) {
                ((LaunchesActivity) getActivity()).openFragment(LaunchesActivity.FRAGMENT_TYPE_DETAILS, (LaunchEntity) objectEntity);
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
