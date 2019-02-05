package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.entity.RoadsterEntity;

public class RoadsterLocalAsyncTask extends AsyncTask<RoadsterEntity,Void, Void> {

    private AppDatabase mDatabase;

    public RoadsterLocalAsyncTask(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    @Override
    protected Void doInBackground(RoadsterEntity... roadsterEntities) {
        mDatabase.roadsterDao().insertRoadster(roadsterEntities[0]);
        return null;
    }
}
