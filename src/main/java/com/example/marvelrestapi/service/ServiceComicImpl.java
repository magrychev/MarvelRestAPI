package com.example.marvelrestapi.service;

import com.example.marvelrestapi.DAO.ComicDAO;
import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.model.Comic;
import com.example.marvelrestapi.query.QueryCharacterModel;
import com.example.marvelrestapi.query.QueryComicModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ServiceComicImpl implements ServiceComic{

    private ComicDAO COMIC_REPOSITORY;

    @Autowired
    public void setCOMIC_REPOSITORY(ComicDAO COMIC_REPOSITORY) {
        this.COMIC_REPOSITORY = COMIC_REPOSITORY;
    }

    @Override
    public List<Comic> readAll(QueryComicModel queryComicModel) {
        List<Comic> result = COMIC_REPOSITORY.readAll();
        result.sort(Comparator.comparing(Comic::getTitleComic));
        if(queryComicModel == null)
            return result;
        for(Comic comic:COMIC_REPOSITORY.readAll()){
            if(queryComicModel.getTitle() != null
                    && queryComicModel.getTitle().equals(comic.getTitleComic())) result.add(comic);
            if(queryComicModel.getTitleStartsWith() != null
                    && comic.getTitleComic().startsWith(queryComicModel.getTitleStartsWith())) result.add(comic);
        }
        return result;
    }

    @Override
    public Comic read(int idComic) { return COMIC_REPOSITORY.read(idComic);
    }

    @Override
    public boolean add(Comic comic) { return COMIC_REPOSITORY.add(comic); }

    @Override
    public boolean delete(int idComic) { return COMIC_REPOSITORY.delete(idComic); }
}
