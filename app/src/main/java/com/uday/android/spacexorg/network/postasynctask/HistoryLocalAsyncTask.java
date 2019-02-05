package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.entity.HistoryEntity;

public class HistoryLocalAsyncTask extends AsyncTask<HistoryEntity[],Void, Void> {

    private AppDatabase mDatabase;

    public HistoryLocalAsyncTask(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    @Override
    protected Void doInBackground(HistoryEntity[]... historyEntities) {
        mDatabase.historyDao().insertAllHistory(historyEntities[0]);
        return null;
    }
}
