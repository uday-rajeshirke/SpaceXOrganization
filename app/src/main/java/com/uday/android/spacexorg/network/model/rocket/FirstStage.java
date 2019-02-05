
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class FirstStage {

    @Json(name = "reusable")
    private Boolean reusable;
    @Json(name = "engines")
    private Integer engines;
    @Json(name = "fuel_amount_tons")
    private Float fuelAmountTons;
    @Json(name = "burn_time_sec")
    private Integer burnTimeSec;
    @Json(name = "thrust_sea_level")
    private ThrustSeaLevel thrustSeaLevel;
    @Json(name = "thrust_vacuum")
    private ThrustVacuum thrustVacuum;
    @Json(name = "cores")
    private Integer cores;

    public FirstStage() {
    }

    public FirstStage(Boolean reusable, Integer engines, Float fuelAmountTons, Integer burnTimeSec, ThrustSeaLevel thrustSeaLevel, ThrustVacuum thrustVacuum, Integer cores) {
        super();
        this.reusable = reusable;
        this.engines = engines;
        this.fuelAmountTons = fuelAmountTons;
        this.burnTimeSec = burnTimeSec;
        this.thrustSeaLevel = thrustSeaLevel;
        this.thrustVacuum = thrustVacuum;
        this.cores = cores;
    }

    public Boolean getReusable() {
        return reusable;
    }

    public void setReusable(Boolean reusable) {
        this.reusable = reusable;
    }

    public Integer getEngines() {
        return engines;
    }

    public void setEngines(Integer engines) {
        this.engines = engines;
    }

    public Float getFuelAmountTons() {
        return fuelAmountTons;
    }

    public void setFuelAmountTons(Float fuelAmountTons) {
        this.fuelAmountTons = fuelAmountTons;
    }

    public Integer getBurnTimeSec() {
        return burnTimeSec;
    }

    public void setBurnTimeSec(Integer burnTimeSec) {
        this.burnTimeSec = burnTimeSec;
    }

    public ThrustSeaLevel getThrustSeaLevel() {
        return thrustSeaLevel;
    }

    public void setThrustSeaLevel(ThrustSeaLevel thrustSeaLevel) {
        this.thrustSeaLevel = thrustSeaLevel;
    }

    public ThrustVacuum getThrustVacuum() {
        return thrustVacuum;
    }

    public void setThrustVacuum(ThrustVacuum thrustVacuum) {
        this.thrustVacuum = thrustVacuum;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

}
