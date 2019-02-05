
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class Thrust {

    @Json(name = "kN")
    private Integer kN;
    @Json(name = "lbf")
    private Integer lbf;

    public Thrust() {
    }


    public Thrust(Integer kN, Integer lbf) {
        super();
        this.kN = kN;
        this.lbf = lbf;
    }

    public Integer getKN() {
        return kN;
    }

    public void setKN(Integer kN) {
        this.kN = kN;
    }

    public Integer getLbf() {
        return lbf;
    }

    public void setLbf(Integer lbf) {
        this.lbf = lbf;
    }

}
