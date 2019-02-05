
package com.uday.android.spacexorg.network.model.history;

import com.squareup.moshi.Json;

public class Links {

    @Json(name = "reddit")
    private String reddit;
    @Json(name = "article")
    private String article;
    @Json(name = "wikipedia")
    private String wikipedia;


    public Links() {
    }


    public Links(String reddit, String article, String wikipedia) {
        super();
        this.reddit = reddit;
        this.article = article;
        this.wikipedia = wikipedia;
    }

    public String getReddit() {
        return reddit;
    }

    public void setReddit(String reddit) {
        this.reddit = reddit;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

}
