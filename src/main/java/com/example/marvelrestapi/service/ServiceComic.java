package com.example.marvelrestapi.service;

import com.example.marvelrestapi.model.Comic;
import com.example.marvelrestapi.query.QueryComicModel;

import java.util.List;

public interface ServiceComic {
    List<Comic> readAll(QueryComicModel queryComicModel);
    Comic read(int idCComic);
    boolean add(Comic comic);
    boolean delete(int idCComic);
}
