
package com.uday.android.spacexorg.network.model.launch;

import com.squareup.moshi.Json;

public class Links {

    @Json(name = "mission_patch")
    private String missionPatch;
    @Json(name = "mission_patch_small")
    private String missionPatchSmall;
    @Json(name = "reddit_campaign")
    private String redditCampaign;
    @Json(name = "reddit_launch")
    private String redditLaunch;
    @Json(name = "reddit_recovery")
    private Object redditRecovery;
    @Json(name = "reddit_media")
    private String redditMedia;
    @Json(name = "presskit")
    private String presskit;
    @Json(name = "article_link")
    private String articleLink;
    @Json(name = "wikipedia")
    private String wikipedia;
    @Json(name = "video_link")
    private String videoLink;

    public Links() {
    }

    public Links(String missionPatch, String missionPatchSmall, String redditCampaign, String redditLaunch, Object redditRecovery, String redditMedia, String presskit, String articleLink, String wikipedia, String videoLink) {
        super();
        this.missionPatch = missionPatch;
        this.missionPatchSmall = missionPatchSmall;
        this.redditCampaign = redditCampaign;
        this.redditLaunch = redditLaunch;
        this.redditRecovery = redditRecovery;
        this.redditMedia = redditMedia;
        this.presskit = presskit;
        this.articleLink = articleLink;
        this.wikipedia = wikipedia;
        this.videoLink = videoLink;
    }

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getRedditCampaign() {
        return redditCampaign;
    }

    public void setRedditCampaign(String redditCampaign) {
        this.redditCampaign = redditCampaign;
    }

    public String getRedditLaunch() {
        return redditLaunch;
    }

    public void setRedditLaunch(String redditLaunch) {
        this.redditLaunch = redditLaunch;
    }

    public Object getRedditRecovery() {
        return redditRecovery;
    }

    public void setRedditRecovery(Object redditRecovery) {
        this.redditRecovery = redditRecovery;
    }

    public String getRedditMedia() {
        return redditMedia;
    }

    public void setRedditMedia(String redditMedia) {
        this.redditMedia = redditMedia;
    }

    public String getPresskit() {
        return presskit;
    }

    public void setPresskit(String presskit) {
        this.presskit = presskit;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

}
