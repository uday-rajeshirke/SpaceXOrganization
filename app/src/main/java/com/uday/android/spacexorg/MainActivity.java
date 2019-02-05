package com.uday.android.spacexorg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.uday.android.spacexorg.ui.activity.CoresActivity;
import com.uday.android.spacexorg.ui.activity.GalleryActivity;
import com.uday.android.spacexorg.ui.activity.HistoryActivity;
import com.uday.android.spacexorg.ui.activity.LaunchesActivity;
import com.uday.android.spacexorg.ui.activity.RoadsterActivity;
import com.uday.android.spacexorg.ui.activity.VehiclesActivity;
import com.uday.android.spacexorg.ui.fragment.AboutAppFragment;
import com.uday.android.spacexorg.ui.fragment.AboutCompanyFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    protected DrawerLayout mDrawer;
    private NavigationView mNavigationView;
    protected FrameLayout mFrameLayoutContentHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFrameLayoutContentHolder = findViewById(R.id.layout_content_holder);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mNavigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_launch) {
            startActivity(new Intent(this,LaunchesActivity.class));
        } else if (id == R.id.nav_roadster) {
            startActivity(new Intent(this,RoadsterActivity.class));
        } else if (id == R.id.nav_vehicles) {
            startActivity(new Intent(this,VehiclesActivity.class));
        } else if (id == R.id.nav_cores) {
            startActivity(new Intent(this, CoresActivity.class));
        } else if (id == R.id.nav_history) {
            startActivity(new Intent(this,HistoryActivity.class));
        } else if (id == R.id.nav_gallery) {
            startActivity(new Intent(this, GalleryActivity.class));
        } else if (id == R.id.nav_about_company) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("about_fragments")
                    .replace(R.id.layout_content_holder,
                            AboutCompanyFragment.newInstance(), null).commit();
        } else if (id == R.id.nav_about_app) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .addToBackStack("about_fragments")
                    .replace(R.id.layout_content_holder,
                            AboutAppFragment.newInstance(), null).commit();
        }

        //DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
