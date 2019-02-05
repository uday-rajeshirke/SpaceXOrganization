package com.uday.android.spacexorg.network.postasynctask;

import android.os.AsyncTask;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.entity.ShipEntity;

public class ShipLocalAsyncTask extends AsyncTask<ShipEntity[],Void, Void> {

    private AppDatabase mDatabase;

    public ShipLocalAsyncTask(AppDatabase mDatabase) {
        this.mDatabase = mDatabase;
    }

    @Override
    protected Void doInBackground(ShipEntity[]... shipEntities) {
        mDatabase.shipDao().insertAllShip(shipEntities[0]);
        return null;
    }
}
