package com.uday.android.spacexorg.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uday.android.spacexorg.database.entity.LaunchEntity;

import java.util.List;

@Dao
public interface LaunchDao {

    @Query("SELECT * FROM launch_table WHERE launch_upcoming = 1 ORDER BY flight_number ASC")
    LiveData<List<LaunchEntity>> loadAllUpcomingLaunches();

    @Query("SELECT * FROM launch_table WHERE launch_upcoming = 0 ORDER BY flight_number DESC")
    LiveData<List<LaunchEntity>> loadAllPastLaunches();

    @Query("SELECT * FROM launch_table WHERE flight_number = :flight_no")
    LiveData<LaunchEntity> loadLaunch(int flight_no);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllLaunches(LaunchEntity... launchEntities);

}
