package com.example.marvelrestapi.query;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Фильтр запроса комиксов")
public class QueryComicModel {

    @Schema(description = "Полное название комикса", example = "Marvel")
    String title;

    @Schema(description = "Префикс названия комикса", example = "Ma")
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
