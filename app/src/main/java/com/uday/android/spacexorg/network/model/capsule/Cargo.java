
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class Cargo {

    @Json(name = "solar_array")
    private Integer solarArray;
    @Json(name = "unpressurized_cargo")
    private Boolean unpressurizedCargo;

    public Cargo() {
    }

    public Cargo(Integer solarArray, Boolean unpressurizedCargo) {
        super();
        this.solarArray = solarArray;
        this.unpressurizedCargo = unpressurizedCargo;
    }

    public Integer getSolarArray() {
        return solarArray;
    }

    public void setSolarArray(Integer solarArray) {
        this.solarArray = solarArray;
    }

    public Boolean getUnpressurizedCargo() {
        return unpressurizedCargo;
    }

    public void setUnpressurizedCargo(Boolean unpressurizedCargo) {
        this.unpressurizedCargo = unpressurizedCargo;
    }

}
