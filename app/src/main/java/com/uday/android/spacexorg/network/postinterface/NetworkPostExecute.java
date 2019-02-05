package com.uday.android.spacexorg.network.postinterface;

import com.uday.android.spacexorg.network.model.capsule.Capsule;
import com.uday.android.spacexorg.network.model.company.Company;
import com.uday.android.spacexorg.network.model.core.Core;
import com.uday.android.spacexorg.network.model.history.History;
import com.uday.android.spacexorg.network.model.launch.Launch;
import com.uday.android.spacexorg.network.model.photos.Flickr;
import com.uday.android.spacexorg.network.model.roadster.Roadster;
import com.uday.android.spacexorg.network.model.rocket.Rocket;
import com.uday.android.spacexorg.network.model.ship.Ship;

import java.util.List;

public interface NetworkPostExecute {
    void getAllLaunch(List<Launch> launchList);
    void getRoadster(Roadster roadster);
    void getAllRockets(List<Rocket> rocketList);
    void getAllCapsules(List<Capsule> capsuleList);
    void getAllShips(List<Ship> shipList);
    void getAllCores(List<Core> coreList);
    void getAllHistory(List<History> historyList);
    void getCompany(Company company);
    void getPhotos(Flickr flickr);
}
