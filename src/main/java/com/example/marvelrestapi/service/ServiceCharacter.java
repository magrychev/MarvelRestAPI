package com.example.marvelrestapi.service;

import com.example.marvelrestapi.model.Character;

import java.util.List;

public interface ServiceCharacter {
    List<Character> readAll();
    Character read(int idCharacter);
    boolean add(Character character);
    boolean delete(int idCharacter);
}
