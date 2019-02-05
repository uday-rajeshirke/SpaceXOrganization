package com.uday.android.spacexorg.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.uday.android.spacexorg.database.entity.CompanyEntity;

@Dao
public interface CompanyDao {

    @Query("SELECT * FROM company_table WHERE company_id = 1")
    LiveData<CompanyEntity> loadCompany();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCompany(CompanyEntity companyEntity);
}
