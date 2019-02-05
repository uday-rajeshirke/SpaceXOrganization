
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

import java.util.List;

public class Payload {

    @Json(name = "payload_id")
    private String payloadId;
    @Json(name = "norad_id")
    private List<Integer> noradId = null;
    @Json(name = "reused")
    private Boolean reused;
    @Json(name = "customers")
    private List<String> customers = null;
    @Json(name = "nationality")
    private String nationality;
    @Json(name = "manufacturer")
    private String manufacturer;
    @Json(name = "payload_type")
    private String payloadType;
    @Json(name = "payload_mass_kg")
    private Float payloadMassKg;
    @Json(name = "payload_mass_lbs")
    private Float payloadMassLbs;
    @Json(name = "orbit")
    private String orbit;
    @Json(name = "orbit_params")
    private OrbitParams orbitParams;

    public Payload() {
    }

    public Payload(String payloadId, List<Integer> noradId, Boolean reused, List<String> customers, String nationality, String manufacturer, String payloadType, Float payloadMassKg, Float payloadMassLbs, String orbit, OrbitParams orbitParams) {
        super();
        this.payloadId = payloadId;
        this.noradId = noradId;
        this.reused = reused;
        this.customers = customers;
        this.nationality = nationality;
        this.manufacturer = manufacturer;
        this.payloadType = payloadType;
        this.payloadMassKg = payloadMassKg;
        this.payloadMassLbs = payloadMassLbs;
        this.orbit = orbit;
        this.orbitParams = orbitParams;
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public List<Integer> getNoradId() {
        return noradId;
    }

    public void setNoradId(List<Integer> noradId) {
        this.noradId = noradId;
    }

    public Boolean getReused() {
        return reused;
    }

    public void setReused(Boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public Float getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(Float payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public Float getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(Float payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbitParams;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbitParams = orbitParams;
    }

}
