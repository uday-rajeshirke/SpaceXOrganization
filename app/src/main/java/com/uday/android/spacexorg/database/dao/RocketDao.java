package com.uday.android.spacexorg.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uday.android.spacexorg.database.entity.RocketEntity;

import java.util.List;

@Dao
public interface RocketDao {

    @Query("SELECT * FROM rocket_table")
    LiveData<List<RocketEntity>> loadAllRocket();

    @Query("SELECT * FROM rocket_table WHERE rocket_entity_id = :rocketId")
    LiveData<RocketEntity> loadRocket(String rocketId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlRocket(RocketEntity... rocketEntities);

}
