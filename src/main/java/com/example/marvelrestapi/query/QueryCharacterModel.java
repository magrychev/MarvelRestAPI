package com.example.marvelrestapi.query;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Фильтр запроса персонажей")
public class QueryCharacterModel {

    @Schema(description = "Полное имя персонажа", example = "Человек паук")
    String names;

    @Schema(description = "Префикс имени персонажа", example = "Че")
    String nameStartsWith;

    @Schema(description = "Список идентификаторов комиксов с персонажем", example = "1, 4, 3")
    List<Integer> comics;

    public String getNames() {
        return names;
    }

    public String getNameStartsWith() {
        return nameStartsWith;
    }

    public List<Integer> getComics() {
        return comics;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public void setNameStartsWith(String nameStartsWith) {
        this.nameStartsWith = nameStartsWith;
    }

    public void setComics(List<Integer> comics) {
        this.comics = comics;
    }
}
