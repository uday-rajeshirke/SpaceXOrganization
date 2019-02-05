package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.network.model.launchpad.Launchpad;
import com.uday.android.spacexorg.network.networkapicall.NetworkApiCall;
import com.uday.android.spacexorg.network.postinterface.NetworkMapExecute;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkMapAsyncTask extends AsyncTask<String,Void,Void> {

    private NetworkMapExecute mNetworkMapExecute;

    public NetworkMapAsyncTask(NetworkMapExecute mNetworkMapExecute) {
        this.mNetworkMapExecute = mNetworkMapExecute;
    }

    @Override
    protected Void doInBackground(String... strings) {
        String siteId = strings[0];
        Call<Launchpad> mLaunchpadNetworkCall = NetworkApiCall.getSpaceXInstance().getLaunchpad(siteId);
        mLaunchpadNetworkCall.enqueue(new Callback<Launchpad>() {
            @Override
            public void onResponse(Call<Launchpad> call, Response<Launchpad> response) {
                mNetworkMapExecute.getLaunchpad(response.body());
            }

            @Override
            public void onFailure(Call<Launchpad> call, Throwable t) {

            }
        });
        return null;
    }
}
