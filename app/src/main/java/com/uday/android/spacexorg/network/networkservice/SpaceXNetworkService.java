package com.uday.android.spacexorg.network.networkservice;

import com.uday.android.spacexorg.network.model.capsule.Capsule;
import com.uday.android.spacexorg.network.model.company.Company;
import com.uday.android.spacexorg.network.model.core.Core;
import com.uday.android.spacexorg.network.model.history.History;
import com.uday.android.spacexorg.network.model.launch.Launch;
import com.uday.android.spacexorg.network.model.launchpad.Launchpad;
import com.uday.android.spacexorg.network.model.roadster.Roadster;
import com.uday.android.spacexorg.network.model.rocket.Rocket;
import com.uday.android.spacexorg.network.model.ship.Ship;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SpaceXNetworkService {

    @GET("launches/")
    Call<List<Launch>> getAllLaunches();

    @GET("launchpads/{site_id}")
    Call<Launchpad> getLaunchpad(@Path("site_id") String siteId);

    @GET("roadster/")
    Call<Roadster> getRoadster();

    @GET("rockets/")
    Call<List<Rocket>> getAllRockets();

    @GET("dragons/")
    Call<List<Capsule>> getAllCapsules();

    @GET("ships/")
    Call<List<Ship>> getAllShips();

    @GET("cores/")
    Call<List<Core>> getAllCores();

    @GET("history/")
    Call<List<History>> getAllHistory();

    @GET("launches/next")
    Call<Launch> getNextLaunch();

    @GET("info/")
    Call<Company> getCompany();

}