package com.uday.android.spacexorg.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.uday.android.spacexorg.database.dao.CapsuleDao;
import com.uday.android.spacexorg.database.dao.CompanyDao;
import com.uday.android.spacexorg.database.dao.CoreDao;
import com.uday.android.spacexorg.database.dao.HistoryDao;
import com.uday.android.spacexorg.database.dao.LaunchDao;
import com.uday.android.spacexorg.database.dao.RoadsterDao;
import com.uday.android.spacexorg.database.dao.RocketDao;
import com.uday.android.spacexorg.database.dao.ShipDao;
import com.uday.android.spacexorg.database.entity.CapsuleEntity;
import com.uday.android.spacexorg.database.entity.CompanyEntity;
import com.uday.android.spacexorg.database.entity.CoreEntity;
import com.uday.android.spacexorg.database.entity.HistoryEntity;
import com.uday.android.spacexorg.database.entity.LaunchEntity;
import com.uday.android.spacexorg.database.entity.LaunchpadEntity;
import com.uday.android.spacexorg.database.entity.RoadsterEntity;
import com.uday.android.spacexorg.database.entity.RocketEntity;
import com.uday.android.spacexorg.database.entity.ShipEntity;

@Database(entities = {LaunchEntity.class, LaunchpadEntity.class, RoadsterEntity.class, RocketEntity.class, CapsuleEntity.class, ShipEntity.class, CoreEntity.class, HistoryEntity.class, CompanyEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final Object LOCK = new Object();
    private static AppDatabase sInstance;

    private static final String DATABASE_NAME = "spacex-db";

    public abstract LaunchDao launchDao();
    public abstract RoadsterDao roadsterDao();
    public abstract RocketDao rocketDao();
    public abstract CapsuleDao capsuleDao();
    public abstract ShipDao shipDao();
    public abstract CoreDao coreDao();
    public abstract HistoryDao historyDao();
    public abstract CompanyDao companyDao();

    public static AppDatabase getInstance(final Context context) {

        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,DATABASE_NAME).build();
                }
            }
        }
        return sInstance;
    }

}
