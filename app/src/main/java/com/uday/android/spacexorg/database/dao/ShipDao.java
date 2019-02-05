package com.uday.android.spacexorg.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uday.android.spacexorg.database.entity.ShipEntity;

import java.util.List;

@Dao
public interface ShipDao {

    @Query("SELECT * FROM ship_table")
    LiveData<List<ShipEntity>> loadAllShip();

    @Query("SELECT * FROM ship_table WHERE ship_id = :shipId")
    LiveData<ShipEntity> loadShip(String shipId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllShip(ShipEntity... shipEntities);

}
