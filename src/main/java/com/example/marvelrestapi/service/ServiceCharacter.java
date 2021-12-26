package com.example.marvelrestapi.service;

import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.query.QueryCharacterModel;

import java.util.List;
import java.util.Set;

public interface ServiceCharacter {
    List<Character> readAll(QueryCharacterModel queryCharacterModel);
    Character read(int idCharacter);
    boolean add(Character character);
    boolean delete(int idCharacter);
}
