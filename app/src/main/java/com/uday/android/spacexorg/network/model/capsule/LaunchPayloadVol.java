
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class LaunchPayloadVol {

    @Json(name = "cubic_meters")
    private Integer cubicMeters;
    @Json(name = "cubic_feet")
    private Integer cubicFeet;

    public LaunchPayloadVol() {
    }

    public LaunchPayloadVol(Integer cubicMeters, Integer cubicFeet) {
        super();
        this.cubicMeters = cubicMeters;
        this.cubicFeet = cubicFeet;
    }

    public Integer getCubicMeters() {
        return cubicMeters;
    }

    public void setCubicMeters(Integer cubicMeters) {
        this.cubicMeters = cubicMeters;
    }

    public Integer getCubicFeet() {
        return cubicFeet;
    }

    public void setCubicFeet(Integer cubicFeet) {
        this.cubicFeet = cubicFeet;
    }

}
