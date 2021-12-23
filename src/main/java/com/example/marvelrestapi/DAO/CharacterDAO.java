package com.example.marvelrestapi.DAO;

import com.example.marvelrestapi.model.Character;

import java.util.List;

public interface CharacterDAO {
    List<Character> readAll();
    Character read(int idCharacter);
    boolean add(Character character);
    boolean delete(int idCharacter);
}
