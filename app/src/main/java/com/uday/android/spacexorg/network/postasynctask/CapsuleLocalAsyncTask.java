package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.entity.CapsuleEntity;

public class CapsuleLocalAsyncTask extends AsyncTask<CapsuleEntity[],Void, Void> {

    private AppDatabase mDatabase;

    public CapsuleLocalAsyncTask(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    @Override
    protected Void doInBackground(CapsuleEntity[]... capsuleEntities) {
        mDatabase.capsuleDao().insertAllCapsules(capsuleEntities[0]);
        return null;
    }
}
