
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class HeatShield {

    @Json(name = "material")
    private String material;
    @Json(name = "size_meters")
    private Float sizeMeters;
    @Json(name = "temp_degrees")
    private Integer tempDegrees;
    @Json(name = "dev_partner")
    private String devPartner;

    public HeatShield() {
    }

    public HeatShield(String material, Float sizeMeters, Integer tempDegrees, String devPartner) {
        super();
        this.material = material;
        this.sizeMeters = sizeMeters;
        this.tempDegrees = tempDegrees;
        this.devPartner = devPartner;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Float getSizeMeters() {
        return sizeMeters;
    }

    public void setSizeMeters(Float sizeMeters) {
        this.sizeMeters = sizeMeters;
    }

    public Integer getTempDegrees() {
        return tempDegrees;
    }

    public void setTempDegrees(Integer tempDegrees) {
        this.tempDegrees = tempDegrees;
    }

    public String getDevPartner() {
        return devPartner;
    }

    public void setDevPartner(String devPartner) {
        this.devPartner = devPartner;
    }

}
