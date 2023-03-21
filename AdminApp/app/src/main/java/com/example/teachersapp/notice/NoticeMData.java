package com.example.teachersapp.notice;

public class NoticeMData {
    String title;
    String date;
    String time;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    String key;

    public NoticeMData(String title, String date, String time, String key, String imageUrl, String linkUrl, String pdfUrl) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.key = key;
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
        this.pdfUrl = pdfUrl;
    }

    String imageUrl;
    String linkUrl;
    String pdfUrl;


    public NoticeMData() {
    }


}