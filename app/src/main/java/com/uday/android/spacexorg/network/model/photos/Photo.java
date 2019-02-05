
package com.uday.android.spacexorg.network.model.photos;

import com.squareup.moshi.Json;

public class Photo {

    @Json(name = "id")
    private String id;
    @Json(name = "owner")
    private String owner;
    @Json(name = "secret")
    private String secret;
    @Json(name = "server")
    private String server;
    @Json(name = "farm")
    private Long farm;
    @Json(name = "title")
    private String title;
    @Json(name = "ispublic")
    private Long ispublic;
    @Json(name = "isfriend")
    private Long isfriend;
    @Json(name = "isfamily")
    private Long isfamily;

    public Photo() {
    }

    public Photo(String id, String owner, String secret, String server, Long farm, String title, Long ispublic, Long isfriend, Long isfamily) {
        super();
        this.id = id;
        this.owner = owner;
        this.secret = secret;
        this.server = server;
        this.farm = farm;
        this.title = title;
        this.ispublic = ispublic;
        this.isfriend = isfriend;
        this.isfamily = isfamily;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Long getFarm() {
        return farm;
    }

    public void setFarm(Long farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getIspublic() {
        return ispublic;
    }

    public void setIspublic(Long ispublic) {
        this.ispublic = ispublic;
    }

    public Long getIsfriend() {
        return isfriend;
    }

    public void setIsfriend(Long isfriend) {
        this.isfriend = isfriend;
    }

    public Long getIsfamily() {
        return isfamily;
    }

    public void setIsfamily(Long isfamily) {
        this.isfamily = isfamily;
    }

    public String getPhotoURL(){
        // http://farm{farm-id}.staticflickr.com/{server-id}/{id}_{secret}.jpg
        return "http://farm" + farm + ".staticflickr.com/" + server +
                "/" + id + "_" + secret + ".jpg";
    }


}
