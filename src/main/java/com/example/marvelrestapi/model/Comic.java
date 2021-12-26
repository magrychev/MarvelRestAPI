package com.example.marvelrestapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(description = "Сущность комикса")
public class Comic {

    @Schema(description = "Идентификатор", example = "1")
    private int idComic;

    @Schema(description = "Название комикса", example = "Marvel")
    private String titleComic;

    @Schema(description = "Cписок идентификаторов персонажей")
    private List<Integer> characters;

    public int getIdComic() {
        return idComic;
    }

    public String getTitleComic() {
        return titleComic;
    }

    public List<Integer> getCharacters() {
        return characters;
    }

    public void setIdComic(int idComic) {
        this.idComic = idComic;
    }

    public void setTitleComic(String titleComic) {
        this.titleComic = titleComic;
    }

    public void setCharacter(List<Integer> characters) {
        this.characters = characters;
    }
}
