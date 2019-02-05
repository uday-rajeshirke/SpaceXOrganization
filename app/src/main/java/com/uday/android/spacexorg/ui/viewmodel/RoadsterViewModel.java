package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.RoadsterEntity;

public class RoadsterViewModel extends AndroidViewModel {

    private final DataRepository mRepository;
    private final LiveData<RoadsterEntity> mRoadsterData;

    public RoadsterViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
        mRoadsterData = mRepository.getRoadster();
    }

    public LiveData<RoadsterEntity> getRoadsterData() {
        return mRoadsterData;
    }

    public void insertRoadsterData () {
        mRepository.insertRoadster();
    }
}
