package com.uday.android.spacexorg;

import android.app.Application;

import com.uday.android.spacexorg.database.AppDatabase;
import com.uday.android.spacexorg.database.DataRepository;
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;

public class BasicApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        InternetAvailabilityChecker.init(this);
    }

    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        InternetAvailabilityChecker.getInstance().removeAllInternetConnectivityChangeListeners();
    }
}
