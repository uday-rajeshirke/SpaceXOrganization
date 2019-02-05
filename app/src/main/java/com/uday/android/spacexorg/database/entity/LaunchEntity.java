
package com.uday.android.spacexorg.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;

import com.uday.android.spacexorg.network.model.launch.Core;
import com.uday.android.spacexorg.network.model.launch.Launch;
import com.uday.android.spacexorg.network.model.launch.Payload;

@Entity(tableName = "launch_table")
public class LaunchEntity {

    @PrimaryKey
    @ColumnInfo(name = "flight_number")
    private Integer flightNumber;
    @ColumnInfo(name = "mission_name")
    @Nullable
    private String missionName;
    @ColumnInfo(name = "launch_year")
    @Nullable
    private String launchYear;
    @ColumnInfo(name = "launch_date_unix")
    @Nullable
    private Integer launchDateUnix;
    @ColumnInfo(name = "launch_date_utc")
    @Nullable
    private String launchDateUtc;
    @ColumnInfo(name = "launch_date_local")
    @Nullable
    private String launchDateLocal;
    @ColumnInfo(name = "launch_is_tentative")
    private Boolean isTentative;
    @ColumnInfo(name = "rocket_id")
    @Nullable
    private String rocketId;
    @ColumnInfo(name = "rocket_name")
    @Nullable
    private String rocketName;
    @ColumnInfo(name = "rocket_type")
    @Nullable
    private String rocketType;
    @ColumnInfo(name = "core_serial")
    @Nullable
    private String coreSerial;
    @ColumnInfo(name = "core_reused")
    @Nullable
    private Boolean coreReused;
    @ColumnInfo(name = "core_land_success")
    @Nullable
    private Boolean landSuccess;
    @ColumnInfo(name = "core_landing_intent")
    @Nullable
    private Boolean landingIntent;
    @ColumnInfo(name = "core_landing_type")
    @Nullable
    private String landingType;
    @ColumnInfo(name = "core_landing_vehicle")
    @Nullable
    private String landingVehicle;
    @ColumnInfo(name = "payload_id")
    @Nullable
    private String payloadId;
    @ColumnInfo(name = "payload_reused")
    @Nullable
    private Boolean payloadReused;
    @ColumnInfo(name = "customers")
    @Nullable
    private String customers;
    @ColumnInfo(name = "nationality")
    @Nullable
    private String nationality;
    @ColumnInfo(name = "manufacturer")
    @Nullable
    private String manufacturer;
    @ColumnInfo(name = "payload_type")
    @Nullable
    private String payloadType;
    @ColumnInfo(name = "payload_mass_kg")
    @Nullable
    private Float payloadMassKg;
    @ColumnInfo(name = "orbit")
    @Nullable
    private String orbit;
    @ColumnInfo(name = "fairings_reused")
    @Nullable
    private Boolean fairingsReused;
    @ColumnInfo(name = "fairings_recovery_attempt")
    @Nullable
    private Boolean fairingsRecoveryAttempt;
    @ColumnInfo(name = "fairings_recovered")
    @Nullable
    private Boolean fairingsRecovered;
    @ColumnInfo(name = "launch_site_id")
    @Nullable
    private String launchSiteId;
    @ColumnInfo(name = "launch_site_name")
    @Nullable
    private String launchSiteName;
    @ColumnInfo(name = "launch_site_name_long")
    @Nullable
    private String launchSiteNameLong;
    @ColumnInfo(name = "launch_success")
    @Nullable
    private Boolean launchSuccess;
    @ColumnInfo(name = "mission_patch")
    @Nullable
    private String missionPatch;
    @ColumnInfo(name = "mission_patch_small")
    @Nullable
    private String missionPatchSmall;
    @ColumnInfo(name = "launch_details")
    @Nullable
    private String details;
    @ColumnInfo(name = "launch_upcoming")
    @Nullable
    private Boolean upcoming;

    @Ignore
    public LaunchEntity() {
    }

    public LaunchEntity(Integer flightNumber, String missionName, String launchYear,
                        Integer launchDateUnix, String launchDateUtc, String launchDateLocal,
                        Boolean isTentative, String rocketId, String rocketName, String rocketType,
                        String coreSerial, Boolean coreReused, Boolean landSuccess,
                        Boolean landingIntent, String landingType, String landingVehicle,
                        String payloadId, Boolean payloadReused, String customers, String nationality,
                        String manufacturer, String payloadType, Float payloadMassKg, String orbit,
                        Boolean fairingsReused, Boolean fairingsRecoveryAttempt, Boolean fairingsRecovered,
                        String launchSiteId, String launchSiteName, String launchSiteNameLong,
                        Boolean launchSuccess, String missionPatch, String missionPatchSmall,
                        String details, Boolean upcoming) {
        super();
        this.flightNumber = flightNumber;
        this.missionName = missionName;
        this.launchYear = launchYear;
        this.launchDateUnix = launchDateUnix;
        this.launchDateUtc = launchDateUtc;
        this.launchDateLocal = launchDateLocal;
        this.isTentative = isTentative;
        this.rocketId = rocketId;
        this.rocketName = rocketName;
        this.rocketType = rocketType;
        this.coreSerial = coreSerial;
        this.coreReused = coreReused;
        this.landSuccess = landSuccess;
        this.landingIntent = landingIntent;
        this.landingType = landingType;
        this.landingVehicle = landingVehicle;
        this.payloadId = payloadId;
        this.payloadReused = payloadReused;
        this.customers = customers;
        this.nationality = nationality;
        this.manufacturer = manufacturer;
        this.payloadType = payloadType;
        this.payloadMassKg = payloadMassKg;
        this.orbit = orbit;
        this.fairingsReused = fairingsReused;
        this.fairingsRecoveryAttempt = fairingsRecoveryAttempt;
        this.fairingsRecovered = fairingsRecovered;
        this.launchSiteId = launchSiteId;
        this.launchSiteName = launchSiteName;
        this.launchSiteNameLong = launchSiteNameLong;
        this.launchSuccess = launchSuccess;
        this.missionPatch = missionPatch;
        this.missionPatchSmall = missionPatchSmall;
        this.details = details;
        this.upcoming = upcoming;
    }

    public LaunchEntity(Launch launch) {
        this.flightNumber = launch.getFlightNumber();
        this.missionName = launch.getMissionName();
        this.launchYear = launch.getLaunchYear();
        this.launchDateUnix = launch.getLaunchDateUnix();
        this.launchDateUtc = launch.getLaunchDateUtc();
        this.launchDateLocal = launch.getLaunchDateLocal();
        this.isTentative = launch.getIsTentative();
        this.rocketId = launch.getRocket().getRocketId();
        this.rocketName = launch.getRocket().getRocketName();
        this.rocketType = launch.getRocket().getRocketType();

        for (Core core : launch.getRocket().getFirstStage().getCores()) {
            if(core.getCoreSerial()!=null)
                this.coreSerial=core.getCoreSerial();
            if (core.getReused()!=null)
                this.coreReused=core.getReused();
            if (core.getLandSuccess()!=null)
                this.landSuccess=core.getLandSuccess();
            if (core.getLandingIntent()!=null)
                this.landingIntent=core.getLandingIntent();
            if (core.getLandingType()!=null)
                this.landingType=core.getLandingType();
            if (core.getLandingVehicle()!=null)
                this.landingVehicle=core.getLandingVehicle();
        }

        for(Payload payload : launch.getRocket().getSecondStage().getPayloads()){
            this.payloadId = payload.getPayloadId();
            this.payloadReused = payload.getReused();

            for (String customer : payload.getCustomers()) {
                if (customer!=null) {
                    this.customers = customer;
                }
            }
            this.nationality = payload.getNationality();
            this.manufacturer = payload.getManufacturer();
            this.payloadType = payload.getPayloadType();
            this.payloadMassKg = payload.getPayloadMassKg();
            this.orbit = payload.getOrbit();
        }

        if(launch.getRocket().getFairings()!=null) {
            this.fairingsReused = launch.getRocket().getFairings().getReused();
            this.fairingsRecoveryAttempt = launch.getRocket().getFairings().getRecoveryAttempt();
            this.fairingsRecovered = launch.getRocket().getFairings().getRecovered();
        }

        this.launchSiteId = launch.getLaunchSite().getSiteId();
        this.launchSiteName = launch.getLaunchSite().getSiteName();
        this.launchSiteNameLong = launch.getLaunchSite().getSiteNameLong();
        this.launchSuccess = launch.getLaunchSuccess();
        this.missionPatch = launch.getLinks().getMissionPatch();
        this.missionPatchSmall = launch.getLinks().getMissionPatchSmall();
        this.details = launch.getDetails();
        this.upcoming = launch.getUpcoming();
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public Boolean getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(Boolean isTentative) {
        this.isTentative = isTentative;
    }

    public String getRocketId() {
        return rocketId;
    }

    public void setRocketId(String rocketId) {
        this.rocketId = rocketId;
    }

    public String getRocketName() {
        return rocketName;
    }

    public void setRocketName(String rocketName) {
        this.rocketName = rocketName;
    }

    public String getRocketType() {
        return rocketType;
    }

    public void setRocketType(String rocketType) {
        this.rocketType = rocketType;
    }

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Boolean getCoreReused() {
        return coreReused;
    }

    public void setCoreReused(Boolean coreReused) {
        this.coreReused = coreReused;
    }

    public Boolean getLandSuccess() {
        return landSuccess;
    }

    public void setLandSuccess(Boolean landSuccess) {
        this.landSuccess = landSuccess;
    }

    public Boolean getLandingIntent() {
        return landingIntent;
    }

    public void setLandingIntent(Boolean landingIntent) {
        this.landingIntent = landingIntent;
    }

    public String getLandingType() {
        return landingType;
    }

    public void setLandingType(String landingType) {
        this.landingType = landingType;
    }

    public String getLandingVehicle() {
        return landingVehicle;
    }

    public void setLandingVehicle(String landingVehicle) {
        this.landingVehicle = landingVehicle;
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public Boolean getPayloadReused() {
        return payloadReused;
    }

    public void setPayloadReused(Boolean payloadReused) {
        this.payloadReused = payloadReused;
    }

    public String getCustomers() {
        return customers;
    }

    public void setCustomers(String customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public Float getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(Float payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public Boolean getFairingsReused() {
        return fairingsReused;
    }

    public void setFairingsReused(Boolean fairingsReused) {
        this.fairingsReused = fairingsReused;
    }

    public Boolean getFairingsRecoveryAttempt() {
        return fairingsRecoveryAttempt;
    }

    public void setFairingsRecoveryAttempt(Boolean fairingsRecoveryAttempt) {
        this.fairingsRecoveryAttempt = fairingsRecoveryAttempt;
    }

    public Boolean getFairingsRecovered() {
        return fairingsRecovered;
    }

    public void setFairingsRecovered(Boolean fairingsRecovered) {
        this.fairingsRecovered = fairingsRecovered;
    }

    public String getLaunchSiteId() {
        return launchSiteId;
    }

    public void setLaunchSiteId(String launchSiteId) {
        this.launchSiteId = launchSiteId;
    }

    public String getLaunchSiteName() {
        return launchSiteName;
    }

    public void setLaunchSiteName(String launchSiteName) {
        this.launchSiteName = launchSiteName;
    }

    public String getLaunchSiteNameLong() {
        return launchSiteNameLong;
    }

    public void setLaunchSiteNameLong(String launchSiteNameLong) {
        this.launchSiteNameLong = launchSiteNameLong;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

}
