
package com.uday.android.spacexorg.network.model.rocket;

import java.util.List;
import com.squareup.moshi.Json;

public class Rocket {

    @Json(name = "id")
    private Integer id;
    @Json(name = "active")
    private Boolean active;
    @Json(name = "stages")
    private Integer stages;
    @Json(name = "boosters")
    private Integer boosters;
    @Json(name = "cost_per_launch")
    private Integer costPerLaunch;
    @Json(name = "success_rate_pct")
    private Integer successRatePct;
    @Json(name = "first_flight")
    private String firstFlight;
    @Json(name = "country")
    private String country;
    @Json(name = "company")
    private String company;
    @Json(name = "height")
    private Height height;
    @Json(name = "diameter")
    private Diameter diameter;
    @Json(name = "mass")
    private Mass mass;
    @Json(name = "payload_weights")
    private List<PayloadWeight> payloadWeights = null;
    @Json(name = "first_stage")
    private FirstStage firstStage;
    @Json(name = "second_stage")
    private SecondStage secondStage;
    @Json(name = "engines")
    private Engines engines;
    @Json(name = "landing_legs")
    private LandingLegs landingLegs;
    @Json(name = "wikipedia")
    private String wikipedia;
    @Json(name = "description")
    private String description;
    @Json(name = "rocket_id")
    private String rocketId;
    @Json(name = "rocket_name")
    private String rocketName;
    @Json(name = "rocket_type")
    private String rocketType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rocket() {
    }

    /**
     * 
     * @param diameter
     * @param rocketName
     * @param payloadWeights
     * @param rocketType
     * @param successRatePct
     * @param engines
     * @param secondStage
     * @param boosters
     * @param firstStage
     * @param stages
     * @param country
     * @param id
     * @param mass
     * @param height
     * @param rocketId
     * @param description
     * @param company
     * @param wikipedia
     * @param landingLegs
     * @param active
     * @param costPerLaunch
     * @param firstFlight
     */
    public Rocket(Integer id, Boolean active, Integer stages, Integer boosters, Integer costPerLaunch, Integer successRatePct, String firstFlight, String country, String company, Height height, Diameter diameter, Mass mass, List<PayloadWeight> payloadWeights, FirstStage firstStage, SecondStage secondStage, Engines engines, LandingLegs landingLegs, String wikipedia, String description, String rocketId, String rocketName, String rocketType) {
        super();
        this.id = id;
        this.active = active;
        this.stages = stages;
        this.boosters = boosters;
        this.costPerLaunch = costPerLaunch;
        this.successRatePct = successRatePct;
        this.firstFlight = firstFlight;
        this.country = country;
        this.company = company;
        this.height = height;
        this.diameter = diameter;
        this.mass = mass;
        this.payloadWeights = payloadWeights;
        this.firstStage = firstStage;
        this.secondStage = secondStage;
        this.engines = engines;
        this.landingLegs = landingLegs;
        this.wikipedia = wikipedia;
        this.description = description;
        this.rocketId = rocketId;
        this.rocketName = rocketName;
        this.rocketType = rocketType;
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

    public Integer getBoosters() {
        return boosters;
    }

    public void setBoosters(Integer boosters) {
        this.boosters = boosters;
    }

    public Integer getCostPerLaunch() {
        return costPerLaunch;
    }

    public void setCostPerLaunch(Integer costPerLaunch) {
        this.costPerLaunch = costPerLaunch;
    }

    public Integer getSuccessRatePct() {
        return successRatePct;
    }

    public void setSuccessRatePct(Integer successRatePct) {
        this.successRatePct = successRatePct;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter diameter) {
        this.diameter = diameter;
    }

    public Mass getMass() {
        return mass;
    }

    public void setMass(Mass mass) {
        this.mass = mass;
    }

    public List<PayloadWeight> getPayloadWeights() {
        return payloadWeights;
    }

    public void setPayloadWeights(List<PayloadWeight> payloadWeights) {
        this.payloadWeights = payloadWeights;
    }

    public FirstStage getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public SecondStage getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(SecondStage secondStage) {
        this.secondStage = secondStage;
    }

    public Engines getEngines() {
        return engines;
    }

    public void setEngines(Engines engines) {
        this.engines = engines;
    }

    public LandingLegs getLandingLegs() {
        return landingLegs;
    }

    public void setLandingLegs(LandingLegs landingLegs) {
        this.landingLegs = landingLegs;
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
