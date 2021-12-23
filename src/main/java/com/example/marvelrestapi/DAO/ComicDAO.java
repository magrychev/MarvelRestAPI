package com.example.marvelrestapi.DAO;

import com.example.marvelrestapi.model.Comic;

import java.util.List;

public interface ComicDAO {
    List<Comic> readAll();
    Comic read(int idCComic);
    boolean add(Comic comic);
    boolean delete(int idCComic);
}
