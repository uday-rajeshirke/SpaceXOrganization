package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.entity.RocketEntity;

public class RocketLocalAsyncTask extends AsyncTask<RocketEntity[],Void, Void> {

    private AppDatabase mDatabase;

    public RocketLocalAsyncTask(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    @Override
    protected Void doInBackground(RocketEntity[]... rocketEntities) {
        mDatabase.rocketDao().insertAlRocket(rocketEntities[0]);
        return null;
    }
}
