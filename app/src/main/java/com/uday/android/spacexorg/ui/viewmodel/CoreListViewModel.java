package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.CoreEntity;

import java.util.List;

public class CoreListViewModel extends AndroidViewModel {

    private final DataRepository mRepository;
    private final LiveData<List<CoreEntity>> mAllCoreData;

    public CoreListViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
        mAllCoreData = mRepository.getAllCores();
    }

    public LiveData<List<CoreEntity>> getAllCoreData() {
        return mAllCoreData;
    }

    public void insertAllCoreData () {
        mRepository.insertAllCores();
    }
}
