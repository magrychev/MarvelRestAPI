package com.example.marvelrestapi.controller;

import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.model.Comic;
import com.example.marvelrestapi.service.ServiceCharacter;
import com.example.marvelrestapi.service.ServiceComic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    private final ServiceCharacter serviceCharacter;

    @Autowired
    public CharacterController(ServiceCharacter serviceCharacter) {
        this.serviceCharacter=serviceCharacter;
    }

    @GetMapping(value = "/v1/public/characters")
    public ResponseEntity<List<Character>> readCharacters(){
        final List<Character> characters = serviceCharacter.readAll();
        return  characters !=null && !characters.isEmpty()
                ? new ResponseEntity<>(characters, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/public/characters/{characterId}")
    public ResponseEntity<Character> readCharacterId(@PathVariable(name = "characterId") int characterId){
        final Character character = serviceCharacter.read(characterId);
        return character !=null
                ? new ResponseEntity<>(character, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/v1/public/characters/{characterId}/comics")
    public ResponseEntity<List<Comic>> readComicsCharacterId(@PathVariable(name = "characterId") int characterId){
        final List<Comic> comics = serviceCharacter.read(characterId).getComics();
        return comics !=null && !comics.isEmpty()
                ? new ResponseEntity<>(comics, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(value = "/v1/public/characters/new")
    public ResponseEntity<?> addCharacter(@RequestBody Character character){
        return serviceCharacter.add(character)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
