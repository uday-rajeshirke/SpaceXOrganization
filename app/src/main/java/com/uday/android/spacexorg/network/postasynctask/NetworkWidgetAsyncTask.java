package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.network.model.launch.Launch;
import com.uday.android.spacexorg.network.networkapicall.NetworkApiCall;
import com.uday.android.spacexorg.network.postinterface.NetworkWidgetExecute;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkWidgetAsyncTask extends AsyncTask<Void,Void,Void> {

    private NetworkWidgetExecute mNetworkWidgetExecute;

    public NetworkWidgetAsyncTask(NetworkWidgetExecute networkWidgetExecute) {
        this.mNetworkWidgetExecute = networkWidgetExecute;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        Call<Launch> mNextLaunchNetworkCall = NetworkApiCall.getSpaceXInstance().getNextLaunch();
        mNextLaunchNetworkCall.enqueue(new Callback<Launch>() {
            @Override
            public void onResponse(Call<Launch> call, Response<Launch> response) {
                mNetworkWidgetExecute.getNextLaunch(response.body(),true);
            }

            @Override
            public void onFailure(Call<Launch> call, Throwable t) {
                mNetworkWidgetExecute.getNextLaunch(null,false);
            }
        });

        return null;
    }
}
