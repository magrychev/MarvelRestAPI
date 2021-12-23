package com.example.marvelrestapi.DAO;

import com.example.marvelrestapi.model.Comic;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ComicDAOImpl implements ComicDAO{

    private static final Map<Integer, Comic> COMIC_MAP = new HashMap<>();

    @Override
    public List<Comic> readAll() {
        return new ArrayList<>(COMIC_MAP.values());
    }

    @Override
    public Comic read(int idComic) {
        return COMIC_MAP.get(idComic);
    }

    @Override
    public boolean add(Comic comic) {
        if(!COMIC_MAP.containsKey(comic.getIdComic())) {
            COMIC_MAP.put(comic.getIdComic(), comic);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int idComic) {
        return COMIC_MAP.remove(idComic)!=null;
    }
}
