package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.RocketEntity;

import java.util.List;

public class RocketListViewModel extends AndroidViewModel {

    private final DataRepository mRepository;
    private final LiveData<List<RocketEntity>> mAllRocketData;

    public RocketListViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
        mAllRocketData = mRepository.getAllRockets();
    }

    public LiveData<List<RocketEntity>> getAllRocketData() {
        return mAllRocketData;
    }

    public void insertAllRocketData () {
        mRepository.insertAllRockets();
    }

}
