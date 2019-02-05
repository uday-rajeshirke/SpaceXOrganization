package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.entity.CompanyEntity;

public class CompanyLocalAsyncTask extends AsyncTask<CompanyEntity,Void, Void> {

    private AppDatabase mDatabase;

    public CompanyLocalAsyncTask(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    @Override
    protected Void doInBackground(CompanyEntity... companyEntities) {
        mDatabase.companyDao().insertCompany(companyEntities[0]);
        return null;
    }
}
