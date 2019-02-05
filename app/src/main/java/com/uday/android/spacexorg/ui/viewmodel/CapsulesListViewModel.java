package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.CapsuleEntity;

import java.util.List;

public class CapsulesListViewModel extends AndroidViewModel {

    private final DataRepository mRepository;
    private final LiveData<List<CapsuleEntity>> mAllCapsuleData;

    public CapsulesListViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
        mAllCapsuleData = mRepository.getAllCapsules();
    }

    public LiveData<List<CapsuleEntity>> getAllCapsuleData() {
        return mAllCapsuleData;
    }

    public void insertAllCapsuleData () {
        mRepository.insertAllCapsules();
    }

}
