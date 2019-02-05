package com.uday.android.spacexorg.ui.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.uday.android.spacexorg.ui.utils.DateConverter;
import com.uday.android.spacexorg.MainActivity;
import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.ui.viewmodel.RoadsterViewModel;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RoadsterActivity extends MainActivity {

    private Unbinder mUnBinder;
    private RoadsterViewModel mRoadsterViewModel;

    @BindView(R.id.toolbar_roadster)
    Toolbar mToolbar;
    @BindView(R.id.image_roadster)
    ImageView mImageRoadster;
    @BindView(R.id.txt_name_roadster_details)
    TextView mTxtRoadsterName;
    @BindView(R.id.txt_launch_date_roadster_details)
    TextView mTxtRoadsterLaunchDate;
    @BindView(R.id.txt_speed_roadster_details)
    TextView mTxtRoadsterSpeed;
    @BindView(R.id.txt_earth_distance_roadster_details)
    TextView mTxtRoadsterEarthDistance;
    @BindView(R.id.txt_mars_distance_roadster_details)
    TextView mTxtRoadsterMarsDistance;
    @BindView(R.id.txt_orbit_type_roadster_orbit)
    TextView mTxtRoadsterOrbitType;
    @BindView(R.id.txt_period_roadster_orbit)
    TextView mTxtRoadsterPeriod;
    @BindView(R.id.txt_inclination_roadster_orbit)
    TextView mTxtRoadsterInclination;
    @BindView(R.id.txt_longitude_roadster_orbit)
    TextView mTxtRoadsterLongitude;
    @BindView(R.id.txt_apoapsis_roadster_orbit)
    TextView mTxtRoadsterApoapsis;
    @BindView(R.id.txt_periapsis_roadster_orbit)
    TextView mTxtRoadsterPeriapsis;
    @BindView(R.id.txt_semimajor_axis_roadster_orbit)
    TextView mTxtRoadsterSemimajorAxis;
    @BindView(R.id.txt_details_roadster_details)
    TextView mTxtRoadsterDetails;
    @BindView(R.id.ad_view)
    AdView mAdView;
    @BindView(R.id.lyt_roadster)
    FrameLayout mLayoutNoConnection;
    @BindView(R.id.txt_roadster_no_connection)
    TextView mTxtNoConnection;
    @BindView(R.id.progress_bar_roadster)
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_roadster,mFrameLayoutContentHolder);
        MobileAds.initialize(this, getString(R.string.admob_app_id));
        mUnBinder = ButterKnife.bind(this);

        mToolbar.setTitle(getString(R.string.title_fragment_roadster));
        setSupportActionBar(mToolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

    }

    private void observeLiveData() {
        mRoadsterViewModel.getRoadsterData().observe(this, roadsterEntity -> {
            if(roadsterEntity!=null) {
                mProgressBar.setVisibility(View.GONE);
                mLayoutNoConnection.setVisibility(View.GONE);
                mAdView.setVisibility(View.VISIBLE);
                mTxtRoadsterName.setText(roadsterEntity.getName());
                mTxtRoadsterLaunchDate.setText(DateConverter.convertToDateSimpleFormat(roadsterEntity.getLaunchDateUtc()));
                String speed = roadsterEntity.getSpeedKph()+ getString(R.string.kmperhour);
                mTxtRoadsterSpeed.setText(speed);
                String earthDistance = roadsterEntity.getEarthDistanceKm() + getString(R.string.km);
                mTxtRoadsterEarthDistance.setText(earthDistance);
                String marsDistance = roadsterEntity.getMarsDistanceKm() + getString(R.string.km);
                mTxtRoadsterMarsDistance.setText(marsDistance);
                mTxtRoadsterOrbitType.setText(roadsterEntity.getOrbitType());
                String period = roadsterEntity.getPeriodDays() + getString(R.string.days);
                mTxtRoadsterPeriod.setText(period);
                String inclination = roadsterEntity.getInclination() + getString(R.string.degree);
                mTxtRoadsterInclination.setText(inclination);
                String longitude = roadsterEntity.getLongitude() + getString(R.string.degree);
                mTxtRoadsterLongitude.setText(longitude);
                String apoapsis = roadsterEntity.getApoapsisAu() + getString(R.string.astronomical_unit);
                mTxtRoadsterApoapsis.setText(apoapsis);
                String periapsis = roadsterEntity.getPeriapsisAu() + getString(R.string.astronomical_unit);
                mTxtRoadsterPeriapsis.setText(periapsis);
                String semiMajorAxis = roadsterEntity.getSemiMajorAxisAu() + getString(R.string.astronomical_unit);
                mTxtRoadsterSemimajorAxis.setText(semiMajorAxis);
                mTxtRoadsterDetails.setText(roadsterEntity.getDetails());
            } else {
                mProgressBar.setVisibility(View.VISIBLE);
                mLayoutNoConnection.setVisibility(View.VISIBLE);
                mRoadsterViewModel.insertRoadsterData();
            }
        });
    }

    @Override
    protected void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRoadsterViewModel = ViewModelProviders.of(this).get(RoadsterViewModel.class);
        observeLiveData();
        if (mAdView != null) {
            mAdView.resume();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mAdView != null) {
            mAdView.destroy();
        }

        if (mUnBinder != null) {
            mUnBinder.unbind();
            mUnBinder = null;
        }
    }
}
