package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.network.model.capsule.Capsule;
import com.uday.android.spacexorg.network.model.company.Company;
import com.uday.android.spacexorg.network.model.core.Core;
import com.uday.android.spacexorg.network.model.history.History;
import com.uday.android.spacexorg.network.model.photos.Flickr;
import com.uday.android.spacexorg.network.model.roadster.Roadster;
import com.uday.android.spacexorg.network.model.rocket.Rocket;
import com.uday.android.spacexorg.network.model.ship.Ship;
import com.uday.android.spacexorg.network.networkapicall.NetworkApiCall;
import com.uday.android.spacexorg.network.model.launch.Launch;
import com.uday.android.spacexorg.network.networkapicall.NetworkFlickrApiCall;
import com.uday.android.spacexorg.network.postinterface.NetworkPostExecute;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkDataAsyncTask extends AsyncTask<Integer,Void, Void> {

    private NetworkPostExecute mNetworkPostExecute;

    public NetworkDataAsyncTask(NetworkPostExecute networkPostExecute) {
        this.mNetworkPostExecute = networkPostExecute;
    }

    @Override
    protected Void doInBackground(Integer... integers) {

        int mObjectType = integers[0];

        switch (mObjectType) {

            case DataRepository.OBJECT_TYPE_LAUNCH:

                Call<List<Launch>> mLaunchNetworkCall = NetworkApiCall.getSpaceXInstance().getAllLaunches();
                mLaunchNetworkCall.enqueue(new Callback<List<Launch>>() {

                    @Override
                    public void onResponse(Call<List<Launch>> call, Response<List<Launch>> response) {
                        mNetworkPostExecute.getAllLaunch(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Launch>> call, Throwable t) {

                    }

                });
                break;

            case DataRepository.OBJECT_TYPE_ROADSTER:
                Call<Roadster> mRoadsterNetworkCall = NetworkApiCall.getSpaceXInstance().getRoadster();
                mRoadsterNetworkCall.enqueue(new Callback<Roadster>() {
                    @Override
                    public void onResponse(Call<Roadster> call, Response<Roadster> response) {
                        mNetworkPostExecute.getRoadster(response.body());
                    }

                    @Override
                    public void onFailure(Call<Roadster> call, Throwable t) {

                    }
                });
                break;

            case DataRepository.OBJECT_TYPE_HISTORY:
                Call<List<History>> mHistoryNetworkCall = NetworkApiCall.getSpaceXInstance().getAllHistory();
                mHistoryNetworkCall.enqueue(new Callback<List<History>>() {

                    @Override
                    public void onResponse(Call<List<History>> call, Response<List<History>> response) {
                        mNetworkPostExecute.getAllHistory(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<History>> call, Throwable t) {

                    }

                });
                break;

            case DataRepository.OBJECT_TYPE_ROCKET:
                Call<List<Rocket>> mRocketNetworkCall = NetworkApiCall.getSpaceXInstance().getAllRockets();
                mRocketNetworkCall.enqueue(new Callback<List<Rocket>>() {
                    @Override
                    public void onResponse(Call<List<Rocket>> call, Response<List<Rocket>> response) {
                        mNetworkPostExecute.getAllRockets(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Rocket>> call, Throwable t) {

                    }
                });
                break;

            case DataRepository.OBJECT_TYPE_CAPSULE:
                Call<List<Capsule>> mCapsuleNetworkCall = NetworkApiCall.getSpaceXInstance().getAllCapsules();
                mCapsuleNetworkCall.enqueue(new Callback<List<Capsule>>() {
                    @Override
                    public void onResponse(Call<List<Capsule>> call, Response<List<Capsule>> response) {
                        mNetworkPostExecute.getAllCapsules(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Capsule>> call, Throwable t) {

                    }
                });
                break;

            case DataRepository.OBJECT_TYPE_SHIP:
                Call<List<Ship>> mShipNetworkCall = NetworkApiCall.getSpaceXInstance().getAllShips();
                mShipNetworkCall.enqueue(new Callback<List<Ship>>() {
                    @Override
                    public void onResponse(Call<List<Ship>> call, Response<List<Ship>> response) {
                        mNetworkPostExecute.getAllShips(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Ship>> call, Throwable t) {

                    }
                });
                break;

            case DataRepository.OBJECT_TYPE_CORE:
                Call<List<Core>> mCoreNetworkCall = NetworkApiCall.getSpaceXInstance().getAllCores();
                mCoreNetworkCall.enqueue(new Callback<List<Core>>() {
                    @Override
                    public void onResponse(Call<List<Core>> call, Response<List<Core>> response) {
                        mNetworkPostExecute.getAllCores(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Core>> call, Throwable t) {

                    }
                });
                break;

            case DataRepository.OBJECT_TYPE_COMPANY:
                Call<Company> mCompanyNetworkCall = NetworkApiCall.getSpaceXInstance().getCompany();
                mCompanyNetworkCall.enqueue(new Callback<Company>() {

                    @Override
                    public void onResponse(Call<Company> call, Response<Company> response) {
                        mNetworkPostExecute.getCompany(response.body());
                    }

                    @Override
                    public void onFailure(Call<Company> call, Throwable t) {

                    }
                });
                break;

            case DataRepository.OBJECT_TYPE_PHOTOS:
                Call<Flickr> mPhotoNetworkCall = NetworkFlickrApiCall.getFlickrInstance().getAllFlickrPhotos();

                mPhotoNetworkCall.enqueue(new Callback<Flickr>() {
                    @Override
                    public void onResponse(Call<Flickr> call, Response<Flickr> response) {
                        if (response.body() != null) {
                            mNetworkPostExecute.getPhotos(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Flickr> call, Throwable t) {

                    }
                });
                break;

        }
        return null;
    }

}
