package com.example.marvelrestapi.controller;

import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.model.Comic;
import com.example.marvelrestapi.query.QueryCharacterModel;
import com.example.marvelrestapi.service.ServiceCharacter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Tag(name="Контроллер charaster", description="Доступ к картотеке персонажей")
@RestController
public class CharacterController {

    private ServiceCharacter SERVICE_CHARACTER;

    @Autowired
    public void setSERVICE_CHARACTER(ServiceCharacter SERVICE_CHARACTER){
        this.SERVICE_CHARACTER = SERVICE_CHARACTER;
    }

    @Operation(summary = "Получает список персонажей", description = "Получает список персонажей")
    @GetMapping(value = "/v1/public/characters")
    public ResponseEntity<List<Character>> readCharacters(@Parameter(description = "Фильтр запроса") RequestEntity<QueryCharacterModel> request){
        final List<Character> characters = SERVICE_CHARACTER.readAll(request.getBody());
        return  characters !=null && !characters.isEmpty()
                ? new ResponseEntity<>(characters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Выбирает персонажа по идентификатору", description = "Выбирает персонажа по идентификатору")
    @GetMapping(value = "/v1/public/characters/{characterId}")
    public ResponseEntity<Character> readCharacterId(@PathVariable(name = "characterId") int characterId){
        final Character character = SERVICE_CHARACTER.read(characterId);
        return character !=null
                ? new ResponseEntity<>(character, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Выбирает список комиксов с персонажем", description = "Выбирает список комиксов с персонажем")
    @GetMapping(value = "/v1/public/characters/{characterId}/comics")
    public ResponseEntity<List<Integer>> readComicsCharacterId(@PathVariable(name = "characterId") int characterId){
        final List<Integer> comics = SERVICE_CHARACTER.read(characterId).getComics();
        return comics !=null && !comics.isEmpty()
                ? new ResponseEntity<>(comics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Добавляет нового персонажа", description = "Добавляет нового персонажа")
    @PostMapping(value = "/v1/public/characters/new")
    public ResponseEntity<?> addCharacter(@RequestBody Character character){
        return SERVICE_CHARACTER.add(character)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
