
package com.uday.android.spacexorg.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;

import com.uday.android.spacexorg.network.model.roadster.Roadster;

@Entity(tableName = "roadster_table")
public class RoadsterEntity {

    @ColumnInfo(name = "roadster_id")
    @PrimaryKey()
    private Long id;
    @ColumnInfo(name = "roadster_name")
    @Nullable
    private String name;
    @ColumnInfo(name = "roadster_launch_date_utc")
    @Nullable
    private String launchDateUtc;
    @ColumnInfo(name = "roadster_launch_date_unix")
    @Nullable
    private Integer launchDateUnix;
    @ColumnInfo(name = "roadster_orbit_type")
    @Nullable
    private String orbitType;
    @ColumnInfo(name = "roadster_apoapsis")
    @Nullable
    private Float apoapsisAu;
    @ColumnInfo(name = "roadster_periapsis")
    @Nullable
    private Float periapsisAu;
    @ColumnInfo(name = "roadster_semi_major_axis")
    @Nullable
    private Float semiMajorAxisAu;
    @ColumnInfo(name = "roadster_inclination")
    @Nullable
    private Float inclination;
    @ColumnInfo(name = "roadster_longitude")
    @Nullable
    private Float longitude;
    @ColumnInfo(name = "roadster_period_days")
    @Nullable
    private Float periodDays;
    @ColumnInfo(name = "roadster_speed")
    @Nullable
    private Float speedKph;
    @ColumnInfo(name = "roadster_earth_distance")
    @Nullable
    private Float earthDistanceKm;
    @ColumnInfo(name = "roadster_mars_distance")
    @Nullable
    private Float marsDistanceKm;
    @ColumnInfo(name = "roadster_details")
    @Nullable
    private String details;

    @Ignore
    public RoadsterEntity() {
    }

    public RoadsterEntity(String name, String launchDateUtc, Integer launchDateUnix, String orbitType,
                          Float apoapsisAu, Float periapsisAu, Float semiMajorAxisAu, Float inclination,
                          Float longitude, Float periodDays, Float speedKph, Float earthDistanceKm,
                          Float marsDistanceKm, String details) {
        super();
        this.id = 1L;
        this.name = name;
        this.launchDateUtc = launchDateUtc;
        this.launchDateUnix = launchDateUnix;
        this.orbitType = orbitType;
        this.apoapsisAu = apoapsisAu;
        this.periapsisAu = periapsisAu;
        this.semiMajorAxisAu = semiMajorAxisAu;
        this.inclination = inclination;
        this.longitude = longitude;
        this.periodDays = periodDays;
        this.speedKph = speedKph;
        this.earthDistanceKm = earthDistanceKm;
        this.marsDistanceKm = marsDistanceKm;
        this.details = details;
    }

    public RoadsterEntity(Roadster roadster) {
        super();
        this.id = 1L;
        this.name = roadster.getName();
        this.launchDateUtc = roadster.getLaunchDateUtc();
        this.launchDateUnix = roadster.getLaunchDateUnix();
        this.orbitType = roadster.getOrbitType();
        this.apoapsisAu = roadster.getApoapsisAu();
        this.periapsisAu = roadster.getPeriapsisAu();
        this.semiMajorAxisAu = roadster.getSemiMajorAxisAu();
        this.inclination = roadster.getInclination();
        this.longitude = roadster.getLongitude();
        this.periodDays = roadster.getPeriodDays();
        this.speedKph = roadster.getSpeedKph();
        this.earthDistanceKm = roadster.getEarthDistanceKm();
        this.marsDistanceKm = roadster.getMarsDistanceKm();
        this.details = roadster.getDetails();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    public Float getApoapsisAu() {
        return apoapsisAu;
    }

    public void setApoapsisAu(Float apoapsisAu) {
        this.apoapsisAu = apoapsisAu;
    }

    public Float getPeriapsisAu() {
        return periapsisAu;
    }

    public void setPeriapsisAu(Float periapsisAu) {
        this.periapsisAu = periapsisAu;
    }

    public Float getSemiMajorAxisAu() {
        return semiMajorAxisAu;
    }

    public void setSemiMajorAxisAu(Float semiMajorAxisAu) {
        this.semiMajorAxisAu = semiMajorAxisAu;
    }

    public Float getInclination() {
        return inclination;
    }

    public void setInclination(Float inclination) {
        this.inclination = inclination;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(Float periodDays) {
        this.periodDays = periodDays;
    }

    public Float getSpeedKph() {
        return speedKph;
    }

    public void setSpeedKph(Float speedKph) {
        this.speedKph = speedKph;
    }

    public Float getEarthDistanceKm() {
        return earthDistanceKm;
    }

    public void setEarthDistanceKm(Float earthDistanceKm) {
        this.earthDistanceKm = earthDistanceKm;
    }

    public Float getMarsDistanceKm() {
        return marsDistanceKm;
    }

    public void setMarsDistanceKm(Float marsDistanceKm) {
        this.marsDistanceKm = marsDistanceKm;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
