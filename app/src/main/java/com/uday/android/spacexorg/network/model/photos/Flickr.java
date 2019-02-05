
package com.uday.android.spacexorg.network.model.photos;

import com.squareup.moshi.Json;

public class Flickr {

    @Json(name = "photos")
    private Photos photos;
    @Json(name = "stat")
    private String stat;


    public Flickr() {
    }


    public Flickr(Photos photos, String stat) {
        super();
        this.photos = photos;
        this.stat = stat;
    }

    public Photos getPhotos() {
        return photos;
    }

    public void setPhotos(Photos photos) {
        this.photos = photos;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
