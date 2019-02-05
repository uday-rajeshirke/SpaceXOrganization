package com.uday.android.spacexorg.ui.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.uday.android.spacexorg.MainActivity;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.database.entity.LaunchEntity;
import com.uday.android.spacexorg.ui.adapter.SectionsPagerAdapter;
import com.uday.android.spacexorg.ui.fragment.LaunchDetailsFragment;
import com.uday.android.spacexorg.ui.fragment.LaunchMapFragment;
import com.uday.android.spacexorg.ui.fragment.PastLaunchesListFragment;
import com.uday.android.spacexorg.ui.fragment.UpcomingLaunchesListFragment;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class LaunchesActivity extends MainActivity {

    public static final int FRAGMENT_TYPE_DETAILS = 0;
    public static final int FRAGMENT_TYPE_MAP = 1;

    private Unbinder mUnBinder;

    @BindView(R.id.container_launches)
    ViewPager mViewPager;

    @BindView(R.id.toolbar_launches)
    Toolbar toolbar;

    @BindView(R.id.tabs_launches)
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_launches,mFrameLayoutContentHolder);

        MobileAds.initialize(this, getString(R.string.admob_app_id));
        mUnBinder = ButterKnife.bind(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        List<Fragment> mFragmentList = new ArrayList<>();
        mFragmentList.add(0,UpcomingLaunchesListFragment.newInstance());
        mFragmentList.add(1,PastLaunchesListFragment.newInstance());

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    public void openFragment(int fragmentType, LaunchEntity launchEntity) {

        Fragment mCurrentFragment = null;

        switch (fragmentType) {

            case FRAGMENT_TYPE_DETAILS :
                mCurrentFragment = LaunchDetailsFragment.newInstance(launchEntity.getFlightNumber());
                break;

            case FRAGMENT_TYPE_MAP :
                mCurrentFragment = LaunchMapFragment.newInstance(launchEntity.getLaunchSiteId());
                break;

        }

        if (mCurrentFragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack(getString(R.string.tag_launch_back_stack))
                    .replace(R.id.launches_frag_container,
                            mCurrentFragment, null).commit();
        }

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
