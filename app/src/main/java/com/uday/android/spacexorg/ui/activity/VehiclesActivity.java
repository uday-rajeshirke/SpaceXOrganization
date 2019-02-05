package com.uday.android.spacexorg.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.uday.android.spacexorg.MainActivity;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.CapsuleEntity;
import com.uday.android.spacexorg.database.entity.RocketEntity;
import com.uday.android.spacexorg.database.entity.ShipEntity;
import com.uday.android.spacexorg.ui.adapter.SectionsPagerAdapter;
import com.uday.android.spacexorg.ui.fragment.CapsuleListFragment;
import com.uday.android.spacexorg.ui.fragment.RocketListFragment;
import com.uday.android.spacexorg.ui.fragment.ShipsListFragment;
import com.uday.android.spacexorg.ui.fragment.VehicleDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class VehiclesActivity extends MainActivity {

    public static final int RL_SECTION_NUMBER = 1;
    public static final int CL_SECTION_NUMBER = 2;
    public static final int SL_SECTION_NUMBER = 3;

    private Unbinder mUnBinder;

    @BindView(R.id.container_vehicles)
    ViewPager mViewPager;
    @BindView(R.id.toolbar_vehicles)
    Toolbar mToolbar;
    @BindView(R.id.tabs_vehicles)
    TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_vehicles,mFrameLayoutContentHolder);

        mUnBinder = ButterKnife.bind(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(0,RocketListFragment.newInstance(RL_SECTION_NUMBER));
        mFragmentList.add(1,CapsuleListFragment.newInstance(CL_SECTION_NUMBER));
        mFragmentList.add(2,ShipsListFragment.newInstance(SL_SECTION_NUMBER));

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    public void showDetails(int sectionNumber, Object objectEntity) {

        Fragment mCurrentFragment = null;

        switch (sectionNumber) {

            case 1:
                mCurrentFragment = VehicleDetailsFragment.newInstance(sectionNumber, String.valueOf(((RocketEntity) objectEntity).getId()));
                break;

            case 2:
                mCurrentFragment = VehicleDetailsFragment.newInstance(sectionNumber, ((CapsuleEntity) objectEntity).getId());
                break;

            case 3:
                mCurrentFragment = VehicleDetailsFragment.newInstance(sectionNumber, ((ShipEntity) objectEntity).getShipId());
                break;

        }

        if (mCurrentFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(getString(R.string.tag_vehicle_back_stack))
                    .replace(R.id.vehicles_frag_container,
                            mCurrentFragment, null).commit();
        }

    }

    private void setNavigationMenu() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
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
