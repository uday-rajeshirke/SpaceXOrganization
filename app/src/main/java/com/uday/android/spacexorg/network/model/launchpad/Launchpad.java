
package com.uday.android.spacexorg.network.model.launchpad;

import java.util.List;
import com.squareup.moshi.Json;

public class Launchpad {

    @Json(name = "id")
    private Integer id;
    @Json(name = "status")
    private String status;
    @Json(name = "location")
    private Location location;
    @Json(name = "vehicles_launched")
    private List<String> vehiclesLaunched = null;
    @Json(name = "attempted_launches")
    private Integer attemptedLaunches;
    @Json(name = "successful_launches")
    private Integer successfulLaunches;
    @Json(name = "wikipedia")
    private String wikipedia;
    @Json(name = "details")
    private String details;
    @Json(name = "site_id")
    private String siteId;
    @Json(name = "site_name_long")
    private String siteNameLong;

    public Launchpad() {
    }

    public Launchpad(Integer id, String status, Location location, List<String> vehiclesLaunched, Integer attemptedLaunches, Integer successfulLaunches, String wikipedia, String details, String siteId, String siteNameLong) {
        super();
        this.id = id;
        this.status = status;
        this.location = location;
        this.vehiclesLaunched = vehiclesLaunched;
        this.attemptedLaunches = attemptedLaunches;
        this.successfulLaunches = successfulLaunches;
        this.wikipedia = wikipedia;
        this.details = details;
        this.siteId = siteId;
        this.siteNameLong = siteNameLong;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<String> getVehiclesLaunched() {
        return vehiclesLaunched;
    }

    public void setVehiclesLaunched(List<String> vehiclesLaunched) {
        this.vehiclesLaunched = vehiclesLaunched;
    }

    public Integer getAttemptedLaunches() {
        return attemptedLaunches;
    }

    public void setAttemptedLaunches(Integer attemptedLaunches) {
        this.attemptedLaunches = attemptedLaunches;
    }

    public Integer getSuccessfulLaunches() {
        return successfulLaunches;
    }

    public void setSuccessfulLaunches(Integer successfulLaunches) {
        this.successfulLaunches = successfulLaunches;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }

}
