
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class Diameter {

    @Json(name = "meters")
    private Float meters;
    @Json(name = "feet")
    private Integer feet;

    public Diameter() {
    }

    public Diameter(Float meters, Integer feet) {
        super();
        this.meters = meters;
        this.feet = feet;
    }

    public Float getMeters() {
        return meters;
    }

    public void setMeters(Float meters) {
        this.meters = meters;
    }

    public Integer getFeet() {
        return feet;
    }

    public void setFeet(Integer feet) {
        this.feet = feet;
    }

}
