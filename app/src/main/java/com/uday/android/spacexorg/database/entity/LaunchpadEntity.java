
package com.uday.android.spacexorg.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;

import com.uday.android.spacexorg.network.model.launchpad.Launchpad;

@Entity(tableName = "launchpad_table")
public class LaunchpadEntity {

    @PrimaryKey
    @ColumnInfo(name = "launchpad_id")
    private Integer id;
    @ColumnInfo(name = "launchpad_status")
    @Nullable
    private String status;
    @ColumnInfo(name = "launchpad_location_name")
    @Nullable
    private String locationName;
    @ColumnInfo(name = "launchpad_location_region")
    @Nullable
    private String locationRegion;
    @ColumnInfo(name = "launchpad_latitude")
    @Nullable
    private Float latitude;
    @ColumnInfo(name = "launchpad_longitude")
    @Nullable
    private Float longitude;
    @ColumnInfo(name = "launchpad_attempted_launches")
    @Nullable
    private Integer attemptedLaunches;
    @ColumnInfo(name = "launchpad_successful_launches")
    @Nullable
    private Integer successfulLaunches;
    @ColumnInfo(name = "launchpad_site_id")
    @Nullable
    private String siteId;
    @ColumnInfo(name = "launchpad_site_name_long")
    @Nullable
    private String siteNameLong;

    @Ignore
    public LaunchpadEntity() {
    }

    public LaunchpadEntity(Integer id, String status, String locationName, String locationRegion, Float latitude, Float longitude, Integer attemptedLaunches, Integer successfulLaunches, String siteId, String siteNameLong) {
        super();
        this.id = id;
        this.status = status;
        this.locationName = locationName;
        this.locationRegion = locationRegion;
        this.latitude = latitude;
        this.longitude = longitude;
        this.attemptedLaunches = attemptedLaunches;
        this.successfulLaunches = successfulLaunches;
        this.siteId = siteId;
        this.siteNameLong = siteNameLong;
    }

    public LaunchpadEntity(Launchpad launchpad) {
        this.id = launchpad.getId();
        this.status = launchpad.getStatus();
        this.locationName = launchpad.getLocation().getName();
        this.locationRegion = launchpad.getLocation().getRegion();
        this.latitude = launchpad.getLocation().getLatitude();
        this.longitude = launchpad.getLocation().getLongitude();
        this.attemptedLaunches = launchpad.getAttemptedLaunches();
        this.successfulLaunches = launchpad.getSuccessfulLaunches();
        this.siteId = launchpad.getSiteId();
        this.siteNameLong = launchpad.getSiteNameLong();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationRegion() {
        return locationRegion;
    }

    public void setLocationRegion(String locationRegion) {
        this.locationRegion = locationRegion;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Integer getAttemptedLaunches() {
        return attemptedLaunches;
    }

    public void setAttemptedLaunches(Integer attemptedLaunches) {
        this.attemptedLaunches = attemptedLaunches;
    }

    public Integer getSuccessfulLaunches() {
        return successfulLaunches;
    }

    public void setSuccessfulLaunches(Integer successfulLaunches) {
        this.successfulLaunches = successfulLaunches;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }

}
