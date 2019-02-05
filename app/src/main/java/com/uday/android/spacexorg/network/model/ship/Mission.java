
package com.uday.android.spacexorg.network.model.ship;

import com.squareup.moshi.Json;

public class Mission {

    @Json(name = "name")
    private String name;
    @Json(name = "flight")
    private Integer flight;

    public Mission() {
    }


    public Mission(String name, Integer flight) {
        super();
        this.name = name;
        this.flight = flight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

}
