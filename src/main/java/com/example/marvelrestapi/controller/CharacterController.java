package com.example.marvelrestapi.controller;

import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.model.Comic;
import com.example.marvelrestapi.service.ServiceCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    private ServiceCharacter SERVICE_CHARACTER;

    @Autowired
    public void setSERVICE_CHARACTER(ServiceCharacter SERVICE_CHARACTER){
        this.SERVICE_CHARACTER = SERVICE_CHARACTER;
    }

    @GetMapping(value = "/v1/public/characters")
    public ResponseEntity<List<Character>> readCharacters(){
        final List<Character> characters = SERVICE_CHARACTER.readAll();
        return  characters !=null && !characters.isEmpty()
                ? new ResponseEntity<>(characters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/public/characters/{characterId}")
    public ResponseEntity<Character> readCharacterId(@PathVariable(name = "characterId") int characterId){
        final Character character = SERVICE_CHARACTER.read(characterId);
        return character !=null
                ? new ResponseEntity<>(character, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/public/characters/{characterId}/comics")
    public ResponseEntity<List<Comic>> readComicsCharacterId(@PathVariable(name = "characterId") int characterId){
        final List<Comic> comics = SERVICE_CHARACTER.read(characterId).getComics();
        return comics !=null && !comics.isEmpty()
                ? new ResponseEntity<>(comics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/v1/public/characters/new")
    public ResponseEntity<?> addCharacter(@RequestBody Character character){
        return SERVICE_CHARACTER.add(character)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
