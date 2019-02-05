package com.uday.android.spacexorg.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uday.android.spacexorg.database.entity.HistoryEntity;

import java.util.List;

@Dao
public interface HistoryDao {

    @Query("SELECT * FROM history_table")
    LiveData<List<HistoryEntity>> loadAllHistory();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllHistory(HistoryEntity... historyEntities);

}
