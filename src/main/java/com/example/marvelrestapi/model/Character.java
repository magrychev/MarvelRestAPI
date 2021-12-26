package com.example.marvelrestapi.model;

import java.awt.*;
import java.util.List;

public class Character {

    private int idCharacter;

    private String nameCharacter;

    private Image thumbnailCharacter;

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
