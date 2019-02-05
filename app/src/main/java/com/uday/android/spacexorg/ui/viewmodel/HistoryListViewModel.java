package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.HistoryEntity;

import java.util.List;

public class HistoryListViewModel extends AndroidViewModel {

    private final DataRepository mRepository;
    private final LiveData<List<HistoryEntity>> mAllHistoryData;

    public HistoryListViewModel(@NonNull Application application) {
        super(application);

        mRepository = ((BasicApp) application).getRepository();
        mAllHistoryData = mRepository.getAllHistory();
    }

    public LiveData<List<HistoryEntity>> getAllHistoryData() {
        return mAllHistoryData;
    }

    public void insertAllHistoryData () {
        mRepository.insertAllHistory();
    }

}
