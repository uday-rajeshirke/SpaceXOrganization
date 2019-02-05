package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.LaunchEntity;

import java.util.List;

public class LaunchesListViewModel extends AndroidViewModel {

    private final DataRepository mRepository;
    private final LiveData<List<LaunchEntity>> mAllUpcomingLaunchData, mAllPastLaunchData;

    public LaunchesListViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
        mAllUpcomingLaunchData = mRepository.getAllUpcomingLaunches();
        mAllPastLaunchData = mRepository.getAllPastLaunches();
    }

    public LiveData<List<LaunchEntity>> getAllUpcomingLaunchData() {
        return mAllUpcomingLaunchData;
    }

    public LiveData<List<LaunchEntity>> getAllPastLaunchData() {
        return mAllPastLaunchData;
    }

    public void insertAllLaunchData () {
        mRepository.insertAllLaunches();
    }



}
