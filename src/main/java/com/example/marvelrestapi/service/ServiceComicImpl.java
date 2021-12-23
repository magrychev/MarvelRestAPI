package com.example.marvelrestapi.service;

import com.example.marvelrestapi.DAO.ComicDAO;
import com.example.marvelrestapi.model.Comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceComicImpl implements ServiceComic{

    private ComicDAO COMIC_REPOSITORY;

    @Autowired
    public void setCOMIC_REPOSITORY(ComicDAO COMIC_REPOSITORY) {
        this.COMIC_REPOSITORY = COMIC_REPOSITORY;
    }

    @Override
    public List<Comic> readAll() { return COMIC_REPOSITORY.readAll(); }

    @Override
    public Comic read(int idComic) { return COMIC_REPOSITORY.read(idComic);
    }

    @Override
    public boolean add(Comic comic) { return COMIC_REPOSITORY.add(comic); }

    @Override
    public boolean delete(int idComic) { return COMIC_REPOSITORY.delete(idComic); }
}
