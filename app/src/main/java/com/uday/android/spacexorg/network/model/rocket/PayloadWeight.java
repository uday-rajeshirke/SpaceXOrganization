
package com.uday.android.spacexorg.network.model.rocket;

import com.squareup.moshi.Json;

public class PayloadWeight {

    @Json(name = "id")
    private String id;
    @Json(name = "name")
    private String name;
    @Json(name = "kg")
    private Integer kg;
    @Json(name = "lb")
    private Integer lb;

    public PayloadWeight() {
    }

    public PayloadWeight(String id, String name, Integer kg, Integer lb) {
        super();
        this.id = id;
        this.name = name;
        this.kg = kg;
        this.lb = lb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
