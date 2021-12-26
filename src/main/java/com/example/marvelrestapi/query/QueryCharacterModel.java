package com.example.marvelrestapi.query;

import java.util.List;

public class QueryCharacterModel {
    String names;
    String nameStartsWith;
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
