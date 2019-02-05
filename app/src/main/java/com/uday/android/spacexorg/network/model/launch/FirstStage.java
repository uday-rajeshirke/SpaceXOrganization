
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

import java.util.List;

public class FirstStage {

    @Json(name = "cores")
    private List<Core> cores = null;

    public FirstStage() {
    }

    public FirstStage(List<Core> cores) {
        super();
        this.cores = cores;
    }

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

}
