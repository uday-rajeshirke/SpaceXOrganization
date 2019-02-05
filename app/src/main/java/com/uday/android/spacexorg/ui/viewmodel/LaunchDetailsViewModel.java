package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.LaunchEntity;

public class LaunchDetailsViewModel extends AndroidViewModel {

    private final DataRepository mRepository;

    public LaunchDetailsViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
    }

    public LiveData<LaunchEntity> getLaunchData(int flight_number) {
        return mRepository.getLaunch(flight_number);
    }

}
