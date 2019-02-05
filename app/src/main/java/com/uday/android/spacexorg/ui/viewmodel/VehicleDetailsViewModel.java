package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.CapsuleEntity;
import com.uday.android.spacexorg.database.entity.RocketEntity;
import com.uday.android.spacexorg.database.entity.ShipEntity;

public class VehicleDetailsViewModel extends AndroidViewModel {

    private final DataRepository mRepository;

    public VehicleDetailsViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
    }

    public LiveData<RocketEntity> getRocketData(String rocketId) {
        return mRepository.getRocket(rocketId);
    }

    public LiveData<CapsuleEntity> getCapsuleData(String capsuleId) {
        return mRepository.getCapsule(capsuleId);
    }

    public LiveData<ShipEntity> getShipsData(String shipId) {
        return mRepository.getShip(shipId);
    }

}
