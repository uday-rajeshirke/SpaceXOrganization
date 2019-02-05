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
import com.uday.android.spacexorg.ui.viewmodel.ShipListViewModel;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ShipsListFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private int mSectionNumber;
    private ShipListViewModel mViewModel;
    private Unbinder mUnBinder;
    private VehicleListAdapter mVehicleListAdapter;

    @BindView(R.id.recycler_view_ships)
    RecyclerView mListShips;
    @BindView(R.id.txt_ships_no_connection)
    TextView mTxtNoConnection;
    @BindView(R.id.progress_bar_ships)
    ProgressBar mProgressBar;


    public ShipsListFragment() {
        // Required empty public constructor
    }

    public static ShipsListFragment newInstance(int sectionNumber) {
        ShipsListFragment fragment = new ShipsListFragment();
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ships_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, view);
        mVehicleListAdapter = new VehicleListAdapter(mSectionNumber,new AdapterListener());
        mListShips.setHasFixedSize(true);
        mListShips.setAdapter(mVehicleListAdapter);
        mListShips.addItemDecoration(
                new DividerItemDecoration(
                        Objects.requireNonNull(getContext()),
                        DividerItemDecoration.VERTICAL));
        mListShips.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ShipListViewModel.class);
        observeLiveData();
    }

    private void observeLiveData() {
        mViewModel.getAllShipsData().observe(this, shipEntities -> {
            if (shipEntities != null && shipEntities.size() != 0) {
                mVehicleListAdapter.setShips(shipEntities);
                mListShips.setVisibility(View.VISIBLE);
                mProgressBar.setVisibility(View.GONE);
            } else {
                mProgressBar.setVisibility(View.VISIBLE);
                mListShips.setVisibility(View.GONE);
                mViewModel.insertAllShipData();
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
