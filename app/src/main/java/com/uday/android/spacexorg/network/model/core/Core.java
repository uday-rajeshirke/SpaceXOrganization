
package com.uday.android.spacexorg.network.model.core;

import java.util.List;
import com.squareup.moshi.Json;

public class Core {

    @Json(name = "core_serial")
    private String coreSerial;
    @Json(name = "block")
    private Integer block;
    @Json(name = "status")
    private String status;
    @Json(name = "original_launch")
    private String originalLaunch;
    @Json(name = "original_launch_unix")
    private Integer originalLaunchUnix;
    @Json(name = "missions")
    private List<Mission> missions = null;
    @Json(name = "reuse_count")
    private Integer reuseCount;
    @Json(name = "rtls_attempts")
    private Integer rtlsAttempts;
    @Json(name = "rtls_landings")
    private Integer rtlsLandings;
    @Json(name = "asds_attempts")
    private Integer asdsAttempts;
    @Json(name = "asds_landings")
    private Integer asdsLandings;
    @Json(name = "water_landing")
    private Boolean waterLanding;
    @Json(name = "details")
    private String details;

    public Core() {
    }

    public Core(String coreSerial, Integer block, String status, String originalLaunch, Integer originalLaunchUnix, List<Mission> missions, Integer reuseCount, Integer rtlsAttempts, Integer rtlsLandings, Integer asdsAttempts, Integer asdsLandings, Boolean waterLanding, String details) {
        super();
        this.coreSerial = coreSerial;
        this.block = block;
        this.status = status;
        this.originalLaunch = originalLaunch;
        this.originalLaunchUnix = originalLaunchUnix;
        this.missions = missions;
        this.reuseCount = reuseCount;
        this.rtlsAttempts = rtlsAttempts;
        this.rtlsLandings = rtlsLandings;
        this.asdsAttempts = asdsAttempts;
        this.asdsLandings = asdsLandings;
        this.waterLanding = waterLanding;
        this.details = details;
    }

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOriginalLaunch() {
        return originalLaunch;
    }

    public void setOriginalLaunch(String originalLaunch) {
        this.originalLaunch = originalLaunch;
    }

    public Integer getOriginalLaunchUnix() {
        return originalLaunchUnix;
    }

    public void setOriginalLaunchUnix(Integer originalLaunchUnix) {
        this.originalLaunchUnix = originalLaunchUnix;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public Integer getReuseCount() {
        return reuseCount;
    }

    public void setReuseCount(Integer reuseCount) {
        this.reuseCount = reuseCount;
    }

    public Integer getRtlsAttempts() {
        return rtlsAttempts;
    }

    public void setRtlsAttempts(Integer rtlsAttempts) {
        this.rtlsAttempts = rtlsAttempts;
    }

    public Integer getRtlsLandings() {
        return rtlsLandings;
    }

    public void setRtlsLandings(Integer rtlsLandings) {
        this.rtlsLandings = rtlsLandings;
    }

    public Integer getAsdsAttempts() {
        return asdsAttempts;
    }

    public void setAsdsAttempts(Integer asdsAttempts) {
        this.asdsAttempts = asdsAttempts;
    }

    public Integer getAsdsLandings() {
        return asdsLandings;
    }

    public void setAsdsLandings(Integer asdsLandings) {
        this.asdsLandings = asdsLandings;
    }

    public Boolean getWaterLanding() {
        return waterLanding;
    }

    public void setWaterLanding(Boolean waterLanding) {
        this.waterLanding = waterLanding;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
