package com.example.marvelrestapi.controller;

import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.model.Comic;
import com.example.marvelrestapi.service.ServiceComic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Handler;

@RestController
public class ComicController {

    private final ServiceComic serviceComic;

    @Autowired
    public ComicController(ServiceComic serviceComic){
        this.serviceComic=serviceComic;
    }

    @GetMapping(value = "/v1/comics")
    public ResponseEntity<List<Comic>> readComics(){
        final List<Comic> comics = serviceComic.readAll();
        return comics !=null && !comics.isEmpty()
                ? new ResponseEntity<>(comics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/comics/{comicId}")
    public  ResponseEntity<Comic> readComicId(@PathVariable(name = "comicId") int comicId){
        final Comic comic = serviceComic.read(comicId);
        return comic !=null
                ? new ResponseEntity<>(comic, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/comics/{comicId}/characters")
    public ResponseEntity<List<Character>> readCharactersComicId(@PathVariable(name = "comicId") int comicId){
        final List<Character> characters = serviceComic.read(comicId).getCharacters();
        return characters !=null && characters.isEmpty()
                ? new ResponseEntity<>(characters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value = "/v1/public/comics/new")
    public ResponseEntity<?> addCharacter(@RequestBody Comic comic){
        return serviceComic.add(comic)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
