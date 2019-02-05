package com.uday.android.spacexorg.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uday.android.spacexorg.database.entity.CapsuleEntity;

import java.util.List;

@Dao
public interface CapsuleDao {

    @Query("SELECT * FROM capsule_table")
    LiveData<List<CapsuleEntity>> loadAllCapsules();

    @Query("SELECT * FROM capsule_table WHERE capsule_id = :capsuleId")
    LiveData<CapsuleEntity> loadCapsule(String capsuleId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllCapsules(CapsuleEntity... capsuleEntities);
}
