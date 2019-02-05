
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class LandingLegs {

    @Json(name = "number")
    private Integer number;
    @Json(name = "material")
    private String material;

    public LandingLegs() {
    }

    public LandingLegs(Integer number, String material) {
        super();
        this.number = number;
        this.material = material;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

}
