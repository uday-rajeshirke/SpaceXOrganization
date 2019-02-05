
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

public class Launch {

    @Json(name = "flight_number")
    private Integer flightNumber;
    @Json(name = "mission_name")
    private String missionName;
    @Json(name = "launch_year")
    private String launchYear;
    @Json(name = "launch_date_unix")
    private Integer launchDateUnix;
    @Json(name = "launch_date_utc")
    private String launchDateUtc;
    @Json(name = "launch_date_local")
    private String launchDateLocal;
    @Json(name = "is_tentative")
    private Boolean isTentative;
    @Json(name = "rocket")
    private Rocket rocket;
    @Json(name = "telemetry")
    private Telemetry telemetry;
    @Json(name = "launch_site")
    private LaunchSite launchSite;
    @Json(name = "launch_success")
    private Boolean launchSuccess;
    @Json(name = "links")
    private Links links;
    @Json(name = "details")
    private String details;
    @Json(name = "upcoming")
    private Boolean upcoming;
    @Json(name = "static_fire_date_utc")
    private String staticFireDateUtc;

    public Launch() {
    }

    public Launch(Integer flightNumber, String missionName, String launchYear, Integer launchDateUnix, String launchDateUtc, String launchDateLocal, Boolean isTentative, Rocket rocket, Telemetry telemetry, LaunchSite launchSite, Boolean launchSuccess, Links links, String details, Boolean upcoming, String staticFireDateUtc) {
        super();
        this.flightNumber = flightNumber;
        this.missionName = missionName;
        this.launchYear = launchYear;
        this.launchDateUnix = launchDateUnix;
        this.launchDateUtc = launchDateUtc;
        this.launchDateLocal = launchDateLocal;
        this.isTentative = isTentative;
        this.rocket = rocket;
        this.telemetry = telemetry;
        this.launchSite = launchSite;
        this.launchSuccess = launchSuccess;
        this.links = links;
        this.details = details;
        this.upcoming = upcoming;
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Boolean getIsTentative() {
        return isTentative;
    }

    public void setIsTentative(Boolean isTentative) {
        this.isTentative = isTentative;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(String staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

}
