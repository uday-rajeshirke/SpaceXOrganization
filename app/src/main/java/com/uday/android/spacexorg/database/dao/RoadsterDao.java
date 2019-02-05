package com.uday.android.spacexorg.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uday.android.spacexorg.database.entity.RoadsterEntity;

@Dao
public interface RoadsterDao {

    @Query("SELECT * FROM roadster_table WHERE roadster_id = 1")
    LiveData<RoadsterEntity> loadRoadster();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRoadster(RoadsterEntity roadsterEntity);

}
