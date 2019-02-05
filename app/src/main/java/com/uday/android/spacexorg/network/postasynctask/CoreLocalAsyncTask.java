package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.entity.CoreEntity;

public class CoreLocalAsyncTask extends AsyncTask<CoreEntity[],Void, Void> {

    private AppDatabase mDatabase;

    public CoreLocalAsyncTask(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    @Override
    protected Void doInBackground(CoreEntity[]... coreEntities) {
        mDatabase.coreDao().insertAllCores(coreEntities[0]);
        return null;
    }
}
