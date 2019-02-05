
package com.uday.android.spacexorg.network.model.roadster;

import com.squareup.moshi.Json;

public class Roadster {

    @Json(name = "name")
    private String name;
    @Json(name = "launch_date_utc")
    private String launchDateUtc;
    @Json(name = "launch_date_unix")
    private Integer launchDateUnix;
    @Json(name = "launch_mass_kg")
    private Integer launchMassKg;
    @Json(name = "launch_mass_lbs")
    private Integer launchMassLbs;
    @Json(name = "norad_id")
    private Integer noradId;
    @Json(name = "epoch_jd")
    private Float epochJd;
    @Json(name = "orbit_type")
    private String orbitType;
    @Json(name = "apoapsis_au")
    private Float apoapsisAu;
    @Json(name = "periapsis_au")
    private Float periapsisAu;
    @Json(name = "semi_major_axis_au")
    private Float semiMajorAxisAu;
    @Json(name = "eccentricity")
    private Float eccentricity;
    @Json(name = "inclination")
    private Float inclination;
    @Json(name = "longitude")
    private Float longitude;
    @Json(name = "periapsis_arg")
    private Float periapsisArg;
    @Json(name = "period_days")
    private Float periodDays;
    @Json(name = "speed_kph")
    private Float speedKph;
    @Json(name = "speed_mph")
    private Float speedMph;
    @Json(name = "earth_distance_km")
    private Float earthDistanceKm;
    @Json(name = "earth_distance_mi")
    private Float earthDistanceMi;
    @Json(name = "mars_distance_km")
    private Float marsDistanceKm;
    @Json(name = "mars_distance_mi")
    private Float marsDistanceMi;
    @Json(name = "wikipedia")
    private String wikipedia;
    @Json(name = "details")
    private String details;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Roadster() {
    }

    /**
     * 
     * @param launchMassLbs
     * @param speedKph
     * @param periapsisArg
     * @param earthDistanceMi
     * @param marsDistanceMi
     * @param inclination
     * @param orbitType
     * @param eccentricity
     * @param launchMassKg
     * @param epochJd
     * @param details
     * @param launchDateUtc
     * @param periodDays
     * @param periapsisAu
     * @param name
     * @param wikipedia
     * @param earthDistanceKm
     * @param longitude
     * @param marsDistanceKm
     * @param noradId
     * @param apoapsisAu
     * @param launchDateUnix
     * @param speedMph
     * @param semiMajorAxisAu
     */
    public Roadster(String name, String launchDateUtc, Integer launchDateUnix, Integer launchMassKg, Integer launchMassLbs, Integer noradId, Float epochJd, String orbitType, Float apoapsisAu, Float periapsisAu, Float semiMajorAxisAu, Float eccentricity, Float inclination, Float longitude, Float periapsisArg, Float periodDays, Float speedKph, Float speedMph, Float earthDistanceKm, Float earthDistanceMi, Float marsDistanceKm, Float marsDistanceMi, String wikipedia, String details) {
        super();
        this.name = name;
        this.launchDateUtc = launchDateUtc;
        this.launchDateUnix = launchDateUnix;
        this.launchMassKg = launchMassKg;
        this.launchMassLbs = launchMassLbs;
        this.noradId = noradId;
        this.epochJd = epochJd;
        this.orbitType = orbitType;
        this.apoapsisAu = apoapsisAu;
        this.periapsisAu = periapsisAu;
        this.semiMajorAxisAu = semiMajorAxisAu;
        this.eccentricity = eccentricity;
        this.inclination = inclination;
        this.longitude = longitude;
        this.periapsisArg = periapsisArg;
        this.periodDays = periodDays;
        this.speedKph = speedKph;
        this.speedMph = speedMph;
        this.earthDistanceKm = earthDistanceKm;
        this.earthDistanceMi = earthDistanceMi;
        this.marsDistanceKm = marsDistanceKm;
        this.marsDistanceMi = marsDistanceMi;
        this.wikipedia = wikipedia;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public Integer getLaunchMassKg() {
        return launchMassKg;
    }

    public void setLaunchMassKg(Integer launchMassKg) {
        this.launchMassKg = launchMassKg;
    }

    public Integer getLaunchMassLbs() {
        return launchMassLbs;
    }

    public void setLaunchMassLbs(Integer launchMassLbs) {
        this.launchMassLbs = launchMassLbs;
    }

    public Integer getNoradId() {
        return noradId;
    }

    public void setNoradId(Integer noradId) {
        this.noradId = noradId;
    }

    public Float getEpochJd() {
        return epochJd;
    }

    public void setEpochJd(Float epochJd) {
        this.epochJd = epochJd;
    }

    public String getOrbitType() {
        return orbitType;
    }

    public void setOrbitType(String orbitType) {
        this.orbitType = orbitType;
    }

    public Float getApoapsisAu() {
        return apoapsisAu;
    }

    public void setApoapsisAu(Float apoapsisAu) {
        this.apoapsisAu = apoapsisAu;
    }

    public Float getPeriapsisAu() {
        return periapsisAu;
    }

    public void setPeriapsisAu(Float periapsisAu) {
        this.periapsisAu = periapsisAu;
    }

    public Float getSemiMajorAxisAu() {
        return semiMajorAxisAu;
    }

    public void setSemiMajorAxisAu(Float semiMajorAxisAu) {
        this.semiMajorAxisAu = semiMajorAxisAu;
    }

    public Float getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Float eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Float getInclination() {
        return inclination;
    }

    public void setInclination(Float inclination) {
        this.inclination = inclination;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getPeriapsisArg() {
        return periapsisArg;
    }

    public void setPeriapsisArg(Float periapsisArg) {
        this.periapsisArg = periapsisArg;
    }

    public Float getPeriodDays() {
        return periodDays;
    }

    public void setPeriodDays(Float periodDays) {
        this.periodDays = periodDays;
    }

    public Float getSpeedKph() {
        return speedKph;
    }

    public void setSpeedKph(Float speedKph) {
        this.speedKph = speedKph;
    }

    public Float getSpeedMph() {
        return speedMph;
    }

    public void setSpeedMph(Float speedMph) {
        this.speedMph = speedMph;
    }

    public Float getEarthDistanceKm() {
        return earthDistanceKm;
    }

    public void setEarthDistanceKm(Float earthDistanceKm) {
        this.earthDistanceKm = earthDistanceKm;
    }

    public Float getEarthDistanceMi() {
        return earthDistanceMi;
    }

    public void setEarthDistanceMi(Float earthDistanceMi) {
        this.earthDistanceMi = earthDistanceMi;
    }

    public Float getMarsDistanceKm() {
        return marsDistanceKm;
    }

    public void setMarsDistanceKm(Float marsDistanceKm) {
        this.marsDistanceKm = marsDistanceKm;
    }

    public Float getMarsDistanceMi() {
        return marsDistanceMi;
    }

    public void setMarsDistanceMi(Float marsDistanceMi) {
        this.marsDistanceMi = marsDistanceMi;
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

}
