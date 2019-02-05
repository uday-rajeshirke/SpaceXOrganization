
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class Mass {

    @Json(name = "kg")
    private Integer kg;
    @Json(name = "lb")
    private Integer lb;

    public Mass() {
    }


    public Mass(Integer kg, Integer lb) {
        super();
        this.kg = kg;
        this.lb = lb;
    }

    public Integer getKg() {
        return kg;
    }

    public void setKg(Integer kg) {
        this.kg = kg;
    }

    public Integer getLb() {
        return lb;
    }

    public void setLb(Integer lb) {
        this.lb = lb;
    }

}
