
package com.uday.android.spacexorg.network.model.capsule;

import com.squareup.moshi.Json;

public class PressurizedCapsule {

    @Json(name = "payload_volume")
    private PayloadVolume payloadVolume;

    public PressurizedCapsule() {
    }


    public PressurizedCapsule(PayloadVolume payloadVolume) {
        super();
        this.payloadVolume = payloadVolume;
    }

    public PayloadVolume getPayloadVolume() {
        return payloadVolume;
    }

    public void setPayloadVolume(PayloadVolume payloadVolume) {
        this.payloadVolume = payloadVolume;
    }

}
