package com.uday.android.spacexorg.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.uday.android.spacexorg.network.model.core.Core;
import com.uday.android.spacexorg.network.model.core.Mission;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.lang.reflect.Type;
import java.util.List;

@Entity(tableName = "core_table")
public class CoreEntity {

    @PrimaryKey
    @ColumnInfo(name = "core_serial")
    @NonNull
    private String coreSerial;
    @ColumnInfo(name = "core_block")
    @Nullable
    private Integer block;
    @ColumnInfo(name = "core_status")
    @Nullable
    private String status;
    @ColumnInfo(name = "core_original_launch")
    @Nullable
    private String originalLaunch;
    @ColumnInfo(name = "core_missions")
    @Nullable
    private String missions;
    @ColumnInfo(name = "core_water_landing")
    @Nullable
    private Boolean waterLanding;
    @ColumnInfo(name = "core_details")
    @Nullable
    private String details;

    @Ignore
    public CoreEntity() {
    }


    public CoreEntity(String coreSerial, Integer block, String status, String originalLaunch, String missions, Boolean waterLanding, String details) {
        super();
        this.coreSerial = coreSerial;
        this.block = block;
        this.status = status;
        this.originalLaunch = originalLaunch;
        this.missions = missions;
        this.waterLanding = waterLanding;
        this.details = details;
    }

    public CoreEntity(Core core) {
        super();
        this.coreSerial = core.getCoreSerial();
        this.block = core.getBlock();
        this.status = core.getStatus();
        this.originalLaunch = core.getOriginalLaunch();
        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Mission.class);
        JsonAdapter<List<Mission>> jsonAdapter = moshi.adapter(type);
        this.missions = jsonAdapter.toJson(core.getMissions());
        this.waterLanding = core.getWaterLanding();
        this.details = core.getDetails();
    }


    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOriginalLaunch() {
        return originalLaunch;
    }

    public void setOriginalLaunch(String originalLaunch) {
        this.originalLaunch = originalLaunch;
    }

    public String getMissions() {
        return missions;
    }

    public void setMissions(String missions) {
        this.missions = missions;
    }

    public Boolean getWaterLanding() {
        return waterLanding;
    }

    public void setWaterLanding(Boolean waterLanding) {
        this.waterLanding = waterLanding;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}