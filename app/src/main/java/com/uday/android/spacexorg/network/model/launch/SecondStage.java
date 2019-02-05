
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

import java.util.List;

public class SecondStage {

    @Json(name = "block")
    private Integer block;
    @Json(name = "payloads")
    private List<Payload> payloads = null;

    public SecondStage() {
    }

    public SecondStage(Integer block, List<Payload> payloads) {
        super();
        this.block = block;
        this.payloads = payloads;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

}
