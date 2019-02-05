package com.uday.android.spacexorg.ui.utils;

public class AboutAppDetails {

    private int icon;
    private String author;
    private String provider;

    public AboutAppDetails(int icon, String author, String provider) {
        this.icon = icon;
        this.author = author;
        this.provider = provider;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
