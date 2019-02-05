
package com.uday.android.spacexorg.network.model.ship;

import java.util.List;
import com.squareup.moshi.Json;

public class Ship {

    @Json(name = "ship_id")
    private String shipId;
    @Json(name = "ship_name")
    private String shipName;
    @Json(name = "ship_model")
    private String shipModel;
    @Json(name = "ship_type")
    private String shipType;
    @Json(name = "roles")
    private List<String> roles = null;
    @Json(name = "active")
    private Boolean active;
    @Json(name = "imo")
    private Integer imo;
    @Json(name = "mmsi")
    private Integer mmsi;
    @Json(name = "abs")
    private Integer abs;
    @Json(name = "class")
    private Integer _class;
    @Json(name = "weight_lbs")
    private Integer weightLbs;
    @Json(name = "weight_kg")
    private Integer weightKg;
    @Json(name = "year_built")
    private Integer yearBuilt;
    @Json(name = "home_port")
    private String homePort;
    @Json(name = "status")
    private String status;
    @Json(name = "speed_kn")
    private Float speedKn;
    @Json(name = "course_deg")
    private Integer courseDeg;
    @Json(name = "position")
    private Position position;
    @Json(name = "successful_landings")
    private Integer successfulLandings;
    @Json(name = "attempted_landings")
    private Integer attemptedLandings;
    @Json(name = "missions")
    private List<Mission> missions = null;
    @Json(name = "url")
    private String url;
    @Json(name = "image")
    private String image;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ship() {
    }

    /**
     * 
     * @param position
     * @param shipId
     * @param imo
     * @param status
     * @param weightKg
     * @param missions
     * @param successfulLandings
     * @param yearBuilt
     * @param image
     * @param shipName
     * @param mmsi
     * @param courseDeg
     * @param url
     * @param homePort
     * @param shipType
     * @param abs
     * @param _class
     * @param attemptedLandings
     * @param roles
     * @param shipModel
     * @param active
     * @param weightLbs
     * @param speedKn
     */
    public Ship(String shipId, String shipName, String shipModel, String shipType, List<String> roles, Boolean active, Integer imo, Integer mmsi, Integer abs, Integer _class, Integer weightLbs, Integer weightKg, Integer yearBuilt, String homePort, String status, Float speedKn, Integer courseDeg, Position position, Integer successfulLandings, Integer attemptedLandings, List<Mission> missions, String url, String image) {
        super();
        this.shipId = shipId;
        this.shipName = shipName;
        this.shipModel = shipModel;
        this.shipType = shipType;
        this.roles = roles;
        this.active = active;
        this.imo = imo;
        this.mmsi = mmsi;
        this.abs = abs;
        this._class = _class;
        this.weightLbs = weightLbs;
        this.weightKg = weightKg;
        this.yearBuilt = yearBuilt;
        this.homePort = homePort;
        this.status = status;
        this.speedKn = speedKn;
        this.courseDeg = courseDeg;
        this.position = position;
        this.successfulLandings = successfulLandings;
        this.attemptedLandings = attemptedLandings;
        this.missions = missions;
        this.url = url;
        this.image = image;
    }

    public String getShipId() {
        return shipId;
    }

    public void setShipId(String shipId) {
        this.shipId = shipId;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipModel() {
        return shipModel;
    }

    public void setShipModel(String shipModel) {
        this.shipModel = shipModel;
    }

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getImo() {
        return imo;
    }

    public void setImo(Integer imo) {
        this.imo = imo;
    }

    public Integer getMmsi() {
        return mmsi;
    }

    public void setMmsi(Integer mmsi) {
        this.mmsi = mmsi;
    }

    public Integer getAbs() {
        return abs;
    }

    public void setAbs(Integer abs) {
        this.abs = abs;
    }

    public Integer getClass_() {
        return _class;
    }

    public void setClass_(Integer _class) {
        this._class = _class;
    }

    public Integer getWeightLbs() {
        return weightLbs;
    }

    public void setWeightLbs(Integer weightLbs) {
        this.weightLbs = weightLbs;
    }

    public Integer getWeightKg() {
        return weightKg;
    }

    public void setWeightKg(Integer weightKg) {
        this.weightKg = weightKg;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public String getHomePort() {
        return homePort;
    }

    public void setHomePort(String homePort) {
        this.homePort = homePort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getSpeedKn() {
        return speedKn;
    }

    public void setSpeedKn(Float speedKn) {
        this.speedKn = speedKn;
    }

    public Integer getCourseDeg() {
        return courseDeg;
    }

    public void setCourseDeg(Integer courseDeg) {
        this.courseDeg = courseDeg;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getSuccessfulLandings() {
        return successfulLandings;
    }

    public void setSuccessfulLandings(Integer successfulLandings) {
        this.successfulLandings = successfulLandings;
    }

    public Integer getAttemptedLandings() {
        return attemptedLandings;
    }

    public void setAttemptedLandings(Integer attemptedLandings) {
        this.attemptedLandings = attemptedLandings;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
