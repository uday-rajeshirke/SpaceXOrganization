package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.entity.LaunchEntity;

public class LaunchLocalAsyncTask extends AsyncTask<LaunchEntity[],Void, Void> {

    private AppDatabase mDatabase;

    public LaunchLocalAsyncTask(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    @Override
    protected Void doInBackground(LaunchEntity[]... launchEntities) {
        mDatabase.launchDao().insertAllLaunches(launchEntities[0]);
        return null;
    }

}
