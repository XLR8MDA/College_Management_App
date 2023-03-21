package com.example.jntuhces.ui.notices;

public class LinksData {

    public LinksData() {
    }

    String date;



    public LinksData(String date, String time, String title, String url) {
        this.date = date;
        this.time = time;
        this.title = title;
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String time;
    String title;
    String url;
}