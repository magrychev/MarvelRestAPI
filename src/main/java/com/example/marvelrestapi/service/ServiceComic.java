package com.example.marvelrestapi.service;

import com.example.marvelrestapi.model.Comic;

import java.util.List;

public interface ServiceComic {
    List<Comic> readAll();
    Comic read(int idCComic);
    boolean add(Comic comic);
    boolean delete(int idCComic);
}
