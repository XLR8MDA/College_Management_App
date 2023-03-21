package com.example.teachersapp.notice;

public class EbookData {
    private String PdfTitle;
    private String key;
    public EbookData(String pdfTitle, String pdfUrl, String time, String date) {
        PdfTitle = pdfTitle;
        PdfUrl = pdfUrl;
        this.time = time;
        this.date = date;
        this.key = key;
    }

    private String PdfUrl;
    private String time;
    private String date;



    public String getPdfTitle() {
        return PdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        PdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return PdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        PdfUrl = pdfUrl;
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
    public EbookData() {
    }

}