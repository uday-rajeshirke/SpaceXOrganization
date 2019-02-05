
package com.uday.android.spacexorg.network.model.company;

import com.squareup.moshi.Json;

public class Headquarters {

    @Json(name = "address")
    private String address;
    @Json(name = "city")
    private String city;
    @Json(name = "state")
    private String state;

    public Headquarters() {
    }

    public Headquarters(String address, String city, String state) {
        super();
        this.address = address;
        this.city = city;
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
