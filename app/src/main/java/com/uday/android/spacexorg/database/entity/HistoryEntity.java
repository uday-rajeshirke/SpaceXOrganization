
package com.uday.android.spacexorg.database.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.Nullable;

import com.uday.android.spacexorg.network.model.history.History;

@Entity(tableName = "history_table")
public class HistoryEntity {

    @PrimaryKey
    @ColumnInfo(name = "history_id")
    private Integer id;
    @ColumnInfo(name = "history_title")
    private String title;
    @ColumnInfo(name = "history_event_date_utc")
    private String eventDateUtc;
    @ColumnInfo(name = "history_event_date_unix")
    private Integer eventDateUnix;
    @ColumnInfo(name = "history_details")
    private String details;
    @Nullable
    @ColumnInfo(name = "history_article")
    private String article;
    @Nullable
    @ColumnInfo(name = "history_wikipedia")
    private String wikipedia;

    @Ignore
    public HistoryEntity() {
    }


    public HistoryEntity(Integer id, String title, String eventDateUtc, Integer eventDateUnix,
                         String details, String article, String wikipedia) {
        super();
        this.id = id;
        this.title = title;
        this.eventDateUtc = eventDateUtc;
        this.eventDateUnix = eventDateUnix;
        this.details = details;
        this.article = article;
        this.wikipedia = wikipedia;
    }

    public HistoryEntity(History history) {
        this.id = history.getId();
        this.title = history.getTitle();
        this.eventDateUtc = history.getEventDateUtc();
        this.eventDateUnix = history.getEventDateUnix();
        this.details = history.getDetails();
        this.article = history.getLinks().getArticle();
        this.wikipedia = history.getLinks().getWikipedia();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDateUtc() {
        return eventDateUtc;
    }

    public void setEventDateUtc(String eventDateUtc) {
        this.eventDateUtc = eventDateUtc;
    }

    public Integer getEventDateUnix() {
        return eventDateUnix;
    }

    public void setEventDateUnix(Integer eventDateUnix) {
        this.eventDateUnix = eventDateUnix;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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