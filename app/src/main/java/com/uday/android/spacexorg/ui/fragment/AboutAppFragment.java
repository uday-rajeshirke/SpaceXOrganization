package com.uday.android.spacexorg.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.ui.adapter.AboutAppListAdapter;
import com.uday.android.spacexorg.ui.utils.AboutAppDetails;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class AboutAppFragment extends Fragment {

    private DrawerLayout mDrawer;
    private Unbinder mUnBinder;
    private AboutAppListAdapter mAboutAppListAdapter;

    @BindView(R.id.recycler_view_frag_about_app)
    public RecyclerView mRecyclerViewList;

    @BindView(R.id.toolbar_frag_about_app)
    public Toolbar mToolbar;

    public static AboutAppFragment newInstance() {
        return new AboutAppFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_about_app, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnBinder = ButterKnife.bind(this, view);
        if(getActivity()!=null) {
            mDrawer = getActivity().findViewById(R.id.drawer_layout);
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    getActivity(), mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            mDrawer.addDrawerListener(toggle);
            toggle.syncState();
        }

        mAboutAppListAdapter = new AboutAppListAdapter();
        mRecyclerViewList.setHasFixedSize(true);
        mRecyclerViewList.setAdapter(mAboutAppListAdapter);
        mRecyclerViewList.addItemDecoration(
                new DividerItemDecoration(
                        Objects.requireNonNull(getContext()),
                        DividerItemDecoration.VERTICAL));
        mRecyclerViewList.setLayoutManager(new LinearLayoutManager(getContext()));

        List<AboutAppDetails> credits=new ArrayList<>();
        credits.add(new AboutAppDetails(R.drawable.ic_launch_location_maker_black,getString(R.string.text_about_app_1),getString(R.string.text_flaticon)));
        credits.add(new AboutAppDetails(R.drawable.ic_convertible_roadster,getString(R.string.text_about_app_2),getString(R.string.text_flaticon)));
        credits.add(new AboutAppDetails(R.drawable.ic_gallery,getString(R.string.text_about_app_2),getString(R.string.text_flaticon)));
        credits.add(new AboutAppDetails(R.drawable.ic_history,getString(R.string.text_about_app_3),getString(R.string.text_flaticon)));
        credits.add(new AboutAppDetails(R.drawable.ic_rocket,getString(R.string.text_about_app_4),getString(R.string.text_flaticon)));
        credits.add(new AboutAppDetails(R.drawable.ic_rocket_launch,getString(R.string.text_about_app_4),getString(R.string.text_flaticon)));
        credits.add(new AboutAppDetails(R.drawable.ic_rocket_ship,getString(R.string.text_about_app_5),getString(R.string.text_flaticon)));
        credits.add(new AboutAppDetails(R.drawable.ic_rocket_icon,getString(R.string.text_about_app_6),getString(R.string.text_flaticon)));
        credits.add(new AboutAppDetails(R.drawable.ic_check_box_outline_blank_24dp,getString(R.string.text_about_app_7),getString(R.string.text_github)));

        mAboutAppListAdapter.setCredits(credits);

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
