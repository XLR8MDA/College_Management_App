package com.example.teachersapp.notice;

public class LinksData {

    String key;

    public LinksData() {
    }

    String title;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    String url;

    public LinksData(String title, String url, String time, String date, String key) {
        this.title = title;
        this.url = url;
        this.time = time;
        this.date = date;
        this.key = key;
    }

    String time;
    String date;


}