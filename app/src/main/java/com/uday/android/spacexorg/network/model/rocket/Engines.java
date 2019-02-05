
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class Engines {

    @Json(name = "number")
    private Integer number;
    @Json(name = "type")
    private String type;
    @Json(name = "version")
    private String version;
    @Json(name = "layout")
    private String layout;
    @Json(name = "engine_loss_max")
    private Integer engineLossMax;
    @Json(name = "propellant_1")
    private String propellant1;
    @Json(name = "propellant_2")
    private String propellant2;
    @Json(name = "thrust_sea_level")
    private ThrustSeaLevel thrustSeaLevel;
    @Json(name = "thrust_vacuum")
    private ThrustVacuum thrustVacuum;
    @Json(name = "thrust_to_weight")
    private Float thrustToWeight;

    public Engines() {
    }

    public Engines(Integer number, String type, String version, String layout, Integer engineLossMax, String propellant1, String propellant2, ThrustSeaLevel thrustSeaLevel, ThrustVacuum thrustVacuum, Float thrustToWeight) {
        super();
        this.number = number;
        this.type = type;
        this.version = version;
        this.layout = layout;
        this.engineLossMax = engineLossMax;
        this.propellant1 = propellant1;
        this.propellant2 = propellant2;
        this.thrustSeaLevel = thrustSeaLevel;
        this.thrustVacuum = thrustVacuum;
        this.thrustToWeight = thrustToWeight;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public Integer getEngineLossMax() {
        return engineLossMax;
    }

    public void setEngineLossMax(Integer engineLossMax) {
        this.engineLossMax = engineLossMax;
    }

    public String getPropellant1() {
        return propellant1;
    }

    public void setPropellant1(String propellant1) {
        this.propellant1 = propellant1;
    }

    public String getPropellant2() {
        return propellant2;
    }

    public void setPropellant2(String propellant2) {
        this.propellant2 = propellant2;
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

    public Float getThrustToWeight() {
        return thrustToWeight;
    }

    public void setThrustToWeight(Float thrustToWeight) {
        this.thrustToWeight = thrustToWeight;
    }

}
