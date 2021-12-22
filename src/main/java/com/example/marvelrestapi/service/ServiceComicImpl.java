package com.example.marvelrestapi.service;

import com.example.marvelrestapi.model.Comic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ServiceComicImpl implements ServiceComic{
    private static final Map<Integer, Comic> COMIC_REPOSITORY_MAP = new HashMap<>();

    @Override
    public List<Comic> readAll() {
        return new ArrayList<>(COMIC_REPOSITORY_MAP.values());
    }

    @Override
    public Comic read(int idComic) {
        return COMIC_REPOSITORY_MAP.get(idComic);
    }

    @Override
    public boolean add(Comic comic) {
        if(!COMIC_REPOSITORY_MAP.containsKey(comic.getIdComic())) {
            COMIC_REPOSITORY_MAP.put(comic.getIdComic(), comic);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int idComic) {
        return COMIC_REPOSITORY_MAP.remove(idComic)!=null;
    }
}
