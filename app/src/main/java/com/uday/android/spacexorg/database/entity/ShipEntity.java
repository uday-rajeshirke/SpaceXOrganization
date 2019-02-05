
package com.uday.android.spacexorg.database.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.uday.android.spacexorg.network.model.ship.Mission;
import com.uday.android.spacexorg.network.model.ship.Ship;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.lang.reflect.Type;
import java.util.List;

@Entity(tableName = "ship_table")
public class ShipEntity {

    @PrimaryKey
    @ColumnInfo(name = "ship_id")
    @NonNull
    private String shipId;
    @ColumnInfo(name = "ship_name")
    @Nullable
    private String shipName;
    @ColumnInfo(name = "ship_type")
    @Nullable
    private String shipType;
    @ColumnInfo(name = "ship_roles")
    @Nullable
    private String roles;
    @ColumnInfo(name = "ship_weight")
    @Nullable
    private Integer weightKg;
    @ColumnInfo(name = "ship_speed")
    @Nullable
    private Float speedKn;
    @ColumnInfo(name = "ship_status")
    @Nullable
    private String status;
    @ColumnInfo(name = "ship_year_built")
    @Nullable
    private Integer yearBuilt;
    @ColumnInfo(name = "ship_home_port")
    @Nullable
    private String homePort;
    @ColumnInfo(name = "ship_mission")
    @Nullable
    private String missions;
    @ColumnInfo(name = "ship_image")
    @Nullable
    private String image;

    @Ignore
    public ShipEntity() {
    }

    public ShipEntity(String shipId, String shipName, String shipType, String roles, Integer weightKg, Float speedKn, String status, Integer yearBuilt, String homePort, String missions, String image) {
        super();
        this.shipId = shipId;
        this.shipName = shipName;
        this.shipType = shipType;
        this.roles = roles;
        this.weightKg = weightKg;
        this.speedKn = speedKn;
        this.status = status;
        this.yearBuilt = yearBuilt;
        this.homePort = homePort;
        this.missions = missions;
        this.image = image;
    }

    public ShipEntity(Ship ship) {
        super();
        Moshi moshi = new Moshi.Builder().build();
        this.shipId = ship.getShipId();
        this.shipName = ship.getShipName();
        this.shipType = ship.getShipType();
        Type type1 = Types.newParameterizedType(List.class, String.class);
        JsonAdapter<List<String>> jsonAdapter1 = moshi.adapter(type1);
        this.roles = jsonAdapter1.toJson(ship.getRoles());
        this.weightKg = ship.getWeightKg();
        this.speedKn = ship.getSpeedKn();
        this.status = ship.getStatus();
        this.yearBuilt = ship.getYearBuilt();
        this.homePort = ship.getHomePort();
        Type type3 = Types.newParameterizedType(List.class, Mission.class);
        JsonAdapter<List<Mission>> jsonAdapter3 = moshi.adapter(type3);
        this.missions = jsonAdapter3.toJson(ship.getMissions());
        this.image = ship.getImage();
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public Integer getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Integer weightKg) {
        this.weightKg = weightKg;
    }

    public Float getSpeedKn() {
        return speedKn;
    }

    public void setSpeedKn(Float speedKn) {
        this.speedKn = speedKn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getHomePort() {
        return homePort;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort;
    }

    public String getMissions() {
        return missions;
    }

    public void setMissions(String missions) {
        this.missions = missions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
