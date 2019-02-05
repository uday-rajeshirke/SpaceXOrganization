
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class CompositeFairing {

    @Json(name = "height")
    private Height height;
    @Json(name = "diameter")
    private Diameter diameter;

    public CompositeFairing() {
    }

    public CompositeFairing(Height height, Diameter diameter) {
        super();
        this.height = height;
        this.diameter = diameter;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter diameter) {
        this.diameter = diameter;
    }

}
