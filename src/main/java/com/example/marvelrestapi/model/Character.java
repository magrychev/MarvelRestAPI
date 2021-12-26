package com.example.marvelrestapi.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.awt.*;
import java.util.List;

@Schema(description = "Сущность персонажа")
public class Character {

    @Schema(description = "Идентификатор", example = "1")
    private int idCharacter;

    @Schema(description = "Имя персонажа", example = "Человек паук")
    private String nameCharacter;

    @Schema(description = "Изображение")
    private Image thumbnailCharacter;

    @Schema(description = "Список идентификаторов комиксов")
    private List<Integer> comics;

    public int getIdCharacter() {
        return idCharacter;
    }

    public String getNameCharacter() {
        return nameCharacter;
    }

    public Image getThumbnailCharacter() {
        return thumbnailCharacter;
    }

    public List<Integer> getComics() {
        return comics;
    }

    public void setIdCharacter(int idCharacter) {
        this.idCharacter = idCharacter;
    }

    public void setNameCharacter(String nameCharacter) {
        this.nameCharacter = nameCharacter;
    }

    public void setThumbnailCharacter(Image thumbnailCharacter) {
        this.thumbnailCharacter = thumbnailCharacter;
    }

    public void setComics(List<Integer> comics) {
        this.comics = comics;
    }
}
