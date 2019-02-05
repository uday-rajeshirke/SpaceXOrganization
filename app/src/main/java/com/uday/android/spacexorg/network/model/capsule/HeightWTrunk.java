
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class HeightWTrunk {

    @Json(name = "meters")
    private Float meters;
    @Json(name = "feet")
    private Float feet;

    public HeightWTrunk() {
    }
    
    public HeightWTrunk(Float meters, Float feet) {
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
