
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

public class Fairings {

    @Json(name = "reused")
    private Boolean reused;
    @Json(name = "recovery_attempt")
    private Boolean recoveryAttempt;
    @Json(name = "recovered")
    private Boolean recovered;
    @Json(name = "ship")
    private String ship;

    public Fairings() {
    }

    public Fairings(Boolean reused, Boolean recoveryAttempt, Boolean recovered, String ship) {
        super();
        this.reused = reused;
        this.recoveryAttempt = recoveryAttempt;
        this.recovered = recovered;
        this.ship = ship;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public Boolean getRecoveryAttempt() {
        return recoveryAttempt;
    }

    public void setRecoveryAttempt(Boolean recoveryAttempt) {
        this.recoveryAttempt = recoveryAttempt;
    }

    public Boolean getRecovered() {
        return recovered;
    }

    public void setRecovered(Boolean recovered) {
        this.recovered = recovered;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

}
