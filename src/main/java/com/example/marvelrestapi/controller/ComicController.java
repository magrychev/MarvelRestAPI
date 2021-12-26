package com.example.marvelrestapi.controller;

import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.model.Comic;
import com.example.marvelrestapi.query.QueryCharacterModel;
import com.example.marvelrestapi.query.QueryComicModel;
import com.example.marvelrestapi.service.ServiceComic;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Контроллер comic", description="Доступ к библиотеке комиксов")
@RestController
public class ComicController {

    private ServiceComic SERVICE_COMIC;

    @Autowired
    public void setSERVICE_COMIC(ServiceComic SERVICE_COMIC) {
        this.SERVICE_COMIC = SERVICE_COMIC;
    }

    @Operation(summary = "Получает список комиксов", description = "Получает список комиксов")
    @GetMapping(value = "/v1/comics")
    public ResponseEntity<List<Comic>> readComics(@Parameter(description = "Фильтр запроса")RequestEntity<QueryComicModel> request){
        final List<Comic> comics = SERVICE_COMIC.readAll(request.getBody());
        return comics !=null && !comics.isEmpty()
                ? new ResponseEntity<>(comics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Получает комикс по идентификатору", description = "Получает комикс по идентификатору")
    @GetMapping(value = "/v1/comics/{comicId}")
    public  ResponseEntity<Comic> readComicId(@PathVariable(name = "comicId") int comicId){
        final Comic comic = SERVICE_COMIC.read(comicId);
        return comic !=null
                ? new ResponseEntity<>(comic, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Получает комикс по идентификатору", description = "Получает комикс по идентификатору")
    @GetMapping(value = "/v1/comics/{comicId}/characters")
    public ResponseEntity<List<Integer>> readCharactersComicId(@PathVariable(name = "comicId") int comicId){
        final List<Integer> characters = SERVICE_COMIC.read(comicId).getCharacters();
        return characters !=null && characters.isEmpty()
                ? new ResponseEntity<>(characters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Operation(summary = "Получает список персонажей в комиксе", description = "Получает список персонажей в комиксе")
    @PostMapping(value = "/v1/public/comics/new")
    public ResponseEntity<?> addCharacter(@RequestBody Comic comic){
        return SERVICE_COMIC.add(comic)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
