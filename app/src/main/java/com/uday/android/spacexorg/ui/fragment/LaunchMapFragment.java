package com.uday.android.spacexorg.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uday.android.spacexorg.R;
import com.uday.android.spacexorg.network.model.launchpad.Launchpad;
import com.uday.android.spacexorg.network.postasynctask.NetworkMapAsyncTask;
import com.uday.android.spacexorg.network.postinterface.NetworkMapExecute;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;
import com.treebo.internetavailabilitychecker.InternetConnectivityListener;

import java.util.Objects;


public class LaunchMapFragment extends Fragment {

    private static final String ARG_PARAM_SITE_ID = "param_site_id";

    private String mParamSiteId;
    private Launchpad mLaunchpad;
    private SupportMapFragment mMapFragment;
    private GoogleMap mGoogleMap;
    private InternetAvailabilityChecker mInternetAvailabilityChecker;
    private InternetConnectivity mInternetConnectivity;
    private Toolbar mToolbar;
    private ConstraintLayout mConstraintLayout;

    public LaunchMapFragment() {
        // Required empty public constructor
    }

    public static LaunchMapFragment newInstance(String param1) {
        LaunchMapFragment fragment = new LaunchMapFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_SITE_ID, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamSiteId = getArguments().getString(ARG_PARAM_SITE_ID);
        }
        InternetAvailabilityChecker.init(Objects.requireNonNull(getContext()));
        mInternetAvailabilityChecker = InternetAvailabilityChecker.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_launch_map, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mConstraintLayout = view.findViewById(R.id.lyt_main_launch_map);
        mToolbar = view.findViewById(R.id.toolbar_launch_map);
        mMapFragment = ((SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.launch_map));
        if (mMapFragment != null) {
            mMapFragment.getMapAsync(new MapCallback());
        }


        if(getActivity()!=null) {
            ((AppCompatActivity) getActivity()).setSupportActionBar(mToolbar);
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
        }

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mInternetConnectivity = new InternetConnectivity();
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);

    }

    private class InternetConnectivity implements InternetConnectivityListener {

        Snackbar snackbar = Snackbar.make(mConstraintLayout, getString(R.string.text_no_internet_connection), Snackbar.LENGTH_INDEFINITE);

        @Override
        public void onInternetConnectivityChanged(boolean isConnected) {
            if(!isConnected) {
                snackbar.show();
            } else {
                if(snackbar.isShown())
                    snackbar.dismiss();
                new NetworkMapAsyncTask(new GetNetworkData()).execute(mParamSiteId);
            }
        }
    }

    private void updateUI() {
        if(getActivity()!=null) {
            LatLng latLng = new LatLng(mLaunchpad.getLocation().getLatitude(), mLaunchpad.getLocation().getLongitude());
            String locationName = mLaunchpad.getLocation().getName() + getString(R.string.text_comma) + mLaunchpad.getLocation().getRegion();

            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng)
                    .title(locationName)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

            Marker marker = mGoogleMap.addMarker(markerOptions);
            marker.setDraggable(true);
            marker.showInfoWindow();
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f));
        }
    }

    private class GetNetworkData implements NetworkMapExecute {

        public void getLaunchpad(Launchpad launchpad) {
            mLaunchpad = launchpad;
            updateUI();
        }

    }

    private class MapCallback implements OnMapReadyCallback {

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mGoogleMap = googleMap;
            mGoogleMap.setMapStyle(new MapStyleOptions(getResources()
                    .getString(R.string.style_dark_map)));
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mInternetConnectivity!=null)
            mInternetAvailabilityChecker
                    .removeInternetConnectivityChangeListener(mInternetConnectivity);
    }

}
