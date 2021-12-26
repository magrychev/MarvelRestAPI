package com.example.marvelrestapi.query;

public class QueryComicModel {

    String title;

    String titleStartsWith;

    public String getTitle() {
        return title;
    }

    public String getTitleStartsWith() {
        return titleStartsWith;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitleStartsWith(String titleStartsWith) {
        this.titleStartsWith = titleStartsWith;
    }
}
