
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class Height {

    @Json(name = "meters")
    private Float meters;
    @Json(name = "feet")
    private Float feet;

    public Height() {
    }

    public Height(Float meters, Float feet) {
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

    public Float getFeet() {
        return feet;
    }

    public void setFeet(Float feet) {
        this.feet = feet;
    }

}
