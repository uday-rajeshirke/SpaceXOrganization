
package com.uday.android.spacexorg.network.model.history;

import com.squareup.moshi.Json;

public class History {

    @Json(name = "id")
    private Integer id;
    @Json(name = "title")
    private String title;
    @Json(name = "event_date_utc")
    private String eventDateUtc;
    @Json(name = "event_date_unix")
    private Integer eventDateUnix;
    @Json(name = "flight_number")
    private Integer flightNumber;
    @Json(name = "details")
    private String details;
    @Json(name = "links")
    private Links links;

    public History() {
    }

    public History(Integer id, String title, String eventDateUtc, Integer eventDateUnix, Integer flightNumber, String details, Links links) {
        super();
        this.id = id;
        this.title = title;
        this.eventDateUtc = eventDateUtc;
        this.eventDateUnix = eventDateUnix;
        this.flightNumber = flightNumber;
        this.details = details;
        this.links = links;
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

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

}
