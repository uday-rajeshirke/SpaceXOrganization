
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

public class Rocket {

    @Json(name = "rocket_id")
    private String rocketId;
    @Json(name = "rocket_name")
    private String rocketName;
    @Json(name = "rocket_type")
    private String rocketType;
    @Json(name = "first_stage")
    private FirstStage firstStage;
    @Json(name = "second_stage")
    private SecondStage secondStage;
    @Json(name = "fairings")
    private Fairings fairings;

    public Rocket() {
    }

    public Rocket(String rocketId, String rocketName, String rocketType, FirstStage firstStage, SecondStage secondStage, Fairings fairings) {
        super();
        this.rocketId = rocketId;
        this.rocketName = rocketName;
        this.rocketType = rocketType;
        this.firstStage = firstStage;
        this.secondStage = secondStage;
        this.fairings = fairings;
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

    public Fairings getFairings() {
        return fairings;
    }

    public void setFairings(Fairings fairings) {
        this.fairings = fairings;
    }

}
