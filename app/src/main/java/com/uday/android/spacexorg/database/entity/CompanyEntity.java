
package com.uday.android.spacexorg.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.uday.android.spacexorg.network.model.company.Company;

@Entity(tableName = "company_table")
public class CompanyEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "company_id")
    private int id;
    @ColumnInfo(name = "company_name")
    private String name;
    @ColumnInfo(name = "company_founder")
    private String founder;
    @ColumnInfo(name = "company_founded")
    private Integer founded;
    @ColumnInfo(name = "company_employees")
    private Integer employees;
    @ColumnInfo(name = "company_vehicles")
    private Integer vehicles;
    @ColumnInfo(name = "company_launch_sites")
    private Integer launchSites;
    @ColumnInfo(name = "company_test_sites")
    private Integer testSites;
    @ColumnInfo(name = "company_ceo")
    private String ceo;
    @ColumnInfo(name = "company_cto")
    private String cto;
    @ColumnInfo(name = "company_coo")
    private String coo;
    @ColumnInfo(name = "company_cto_propulsion")
    private String ctoPropulsion;
    @ColumnInfo(name = "company_valuation")
    private Long valuation;
    @ColumnInfo(name = "company_headquarters_address")
    private String headquartersAddress;
    @ColumnInfo(name = "company_website")
    private String website;
    @ColumnInfo(name = "company_summary")
    private String summary;

    @Ignore
    public CompanyEntity() {
    }

    public CompanyEntity(String name, String founder, Integer founded, Integer employees, Integer vehicles, Integer launchSites, Integer testSites, String ceo, String cto, String coo, String ctoPropulsion, Long valuation, String headquartersAddress, String website, String summary) {
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
        this.headquartersAddress = headquartersAddress;
        this.website = website;
        this.summary = summary;
    }

    public CompanyEntity(Company company) {
        super();
        this.name = company.getName();
        this.founder = company.getFounder();
        this.founded = company.getFounded();
        this.employees = company.getEmployees();
        this.vehicles = company.getVehicles();
        this.launchSites = company.getLaunchSites();
        this.testSites = company.getTestSites();
        this.ceo = company.getCeo();
        this.cto = company.getCto();
        this.coo = company.getCoo();
        this.ctoPropulsion = company.getCtoPropulsion();
        this.valuation = company.getValuation();
        this.headquartersAddress = company.getHeadquarters().getAddress() + ", "
                + company.getHeadquarters().getCity() + ", "
                + company.getHeadquarters().getState();
        this.website = company.getLinks().getWebsite();
        this.summary = company.getSummary();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHeadquartersAddress() {
        return headquartersAddress;
    }

    public void setHeadquartersAddress(String headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
