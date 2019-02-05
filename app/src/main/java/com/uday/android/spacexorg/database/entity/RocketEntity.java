
package com.uday.android.spacexorg.database.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;

import com.uday.android.spacexorg.network.model.rocket.PayloadWeight;
import com.uday.android.spacexorg.network.model.rocket.Rocket;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.lang.reflect.Type;
import java.util.List;

@Entity(tableName = "rocket_table")
public class RocketEntity {

    @PrimaryKey
    @ColumnInfo(name = "rocket_entity_id")
    private Integer id;
    @ColumnInfo(name = "rocket_entity_active")
    @Nullable
    private Boolean active;
    @ColumnInfo(name = "rocket_entity_stages")
    @Nullable
    private Integer stages;
    @ColumnInfo(name = "rocket_entity_cost_per_launch")
    @Nullable
    private Integer costPerLaunch;
    @ColumnInfo(name = "rocket_entity_first_flight")
    @Nullable
    private String firstFlight;
    @ColumnInfo(name = "rocket_entity_country")
    @Nullable
    private String country;
    @ColumnInfo(name = "rocket_entity_height")
    @Nullable
    private Float heightMeters;
    @ColumnInfo(name = "rocket_entity_diameter")
    @Nullable
    private Float diameterMeters;
    @ColumnInfo(name = "rocket_entity_mass")
    @Nullable
    private Integer massKg;
    @ColumnInfo(name = "rocket_entity_payload_weight")
    @Nullable
    private String payloadWeights;
    @ColumnInfo(name = "rocket_entity_first_stage_engines")
    @Nullable
    private Integer firstStageEngines;
    @ColumnInfo(name = "rocket_entity_first_stage_fuel")
    @Nullable
    private Float firstStageFuelAmountTons;
    @ColumnInfo(name = "rocket_entity_second_stage_engines")
    @Nullable
    private Integer secondStageEngines;
    @ColumnInfo(name = "rocket_entity_second_stage_fuel")
    @Nullable
    private Float secondStageFuelAmountTons;
    @ColumnInfo(name = "rocket_entity_engines_type")
    @Nullable
    private String enginesType;
    @ColumnInfo(name = "rocket_entity_engines_version")
    @Nullable
    private String enginesVersion;
    @ColumnInfo(name = "rocket_entity_propellant1")
    @Nullable
    private String propellant1;
    @ColumnInfo(name = "rocket_entity_propellant2")
    @Nullable
    private String propellant2;
    @ColumnInfo(name = "rocket_entity_thrust_sea_level")
    @Nullable
    private Integer thrustSeaLevel;
    @ColumnInfo(name = "rocket_entity_thrust_vacuum")
    @Nullable
    private Integer thrustVacuum;
    @ColumnInfo(name = "rocket_entity_thrust_to_weight")
    @Nullable
    private Float thrustToWeight;
    @ColumnInfo(name = "rocket_entity_description")
    @Nullable
    private String description;
    @ColumnInfo(name = "rocket_entity_rocket_id")
    @Nullable
    private String rocketId;
    @ColumnInfo(name = "rocket_entity_rocket_name")
    @Nullable
    private String rocketName;
    @ColumnInfo(name = "rocket_entity_rocket_type")
    @Nullable
    private String rocketType;

    @Ignore
    public RocketEntity() {
    }

    public RocketEntity(Integer id, Boolean active, Integer stages, Integer costPerLaunch, String firstFlight, String country, Float heightMeters, Float diameterMeters, Integer massKg, String payloadWeights, Integer firstStageEngines, Float firstStageFuelAmountTons, Integer secondStageEngines, Float secondStageFuelAmountTons, String enginesType, String enginesVersion, String propellant1, String propellant2, Integer thrustSeaLevel, Integer thrustVacuum, Float thrustToWeight, String description, String rocketId, String rocketName, String rocketType) {
        super();
        this.id = id;
        this.active = active;
        this.stages = stages;
        this.costPerLaunch = costPerLaunch;
        this.firstFlight = firstFlight;
        this.country = country;
        this.heightMeters = heightMeters;
        this.diameterMeters = diameterMeters;
        this.massKg = massKg;
        this.payloadWeights = payloadWeights;
        this.firstStageEngines = firstStageEngines;
        this.firstStageFuelAmountTons = firstStageFuelAmountTons;
        this.secondStageEngines = secondStageEngines;
        this.secondStageFuelAmountTons = secondStageFuelAmountTons;
        this.enginesType = enginesType;
        this.enginesVersion = enginesVersion;
        this.propellant1 = propellant1;
        this.propellant2 = propellant2;
        this.thrustSeaLevel = thrustSeaLevel;
        this.thrustVacuum = thrustVacuum;
        this.thrustToWeight = thrustToWeight;
        this.description = description;
        this.rocketId = rocketId;
        this.rocketName = rocketName;
        this.rocketType = rocketType;
    }

    public RocketEntity(Rocket rocket) {
        super();
        this.id = rocket.getId();
        this.active = rocket.getActive();
        this.stages = rocket.getStages();
        this.costPerLaunch = rocket.getCostPerLaunch();
        this.firstFlight = rocket.getFirstFlight();
        this.country = rocket.getCountry();
        this.heightMeters = rocket.getHeight().getMeters();
        this.diameterMeters = rocket.getDiameter().getMeters();
        this.massKg = rocket.getMass().getKg();
        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, PayloadWeight.class);
        JsonAdapter<List<PayloadWeight>> jsonAdapter = moshi.adapter(type);
        this.payloadWeights = jsonAdapter.toJson(rocket.getPayloadWeights());
        this.firstStageEngines = rocket.getFirstStage().getEngines();
        this.firstStageFuelAmountTons = rocket.getFirstStage().getFuelAmountTons();
        this.secondStageEngines = rocket.getSecondStage().getEngines();
        this.secondStageFuelAmountTons = rocket.getSecondStage().getFuelAmountTons();
        this.enginesType = rocket.getEngines().getType();
        this.enginesVersion = rocket.getEngines().getVersion();
        this.propellant1 = rocket.getEngines().getPropellant1();
        this.propellant2 = rocket.getEngines().getPropellant2();
        this.thrustSeaLevel = rocket.getEngines().getThrustSeaLevel().getKN();
        this.thrustVacuum = rocket.getEngines().getThrustVacuum().getKN();
        this.thrustToWeight = rocket.getEngines().getThrustToWeight();
        this.description = rocket.getDescription();
        this.rocketId = rocket.getRocketId();
        this.rocketName = rocket.getRocketName();
        this.rocketType = rocket.getRocketType();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getStages() {
        return stages;
    }

    public void setStages(Integer stages) {
        this.stages = stages;
    }

    public Integer getCostPerLaunch() {
        return costPerLaunch;
    }

    public void setCostPerLaunch(Integer costPerLaunch) {
        this.costPerLaunch = costPerLaunch;
    }

    public String getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(String firstFlight) {
        this.firstFlight = firstFlight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Float getHeightMeters() {
        return heightMeters;
    }

    public void setHeightMeters(Float heightMeters) {
        this.heightMeters = heightMeters;
    }

    public Float getDiameterMeters() {
        return diameterMeters;
    }

    public void setDiameterMeters(Float diameterMeters) {
        this.diameterMeters = diameterMeters;
    }

    public Integer getMassKg() {
        return massKg;
    }

    public void setMassKg(Integer massKg) {
        this.massKg = massKg;
    }

    public String getPayloadWeights() {
        return payloadWeights;
    }

    public void setPayloadWeights(String payloadWeights) {
        this.payloadWeights = payloadWeights;
    }

    public Integer getFirstStageEngines() {
        return firstStageEngines;
    }

    public void setFirstStageEngines(Integer firstStageEngines) {
        this.firstStageEngines = firstStageEngines;
    }

    public Float getFirstStageFuelAmountTons() {
        return firstStageFuelAmountTons;
    }

    public void setFirstStageFuelAmountTons(Float firstStageFuelAmountTons) {
        this.firstStageFuelAmountTons = firstStageFuelAmountTons;
    }

    public Integer getSecondStageEngines() {
        return secondStageEngines;
    }

    public void setSecondStageEngines(Integer secondStageEngines) {
        this.secondStageEngines = secondStageEngines;
    }

    public Float getSecondStageFuelAmountTons() {
        return secondStageFuelAmountTons;
    }

    public void setSecondStageFuelAmountTons(Float secondStageFuelAmountTons) {
        this.secondStageFuelAmountTons = secondStageFuelAmountTons;
    }

    public String getEnginesType() {
        return enginesType;
    }

    public void setEnginesType(String enginesType) {
        this.enginesType = enginesType;
    }

    public String getEnginesVersion() {
        return enginesVersion;
    }

    public void setEnginesVersion(String enginesVersion) {
        this.enginesVersion = enginesVersion;
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

    public Integer getThrustSeaLevel() {
        return thrustSeaLevel;
    }

    public void setThrustSeaLevel(Integer thrustSeaLevel) {
        this.thrustSeaLevel = thrustSeaLevel;
    }

    public Integer getThrustVacuum() {
        return thrustVacuum;
    }

    public void setThrustVacuum(Integer thrustVacuum) {
        this.thrustVacuum = thrustVacuum;
    }

    public Float getThrustToWeight() {
        return thrustToWeight;
    }

    public void setThrustToWeight(Float thrustToWeight) {
        this.thrustToWeight = thrustToWeight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

}
