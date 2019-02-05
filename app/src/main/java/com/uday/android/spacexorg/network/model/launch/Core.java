
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

public class Core {

    @Json(name = "core_serial")
    private String coreSerial;
    @Json(name = "flight")
    private Integer flight;
    @Json(name = "block")
    private Integer block;
    @Json(name = "gridfins")
    private Boolean gridfins;
    @Json(name = "legs")
    private Boolean legs;
    @Json(name = "reused")
    private Boolean reused;
    @Json(name = "land_success")
    private Boolean landSuccess;
    @Json(name = "landing_intent")
    private Boolean landingIntent;
    @Json(name = "landing_type")
    private String landingType;
    @Json(name = "landing_vehicle")
    private String landingVehicle;

    public Core() {
    }

    public Core(String coreSerial, Integer flight, Integer block, Boolean gridfins, Boolean legs, Boolean reused, Boolean landSuccess, Boolean landingIntent, String landingType, String landingVehicle) {
        super();
        this.coreSerial = coreSerial;
        this.flight = flight;
        this.block = block;
        this.gridfins = gridfins;
        this.legs = legs;
        this.reused = reused;
        this.landSuccess = landSuccess;
        this.landingIntent = landingIntent;
        this.landingType = landingType;
        this.landingVehicle = landingVehicle;
    }

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public Boolean getGridfins() {
        return gridfins;
    }

    public void setGridfins(Boolean gridfins) {
        this.gridfins = gridfins;
    }

    public Boolean getLegs() {
        return legs;
    }

    public void setLegs(Boolean legs) {
        this.legs = legs;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
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

}
