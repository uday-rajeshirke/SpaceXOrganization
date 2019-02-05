
package com.uday.android.spacexorg.network.model.capsule;

import java.util.List;
import com.squareup.moshi.Json;

public class Capsule {

    @Json(name = "id")
    private String id;
    @Json(name = "name")
    private String name;
    @Json(name = "type")
    private String type;
    @Json(name = "active")
    private Boolean active;
    @Json(name = "crew_capacity")
    private Integer crewCapacity;
    @Json(name = "sidewall_angle_deg")
    private Integer sidewallAngleDeg;
    @Json(name = "orbit_duration_yr")
    private Integer orbitDurationYr;
    @Json(name = "dry_mass_kg")
    private Integer dryMassKg;
    @Json(name = "dry_mass_lb")
    private Integer dryMassLb;
    @Json(name = "first_flight")
    private String firstFlight;
    @Json(name = "heat_shield")
    private HeatShield heatShield;
    @Json(name = "thrusters")
    private List<Thruster> thrusters = null;
    @Json(name = "launch_payload_mass")
    private LaunchPayloadMass launchPayloadMass;
    @Json(name = "launch_payload_vol")
    private LaunchPayloadVol launchPayloadVol;
    @Json(name = "return_payload_mass")
    private ReturnPayloadMass returnPayloadMass;
    @Json(name = "return_payload_vol")
    private ReturnPayloadVol returnPayloadVol;
    @Json(name = "pressurized_capsule")
    private PressurizedCapsule pressurizedCapsule;
    @Json(name = "trunk")
    private Trunk trunk;
    @Json(name = "height_w_trunk")
    private HeightWTrunk heightWTrunk;
    @Json(name = "diameter")
    private Diameter diameter;
    @Json(name = "wikipedia")
    private String wikipedia;
    @Json(name = "description")
    private String description;


    public Capsule() {
    }

    public Capsule(String id, String name, String type, Boolean active, Integer crewCapacity, Integer sidewallAngleDeg, Integer orbitDurationYr, Integer dryMassKg, Integer dryMassLb, String firstFlight, HeatShield heatShield, List<Thruster> thrusters, LaunchPayloadMass launchPayloadMass, LaunchPayloadVol launchPayloadVol, ReturnPayloadMass returnPayloadMass, ReturnPayloadVol returnPayloadVol, PressurizedCapsule pressurizedCapsule, Trunk trunk, HeightWTrunk heightWTrunk, Diameter diameter, String wikipedia, String description) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.active = active;
        this.crewCapacity = crewCapacity;
        this.sidewallAngleDeg = sidewallAngleDeg;
        this.orbitDurationYr = orbitDurationYr;
        this.dryMassKg = dryMassKg;
        this.dryMassLb = dryMassLb;
        this.firstFlight = firstFlight;
        this.heatShield = heatShield;
        this.thrusters = thrusters;
        this.launchPayloadMass = launchPayloadMass;
        this.launchPayloadVol = launchPayloadVol;
        this.returnPayloadMass = returnPayloadMass;
        this.returnPayloadVol = returnPayloadVol;
        this.pressurizedCapsule = pressurizedCapsule;
        this.trunk = trunk;
        this.heightWTrunk = heightWTrunk;
        this.diameter = diameter;
        this.wikipedia = wikipedia;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getCrewCapacity() {
        return crewCapacity;
    }

    public void setCrewCapacity(Integer crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    public Integer getSidewallAngleDeg() {
        return sidewallAngleDeg;
    }

    public void setSidewallAngleDeg(Integer sidewallAngleDeg) {
        this.sidewallAngleDeg = sidewallAngleDeg;
    }

    public Integer getOrbitDurationYr() {
        return orbitDurationYr;
    }

    public void setOrbitDurationYr(Integer orbitDurationYr) {
        this.orbitDurationYr = orbitDurationYr;
    }

    public Integer getDryMassKg() {
        return dryMassKg;
    }

    public void setDryMassKg(Integer dryMassKg) {
        this.dryMassKg = dryMassKg;
    }

    public Integer getDryMassLb() {
        return dryMassLb;
    }

    public void setDryMassLb(Integer dryMassLb) {
        this.dryMassLb = dryMassLb;
    }

    public String getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(String firstFlight) {
        this.firstFlight = firstFlight;
    }

    public HeatShield getHeatShield() {
        return heatShield;
    }

    public void setHeatShield(HeatShield heatShield) {
        this.heatShield = heatShield;
    }

    public List<Thruster> getThrusters() {
        return thrusters;
    }

    public void setThrusters(List<Thruster> thrusters) {
        this.thrusters = thrusters;
    }

    public LaunchPayloadMass getLaunchPayloadMass() {
        return launchPayloadMass;
    }

    public void setLaunchPayloadMass(LaunchPayloadMass launchPayloadMass) {
        this.launchPayloadMass = launchPayloadMass;
    }

    public LaunchPayloadVol getLaunchPayloadVol() {
        return launchPayloadVol;
    }

    public void setLaunchPayloadVol(LaunchPayloadVol launchPayloadVol) {
        this.launchPayloadVol = launchPayloadVol;
    }

    public ReturnPayloadMass getReturnPayloadMass() {
        return returnPayloadMass;
    }

    public void setReturnPayloadMass(ReturnPayloadMass returnPayloadMass) {
        this.returnPayloadMass = returnPayloadMass;
    }

    public ReturnPayloadVol getReturnPayloadVol() {
        return returnPayloadVol;
    }

    public void setReturnPayloadVol(ReturnPayloadVol returnPayloadVol) {
        this.returnPayloadVol = returnPayloadVol;
    }

    public PressurizedCapsule getPressurizedCapsule() {
        return pressurizedCapsule;
    }

    public void setPressurizedCapsule(PressurizedCapsule pressurizedCapsule) {
        this.pressurizedCapsule = pressurizedCapsule;
    }

    public Trunk getTrunk() {
        return trunk;
    }

    public void setTrunk(Trunk trunk) {
        this.trunk = trunk;
    }

    public HeightWTrunk getHeightWTrunk() {
        return heightWTrunk;
    }

    public void setHeightWTrunk(HeightWTrunk heightWTrunk) {
        this.heightWTrunk = heightWTrunk;
    }

    public Diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter diameter) {
        this.diameter = diameter;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
