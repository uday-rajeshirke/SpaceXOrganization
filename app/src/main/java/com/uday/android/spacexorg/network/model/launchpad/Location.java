
package com.uday.android.spacexorg.network.model.launchpad;

import com.squareup.moshi.Json;

public class Location {

    @Json(name = "name")
    private String name;
    @Json(name = "region")
    private String region;
    @Json(name = "latitude")
    private Float latitude;
    @Json(name = "longitude")
    private Float longitude;

    public Location() {
    }

    public Location(String name, String region, Float latitude, Float longitude) {
        super();
        this.name = name;
        this.region = region;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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
