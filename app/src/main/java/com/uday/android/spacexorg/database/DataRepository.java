package com.uday.android.spacexorg.database;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;

import com.uday.android.spacexorg.database.entity.CapsuleEntity;
import com.uday.android.spacexorg.database.entity.CompanyEntity;
import com.uday.android.spacexorg.database.entity.CoreEntity;
import com.uday.android.spacexorg.database.entity.HistoryEntity;
import com.uday.android.spacexorg.database.entity.LaunchEntity;
import com.uday.android.spacexorg.database.entity.RoadsterEntity;
import com.uday.android.spacexorg.database.entity.RocketEntity;
import com.uday.android.spacexorg.database.entity.ShipEntity;
import com.uday.android.spacexorg.network.postasynctask.CapsuleLocalAsyncTask;
import com.uday.android.spacexorg.network.postasynctask.CompanyLocalAsyncTask;
import com.uday.android.spacexorg.network.postasynctask.CoreLocalAsyncTask;
import com.uday.android.spacexorg.network.postasynctask.HistoryLocalAsyncTask;
import com.uday.android.spacexorg.network.postasynctask.InternetConnectivity;
import com.uday.android.spacexorg.network.postasynctask.LaunchLocalAsyncTask;
import com.uday.android.spacexorg.network.postasynctask.RoadsterLocalAsyncTask;
import com.uday.android.spacexorg.network.postasynctask.RocketLocalAsyncTask;
import com.uday.android.spacexorg.network.postasynctask.ShipLocalAsyncTask;
import com.uday.android.spacexorg.network.postinterface.NetworkPostExecute;
import com.uday.android.spacexorg.network.model.capsule.Capsule;
import com.uday.android.spacexorg.network.model.company.Company;
import com.uday.android.spacexorg.network.model.core.Core;
import com.uday.android.spacexorg.network.model.history.History;
import com.uday.android.spacexorg.network.model.launch.Launch;
import com.uday.android.spacexorg.network.model.photos.Flickr;
import com.uday.android.spacexorg.network.model.photos.Photo;
import com.uday.android.spacexorg.network.model.roadster.Roadster;
import com.uday.android.spacexorg.network.model.rocket.Rocket;
import com.uday.android.spacexorg.network.model.ship.Ship;
import com.treebo.internetavailabilitychecker.InternetAvailabilityChecker;

import java.util.List;

public class DataRepository {

    private static DataRepository sInstance;

    public static final int OBJECT_TYPE_LAUNCH = 1;
    public static final int OBJECT_TYPE_ROADSTER = 2;
    public static final int OBJECT_TYPE_HISTORY = 3;
    public static final int OBJECT_TYPE_ROCKET = 4;
    public static final int OBJECT_TYPE_CAPSULE = 5;
    public static final int OBJECT_TYPE_SHIP = 6;
    public static final int OBJECT_TYPE_CORE = 7;
    public static final int OBJECT_TYPE_COMPANY = 8;
    public static final int OBJECT_TYPE_PHOTOS = 9;

    private final AppDatabase mDatabase;
    private GetData mNetworkPostExecute;
    private MediatorLiveData<List<LaunchEntity>> mObservableUpcomingLaunches, mObservablePastLaunches;
    private MediatorLiveData<RoadsterEntity> mObservableRoadster;
    private MediatorLiveData<List<RocketEntity>> mObservableRockets;
    private MediatorLiveData<List<CapsuleEntity>> mObservableCapsules;
    private MediatorLiveData<List<ShipEntity>> mObservableShips;
    private MediatorLiveData<List<CoreEntity>> mObservableCores;
    private MediatorLiveData<List<HistoryEntity>> mObservableHistory;
    private MediatorLiveData<CompanyEntity> mObservableCompany;
    private MediatorLiveData<List<Photo>> mObservablePhotos;

    private InternetAvailabilityChecker mInternetAvailabilityChecker;
    private InternetConnectivity mInternetConnectivity;

    private DataRepository(final AppDatabase database) {

        mDatabase = database;
        mNetworkPostExecute = new GetData();
        mInternetAvailabilityChecker = InternetAvailabilityChecker.getInstance();

        mObservableUpcomingLaunches = new MediatorLiveData<>();
        mObservablePastLaunches = new MediatorLiveData<>();
        mObservableRoadster = new MediatorLiveData<>();
        mObservableRockets = new MediatorLiveData<>();
        mObservableCapsules = new MediatorLiveData<>();
        mObservableShips = new MediatorLiveData<>();
        mObservableCores = new MediatorLiveData<>();
        mObservableHistory = new MediatorLiveData<>();
        mObservableCompany = new MediatorLiveData<>();
        mObservablePhotos = new MediatorLiveData<>();

        mObservableUpcomingLaunches.addSource(mDatabase.launchDao().loadAllUpcomingLaunches(),
                launchEntities -> {
                    mObservableUpcomingLaunches.postValue(launchEntities);
                });

        mObservablePastLaunches.addSource(mDatabase.launchDao().loadAllPastLaunches(),
                launchEntities -> {
                    mObservablePastLaunches.postValue(launchEntities);
                });

        mObservableRoadster.addSource(mDatabase.roadsterDao().loadRoadster(),
                roadsterEntity -> {
                    mObservableRoadster.postValue(roadsterEntity);
                });

        mObservableRockets.addSource(mDatabase.rocketDao().loadAllRocket(),
                rocketEntities -> {
                    mObservableRockets.postValue(rocketEntities);
                });

        mObservableCapsules.addSource(mDatabase.capsuleDao().loadAllCapsules(),
                capsuleEntities -> {
                    mObservableCapsules.postValue(capsuleEntities);
                });

        mObservableShips.addSource(mDatabase.shipDao().loadAllShip(),
                shipEntities -> {
                    mObservableShips.postValue(shipEntities);
                });

        mObservableCores.addSource(mDatabase.coreDao().loadAllCores(),
                coreEntities -> {
                    mObservableCores.postValue(coreEntities);
                });

        mObservableHistory.addSource(mDatabase.historyDao().loadAllHistory(),
                historyEntities -> {
                    mObservableHistory.postValue(historyEntities);
                });

        mObservableCompany.addSource(mDatabase.companyDao().loadCompany(),
                companyEntity -> {
                    mObservableCompany.postValue(companyEntity);
                });
    }

    public static DataRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (DataRepository.class) {
                if (sInstance == null) {
                    sInstance = new DataRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<LaunchEntity>> getAllUpcomingLaunches() {
        return mObservableUpcomingLaunches;
    }

    public LiveData<List<LaunchEntity>> getAllPastLaunches() {
        return mObservablePastLaunches;
    }

    public LiveData<LaunchEntity> getLaunch(int flight_number) {
        return mDatabase.launchDao().loadLaunch(flight_number);
    }

    public LiveData<RoadsterEntity> getRoadster() {
        return mObservableRoadster;
    }

    public LiveData<List<RocketEntity>> getAllRockets() {
        return mObservableRockets;
    }

    public LiveData<RocketEntity> getRocket(String rocketId) {
        return mDatabase.rocketDao().loadRocket(rocketId);
    }

    public LiveData<List<CapsuleEntity>> getAllCapsules() {
        return mObservableCapsules;
    }

    public LiveData<CapsuleEntity> getCapsule(String capsuleId) {
        return mDatabase.capsuleDao().loadCapsule(capsuleId);
    }

    public LiveData<List<ShipEntity>> getAllShips() {
        return mObservableShips;
    }

    public LiveData<ShipEntity> getShip(String shipId) {
        return mDatabase.shipDao().loadShip(shipId);
    }

    public LiveData<List<CoreEntity>> getAllCores() {
        return mObservableCores;
    }

    public LiveData<List<HistoryEntity>> getAllHistory() {
        return mObservableHistory;
    }

    public LiveData<CompanyEntity> getCompany() {
        return mObservableCompany;
    }

    public void insertAllLaunches() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_LAUNCH,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
    }

    public void insertRoadster() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_ROADSTER,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
    }

    public void insertAllRockets() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_ROCKET,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
    }

    public void insertAllCapsules() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_CAPSULE,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
    }

    public void insertAllShips() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_SHIP,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
    }

    public void insertAllCores() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_CORE,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
    }

    public void insertAllHistory() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_HISTORY,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
    }

    public void insertCompany() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_COMPANY,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
    }

    public LiveData<List<Photo>> getNetworkPhotoData() {
        mInternetConnectivity = new InternetConnectivity(OBJECT_TYPE_PHOTOS,mNetworkPostExecute);
        mInternetAvailabilityChecker.addInternetConnectivityListener(mInternetConnectivity);
        return mObservablePhotos;
    }


    private class GetData implements NetworkPostExecute {

        @Override
        public void getAllLaunch(List<Launch> launchList) {
            LaunchEntity[] launchEntities = new LaunchEntity[launchList.size()];
            for(int i=0; i<launchList.size(); i++) {
                launchEntities[i] = new LaunchEntity(launchList.get(i));
            }
            new LaunchLocalAsyncTask(mDatabase).execute(launchEntities);
        }

        @Override
        public void getRoadster(Roadster roadster) {
            new RoadsterLocalAsyncTask(mDatabase).execute(new RoadsterEntity(roadster));
        }

        @Override
        public void getAllRockets(List<Rocket> rocketList) {
            RocketEntity[] rocketEntities = new RocketEntity[rocketList.size()];
            for(int i=0; i<rocketList.size(); i++) {
                rocketEntities[i] = new RocketEntity(rocketList.get(i));
            }
            new RocketLocalAsyncTask(mDatabase).execute(rocketEntities);
        }

        @Override
        public void getAllCapsules(List<Capsule> capsuleList) {
            CapsuleEntity[] capsuleEntities = new CapsuleEntity[capsuleList.size()];
            for(int i=0; i<capsuleList.size(); i++) {
                capsuleEntities[i] = new CapsuleEntity(capsuleList.get(i));
            }
            new CapsuleLocalAsyncTask(mDatabase).execute(capsuleEntities);
        }

        @Override
        public void getAllShips(List<Ship> shipList) {
            ShipEntity[] shipEntities = new ShipEntity[shipList.size()];
            for(int i=0; i<shipList.size(); i++) {
                shipEntities[i] = new ShipEntity(shipList.get(i));
            }
            new ShipLocalAsyncTask(mDatabase).execute(shipEntities);
        }

        @Override
        public void getAllCores(List<Core> coreList) {
            CoreEntity[] coreEntities = new CoreEntity[coreList.size()];
            for(int i=0; i<coreList.size(); i++) {
                coreEntities[i] = new CoreEntity(coreList.get(i));
            }
            new CoreLocalAsyncTask(mDatabase).execute(coreEntities);
        }

        @Override
        public void getAllHistory(List<History> historyList) {
            HistoryEntity[] historyEntities = new HistoryEntity[historyList.size()];
            for(int i=0; i<historyList.size(); i++) {
                historyEntities[i] = new HistoryEntity(historyList.get(i));
            }
            new HistoryLocalAsyncTask(mDatabase).execute(historyEntities);
        }

        @Override
        public void getCompany(Company company) {
            new CompanyLocalAsyncTask(mDatabase).execute(new CompanyEntity(company));
        }

        @Override
        public void getPhotos(Flickr flickr) {
            mObservablePhotos.setValue(flickr.getPhotos().getPhoto());
        }

    }

}
