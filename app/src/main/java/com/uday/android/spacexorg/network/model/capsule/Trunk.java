
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class Trunk {

    @Json(name = "trunk_volume")
    private TrunkVolume trunkVolume;
    @Json(name = "cargo")
    private Cargo cargo;

    public Trunk() {
    }

    public Trunk(TrunkVolume trunkVolume, Cargo cargo) {
        super();
        this.trunkVolume = trunkVolume;
        this.cargo = cargo;
    }

    public TrunkVolume getTrunkVolume() {
        return trunkVolume;
    }

    public void setTrunkVolume(TrunkVolume trunkVolume) {
        this.trunkVolume = trunkVolume;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
