package com.example.marvelrestapi.model;

import java.util.List;

public class Comic {
    private int idComic;
    private String titleComic;
    private List<Character> characters;

    public int getIdComic() {
        return idComic;
    }

    public String getTitleComic() {
        return titleComic;
    }

    public List<Character> getCharacters() {
        return characters;
    }

    public void setIdComic(int idComic) {
        this.idComic = idComic;
    }

    public void setTitleComic(String titleComic) {
        this.titleComic = titleComic;
    }

    public void setCharacter(List<Character> characters) {
        this.characters = characters;
    }
}
