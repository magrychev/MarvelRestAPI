package com.example.marvelrestapi.DAO;

import com.example.marvelrestapi.model.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CharacterDAOImpl implements CharacterDAO {

    private static final Map<Integer, Character> CHARACTER_MAP = new HashMap<>();

    @Override
    public List<Character> readAll() {
        return new ArrayList<>(CHARACTER_MAP.values());
    }

    @Override
    public Character read(int idCharacter) {
        return CHARACTER_MAP.get(idCharacter);
    }

    @Override
    public boolean add(Character character) {
        if(!CHARACTER_MAP.containsKey(character.getIdCharacter())) {
            CHARACTER_MAP.put(character.getIdCharacter(), character);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int idCharacter) {
        return CHARACTER_MAP.remove(idCharacter)!=null;
    }

}
