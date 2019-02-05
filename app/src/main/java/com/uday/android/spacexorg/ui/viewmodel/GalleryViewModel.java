package com.uday.android.spacexorg.ui.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.uday.android.spacexorg.BasicApp;
import com.uday.android.spacexorg.database.DataRepository;
import com.uday.android.spacexorg.network.model.photos.Photo;

import java.util.List;

public class GalleryViewModel extends AndroidViewModel {

    private LiveData<List<Photo>> mAllNetworkPhotos;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
        DataRepository mRepository = ((BasicApp) application).getRepository();
        mAllNetworkPhotos = mRepository.getNetworkPhotoData();
    }

    public LiveData<List<Photo>> getAllPhotos() {
        return mAllNetworkPhotos;
    }

}
