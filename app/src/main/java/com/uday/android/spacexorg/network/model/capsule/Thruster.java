
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class Thruster {

    @Json(name = "type")
    private String type;
    @Json(name = "amount")
    private Integer amount;
    @Json(name = "pods")
    private Integer pods;
    @Json(name = "fuel_1")
    private String fuel1;
    @Json(name = "fuel_2")
    private String fuel2;
    @Json(name = "thrust")
    private Thrust thrust;

    public Thruster() {
    }

    public Thruster(String type, Integer amount, Integer pods, String fuel1, String fuel2, Thrust thrust) {
        super();
        this.type = type;
        this.amount = amount;
        this.pods = pods;
        this.fuel1 = fuel1;
        this.fuel2 = fuel2;
        this.thrust = thrust;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPods() {
        return pods;
    }

    public void setPods(Integer pods) {
        this.pods = pods;
    }

    public String getFuel1() {
        return fuel1;
    }

    public void setFuel1(String fuel1) {
        this.fuel1 = fuel1;
    }

    public String getFuel2() {
        return fuel2;
    }

    public void setFuel2(String fuel2) {
        this.fuel2 = fuel2;
    }

    public Thrust getThrust() {
        return thrust;
    }

    public void setThrust(Thrust thrust) {
        this.thrust = thrust;
    }

}
