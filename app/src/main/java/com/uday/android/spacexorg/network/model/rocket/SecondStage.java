
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class SecondStage {

    @Json(name = "engines")
    private Integer engines;
    @Json(name = "fuel_amount_tons")
    private Float fuelAmountTons;
    @Json(name = "burn_time_sec")
    private Integer burnTimeSec;
    @Json(name = "thrust")
    private Thrust thrust;
    @Json(name = "payloads")
    private Payloads payloads;

    public SecondStage() {
    }

    public SecondStage(Integer engines, Float fuelAmountTons, Integer burnTimeSec, Thrust thrust, Payloads payloads) {
        super();
        this.engines = engines;
        this.fuelAmountTons = fuelAmountTons;
        this.burnTimeSec = burnTimeSec;
        this.thrust = thrust;
        this.payloads = payloads;
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

    public Thrust getThrust() {
        return thrust;
    }

    public void setThrust(Thrust thrust) {
        this.thrust = thrust;
    }

    public Payloads getPayloads() {
        return payloads;
    }

    public void setPayloads(Payloads payloads) {
        this.payloads = payloads;
    }

}
