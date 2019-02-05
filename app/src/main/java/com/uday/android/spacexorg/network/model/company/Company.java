
package com.uday.android.spacexorg.network.model.company;

import com.squareup.moshi.Json;

public class Company {

    @Json(name = "name")
    private String name;
    @Json(name = "founder")
    private String founder;
    @Json(name = "founded")
    private Integer founded;
    @Json(name = "employees")
    private Integer employees;
    @Json(name = "vehicles")
    private Integer vehicles;
    @Json(name = "launch_sites")
    private Integer launchSites;
    @Json(name = "test_sites")
    private Integer testSites;
    @Json(name = "ceo")
    private String ceo;
    @Json(name = "cto")
    private String cto;
    @Json(name = "coo")
    private String coo;
    @Json(name = "cto_propulsion")
    private String ctoPropulsion;
    @Json(name = "valuation")
    private Long valuation;
    @Json(name = "headquarters")
    private Headquarters headquarters;
    @Json(name = "links")
    private Links links;
    @Json(name = "summary")
    private String summary;

    public Company() {
    }

    public Company(String name, String founder, Integer founded, Integer employees, Integer vehicles, Integer launchSites, Integer testSites, String ceo, String cto, String coo, String ctoPropulsion, Long valuation, Headquarters headquarters, Links links, String summary) {
        super();
        this.name = name;
        this.founder = founder;
        this.founded = founded;
        this.employees = employees;
        this.vehicles = vehicles;
        this.launchSites = launchSites;
        this.testSites = testSites;
        this.ceo = ceo;
        this.cto = cto;
        this.coo = coo;
        this.ctoPropulsion = ctoPropulsion;
        this.valuation = valuation;
        this.headquarters = headquarters;
        this.links = links;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public Integer getFounded() {
        return founded;
    }

    public void setFounded(Integer founded) {
        this.founded = founded;
    }

    public Integer getEmployees() {
        return employees;
    }

    public void setEmployees(Integer employees) {
        this.employees = employees;
    }

    public Integer getVehicles() {
        return vehicles;
    }

    public void setVehicles(Integer vehicles) {
        this.vehicles = vehicles;
    }

    public Integer getLaunchSites() {
        return launchSites;
    }

    public void setLaunchSites(Integer launchSites) {
        this.launchSites = launchSites;
    }

    public Integer getTestSites() {
        return testSites;
    }

    public void setTestSites(Integer testSites) {
        this.testSites = testSites;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getCto() {
        return cto;
    }

    public void setCto(String cto) {
        this.cto = cto;
    }

    public String getCoo() {
        return coo;
    }

    public void setCoo(String coo) {
        this.coo = coo;
    }

    public String getCtoPropulsion() {
        return ctoPropulsion;
    }

    public void setCtoPropulsion(String ctoPropulsion) {
        this.ctoPropulsion = ctoPropulsion;
    }

    public Long getValuation() {
        return valuation;
    }

    public void setValuation(Long valuation) {
        this.valuation = valuation;
    }

    public Headquarters getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(Headquarters headquarters) {
        this.headquarters = headquarters;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
