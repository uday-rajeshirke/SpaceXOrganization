
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class Payloads {

    @Json(name = "option_1")
    private String option1;
    @Json(name = "composite_fairing")
    private CompositeFairing compositeFairing;
    @Json(name = "option_2")
    private String option2;

    public Payloads() {
    }

    public Payloads(String option1, CompositeFairing compositeFairing, String option2) {
        super();
        this.option1 = option1;
        this.compositeFairing = compositeFairing;
        this.option2 = option2;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public CompositeFairing getCompositeFairing() {
        return compositeFairing;
    }

    public void setCompositeFairing(CompositeFairing compositeFairing) {
        this.compositeFairing = compositeFairing;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

}
