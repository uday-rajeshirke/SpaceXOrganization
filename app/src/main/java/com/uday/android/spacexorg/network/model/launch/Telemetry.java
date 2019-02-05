
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

public class Telemetry {

    @Json(name = "flight_club")
    private String flightClub;

    public Telemetry() {
    }

    public Telemetry(String flightClub) {
        super();
        this.flightClub = flightClub;
    }

    public String getFlightClub() {
        return flightClub;
    }

    public void setFlightClub(String flightClub) {
        this.flightClub = flightClub;
    }

}
