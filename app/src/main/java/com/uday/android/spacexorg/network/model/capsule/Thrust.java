
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class Thrust {

    @Json(name = "kN")
    private Float kN;
    @Json(name = "lbf")
    private Float lbf;


    public Thrust() {
    }


    public Thrust(Float kN, Float lbf) {
        super();
        this.kN = kN;
        this.lbf = lbf;
    }

    public Float getKN() {
        return kN;
    }

    public void setKN(Float kN) {
        this.kN = kN;
    }

    public Float getLbf() {
        return lbf;
    }

    public void setLbf(Float lbf) {
        this.lbf = lbf;
    }

}
