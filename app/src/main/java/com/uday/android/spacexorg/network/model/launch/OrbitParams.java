
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

public class OrbitParams {

    @Json(name = "reference_system")
    private String referenceSystem;
    @Json(name = "regime")
    private String regime;
    @Json(name = "longitude")
    private Float longitude;
    @Json(name = "semi_major_axis_km")
    private Float semiMajorAxisKm;
    @Json(name = "eccentricity")
    private Float eccentricity;
    @Json(name = "periapsis_km")
    private Float periapsisKm;
    @Json(name = "apoapsis_km")
    private Float apoapsisKm;
    @Json(name = "inclination_deg")
    private Float inclinationDeg;
    @Json(name = "period_min")
    private Float periodMin;
    @Json(name = "lifespan_years")
    private Float lifespanYears;
    @Json(name = "epoch")
    private String epoch;
    @Json(name = "mean_motion")
    private Float meanMotion;
    @Json(name = "raan")
    private Float raan;
    @Json(name = "arg_of_pericenter")
    private Float argOfPericenter;
    @Json(name = "mean_anomaly")
    private Float meanAnomaly;

    public OrbitParams() {
    }

    public OrbitParams(String referenceSystem, String regime, Float longitude, Float semiMajorAxisKm,
                       Float eccentricity, Float periapsisKm, Float apoapsisKm, Float inclinationDeg,
                       Float periodMin, Float lifespanYears, String epoch, Float meanMotion, Float raan,
                       Float argOfPericenter, Float meanAnomaly) {
        super();
        this.referenceSystem = referenceSystem;
        this.regime = regime;
        this.longitude = longitude;
        this.semiMajorAxisKm = semiMajorAxisKm;
        this.eccentricity = eccentricity;
        this.periapsisKm = periapsisKm;
        this.apoapsisKm = apoapsisKm;
        this.inclinationDeg = inclinationDeg;
        this.periodMin = periodMin;
        this.lifespanYears = lifespanYears;
        this.epoch = epoch;
        this.meanMotion = meanMotion;
        this.raan = raan;
        this.argOfPericenter = argOfPericenter;
        this.meanAnomaly = meanAnomaly;
    }

    public String getReferenceSystem() {
        return referenceSystem;
    }

    public void setReferenceSystem(String referenceSystem) {
        this.referenceSystem = referenceSystem;
    }

    public String getRegime() {
        return regime;
    }

    public void setRegime(String regime) {
        this.regime = regime;
    }

    public Object getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getSemiMajorAxisKm() {
        return semiMajorAxisKm;
    }

    public void setSemiMajorAxisKm(Float semiMajorAxisKm) {
        this.semiMajorAxisKm = semiMajorAxisKm;
    }

    public Float getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(Float eccentricity) {
        this.eccentricity = eccentricity;
    }

    public Float getPeriapsisKm() {
        return periapsisKm;
    }

    public void setPeriapsisKm(Float periapsisKm) {
        this.periapsisKm = periapsisKm;
    }

    public Float getApoapsisKm() {
        return apoapsisKm;
    }

    public void setApoapsisKm(Float apoapsisKm) {
        this.apoapsisKm = apoapsisKm;
    }

    public Float getInclinationDeg() {
        return inclinationDeg;
    }

    public void setInclinationDeg(Float inclinationDeg) {
        this.inclinationDeg = inclinationDeg;
    }

    public Float getPeriodMin() {
        return periodMin;
    }

    public void setPeriodMin(Float periodMin) {
        this.periodMin = periodMin;
    }

    public Float getLifespanYears() {
        return lifespanYears;
    }

    public void setLifespanYears(Float lifespanYears) {
        this.lifespanYears = lifespanYears;
    }

    public String getEpoch() {
        return epoch;
    }

    public void setEpoch(String epoch) {
        this.epoch = epoch;
    }

    public Float getMeanMotion() {
        return meanMotion;
    }

    public void setMeanMotion(Float meanMotion) {
        this.meanMotion = meanMotion;
    }

    public Float getRaan() {
        return raan;
    }

    public void setRaan(Float raan) {
        this.raan = raan;
    }

    public Float getArgOfPericenter() {
        return argOfPericenter;
    }

    public void setArgOfPericenter(Float argOfPericenter) {
        this.argOfPericenter = argOfPericenter;
    }

    public Float getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(Float meanAnomaly) {
        this.meanAnomaly = meanAnomaly;
    }

}
