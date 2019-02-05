package com.uday.android.spacexorg.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uday.android.spacexorg.database.entity.CoreEntity;

import java.util.List;

@Dao
public interface CoreDao {

    @Query("SELECT * FROM core_table ORDER BY core_serial ASC")
    LiveData<List<CoreEntity>> loadAllCores();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCores(CoreEntity... coreEntities);

}
