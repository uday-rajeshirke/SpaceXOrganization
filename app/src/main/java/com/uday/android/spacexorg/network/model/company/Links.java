
package com.uday.android.spacexorg.network.model.company;

import com.squareup.moshi.Json;

public class Links {

    @Json(name = "website")
    private String website;
    @Json(name = "flickr")
    private String flickr;
    @Json(name = "twitter")
    private String twitter;
    @Json(name = "elon_twitter")
    private String elonTwitter;

    public Links() {
    }

    public Links(String website, String flickr, String twitter, String elonTwitter) {
        super();
        this.website = website;
        this.flickr = flickr;
        this.twitter = twitter;
        this.elonTwitter = elonTwitter;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getFlickr() {
        return flickr;
    }

    public void setFlickr(String flickr) {
        this.flickr = flickr;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getElonTwitter() {
        return elonTwitter;
    }

    public void setElonTwitter(String elonTwitter) {
        this.elonTwitter = elonTwitter;
    }

}
