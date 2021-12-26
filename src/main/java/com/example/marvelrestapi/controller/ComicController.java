package com.example.marvelrestapi.controller;

import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.model.Comic;
import com.example.marvelrestapi.query.QueryCharacterModel;
import com.example.marvelrestapi.query.QueryComicModel;
import com.example.marvelrestapi.service.ServiceComic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComicController {

    private ServiceComic SERVICE_COMIC;

    @Autowired
    public void setSERVICE_COMIC(ServiceComic SERVICE_COMIC) {
        this.SERVICE_COMIC = SERVICE_COMIC;
    }

    @GetMapping(value = "/v1/comics")
    public ResponseEntity<List<Comic>> readComics(RequestEntity<QueryComicModel> request){
        final List<Comic> comics = SERVICE_COMIC.readAll(request.getBody());
        return comics !=null && !comics.isEmpty()
                ? new ResponseEntity<>(comics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/comics/{comicId}")
    public  ResponseEntity<Comic> readComicId(@PathVariable(name = "comicId") int comicId){
        final Comic comic = SERVICE_COMIC.read(comicId);
        return comic !=null
                ? new ResponseEntity<>(comic, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/comics/{comicId}/characters")
    public ResponseEntity<List<Character>> readCharactersComicId(@PathVariable(name = "comicId") int comicId){
        final List<Character> characters = SERVICE_COMIC.read(comicId).getCharacters();
        return characters !=null && characters.isEmpty()
                ? new ResponseEntity<>(characters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/v1/public/comics/new")
    public ResponseEntity<?> addCharacter(@RequestBody Comic comic){
        return SERVICE_COMIC.add(comic)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
