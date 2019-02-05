package com.uday.android.spacexorg.network.postasynctask;

import com.uday.android.spacexorg.network.postinterface.NetworkPostExecute;
import com.treebo.internetavailabilitychecker.InternetConnectivityListener;

import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_CAPSULE;
import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_COMPANY;
import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_CORE;
import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_HISTORY;
import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_LAUNCH;
import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_PHOTOS;
import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_ROADSTER;
import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_ROCKET;
import static com.uday.android.spacexorg.database.DataRepository.OBJECT_TYPE_SHIP;

public class InternetConnectivity implements InternetConnectivityListener {

    private int mObjectType;
    private NetworkPostExecute mNetworkPostExecute;

    public InternetConnectivity(int mObjectType, NetworkPostExecute mNetworkPostExecute) {
        this.mObjectType = mObjectType;
        this.mNetworkPostExecute = mNetworkPostExecute;
    }

    @Override
    public void onInternetConnectivityChanged(boolean isConnected) {

        if(isConnected) {

            switch (mObjectType) {

                case OBJECT_TYPE_LAUNCH:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_LAUNCH);
                    break;

                case OBJECT_TYPE_ROADSTER:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_ROADSTER);
                    break;

                case OBJECT_TYPE_ROCKET:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_ROCKET);
                    break;

                case OBJECT_TYPE_CAPSULE:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_CAPSULE);
                    break;

                case OBJECT_TYPE_SHIP:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_SHIP);
                    break;

                case OBJECT_TYPE_HISTORY:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_HISTORY);
                    break;

                case OBJECT_TYPE_CORE:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_CORE);
                    break;

                case OBJECT_TYPE_COMPANY:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_COMPANY);
                    break;

                case OBJECT_TYPE_PHOTOS:
                    new NetworkDataAsyncTask(mNetworkPostExecute).execute(OBJECT_TYPE_PHOTOS);
                    break;

            }
        }
    }
}
