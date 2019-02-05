
package com.uday.android.spacexorg.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.uday.android.spacexorg.network.model.capsule.Capsule;
import com.uday.android.spacexorg.network.model.capsule.Thruster;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.lang.reflect.Type;
import java.util.List;

@Entity(tableName = "capsule_table")
public class CapsuleEntity {

    @PrimaryKey
    @ColumnInfo(name = "capsule_id")
    @NonNull
    private String id;
    @ColumnInfo(name = "capsule_name")
    @Nullable
    private String name;
    @ColumnInfo(name = "capsule_type")
    @Nullable
    private String type;
    @ColumnInfo(name = "capsule_active")
    @Nullable
    private Boolean active;
    @ColumnInfo(name = "capsule_crew_capacity")
    @Nullable
    private Integer crewCapacity;
    @ColumnInfo(name = "capsule_dry_mass")
    @Nullable
    private Integer dryMassKg;
    @ColumnInfo(name = "capsule_first_flight")
    @Nullable
    private String firstFlight;
    @ColumnInfo(name = "capsule_launch_payload")
    @Nullable
    private Integer launchPayloadMass;
    @ColumnInfo(name = "capsule_return_payload")
    @Nullable
    private Integer returnPayloadMass;
    @ColumnInfo(name = "capsule_diameter")
    @Nullable
    private Float diameter;
    @ColumnInfo(name = "capsule_thrusters")
    @Nullable
    private String thrusters;
    @ColumnInfo(name = "capsule_description")
    @Nullable
    private String description;

    @Ignore
    public CapsuleEntity() {
    }

    public CapsuleEntity(String id, String name, String type, Boolean active, Integer crewCapacity, Integer dryMassKg, String firstFlight, Integer launchPayloadMass, Integer returnPayloadMass, Float diameter, String thrusters, String description) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.active = active;
        this.crewCapacity = crewCapacity;
        this.dryMassKg = dryMassKg;
        this.firstFlight = firstFlight;
        this.launchPayloadMass = launchPayloadMass;
        this.returnPayloadMass = returnPayloadMass;
        this.diameter = diameter;
        this.thrusters = thrusters;
        this.description = description;
    }

    public CapsuleEntity(Capsule capsule) {
        super();
        this.id = capsule.getId();
        this.name = capsule.getName();
        this.type = capsule.getType();
        this.active = capsule.getActive();
        this.crewCapacity = capsule.getCrewCapacity();
        this.dryMassKg = capsule.getDryMassKg();
        this.firstFlight = capsule.getFirstFlight();
        this.launchPayloadMass = capsule.getLaunchPayloadMass().getKg();
        this.returnPayloadMass = capsule.getReturnPayloadMass().getKg();
        this.diameter = capsule.getDiameter().getMeters();
        Moshi moshi = new Moshi.Builder().build();
        Type type = Types.newParameterizedType(List.class, Thruster.class);
        JsonAdapter<List<Thruster>> jsonAdapter = moshi.adapter(type);
        this.thrusters = jsonAdapter.toJson(capsule.getThrusters());
        this.description = capsule.getDescription();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getCrewCapacity() {
        return crewCapacity;
    }

    public void setCrewCapacity(Integer crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    public Integer getDryMassKg() {
        return dryMassKg;
    }

    public void setDryMassKg(Integer dryMassKg) {
        this.dryMassKg = dryMassKg;
    }

    @Nullable
    public String getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(@Nullable String firstFlight) {
        this.firstFlight = firstFlight;
    }

    public Integer getLaunchPayloadMass() {
        return launchPayloadMass;
    }

    public void setLaunchPayloadMass(Integer launchPayloadMass) {
        this.launchPayloadMass = launchPayloadMass;
    }

    public Integer getReturnPayloadMass() {
        return returnPayloadMass;
    }

    public void setReturnPayloadMass(Integer returnPayloadMass) {
        this.returnPayloadMass = returnPayloadMass;
    }

    public Float getDiameter() {
        return diameter;
    }

    public void setDiameter(Float diameter) {
        this.diameter = diameter;
    }

    public String getThrusters() {
        return thrusters;
    }

    public void setThrusters(String thrusters) {
        this.thrusters = thrusters;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
}
