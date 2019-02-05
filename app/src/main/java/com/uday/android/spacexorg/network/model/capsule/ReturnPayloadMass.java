
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class ReturnPayloadMass {

    @Json(name = "kg")
    private Integer kg;
    @Json(name = "lb")
    private Integer lb;

    public ReturnPayloadMass() {
    }

    public ReturnPayloadMass(Integer kg, Integer lb) {
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
