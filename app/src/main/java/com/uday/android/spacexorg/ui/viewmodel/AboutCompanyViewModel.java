package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.database.entity.CompanyEntity;

public class AboutCompanyViewModel extends AndroidViewModel {

    private final DataRepository mRepository;
    private final LiveData<CompanyEntity> mCompanyData;

    public AboutCompanyViewModel(@NonNull Application application) {
        super(application);
        mRepository = ((BasicApp) application).getRepository();
        mCompanyData = mRepository.getCompany();
    }

    public LiveData<CompanyEntity> getCompanyData() {
        return mCompanyData;
    }

    public void insertCompanyData () {
        mRepository.insertCompany();
    }

}
