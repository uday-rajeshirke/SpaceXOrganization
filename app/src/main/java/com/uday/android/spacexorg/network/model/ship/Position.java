
package com.uday.android.spacexorg.network.model.ship;

import com.squareup.moshi.Json;

public class Position {

    @Json(name = "latitude")
    private Float latitude;
    @Json(name = "longitude")
    private Float longitude;

    public Position() {
    }

    public Position(Float latitude, Float longitude) {
        super();
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

}
