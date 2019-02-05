
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

public class LaunchSite {

    @Json(name = "site_id")
    private String siteId;
    @Json(name = "site_name")
    private String siteName;
    @Json(name = "site_name_long")
    private String siteNameLong;

    public LaunchSite() {
    }

    public LaunchSite(String siteId, String siteName, String siteNameLong) {
        super();
        this.siteId = siteId;
        this.siteName = siteName;
        this.siteNameLong = siteNameLong;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }

}
