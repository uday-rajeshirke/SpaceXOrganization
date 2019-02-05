package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.ShipEntity;

import java.util.List;

public class ShipListViewModel extends AndroidViewModel {

    private final DataRepository mRepository;
    private final LiveData<List<ShipEntity>> mAllShipsData;

    public ShipListViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
        mAllShipsData = mRepository.getAllShips();
    }

    public LiveData<List<ShipEntity>> getAllShipsData() {
        return mAllShipsData;
    }

    public void insertAllShipData () {
        mRepository.insertAllShips();
    }

}
