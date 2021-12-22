package com.example.marvelrestapi.service;

import com.example.marvelrestapi.model.Character;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ServiceCharacterImpl implements ServiceCharacter{

    private static final Map<Integer, Character> CHARACTER_REPOSITORY_MAP = new HashMap<>();

    @Override
    public List<Character> readAll() {
        return new ArrayList<>(CHARACTER_REPOSITORY_MAP.values());
    }

    @Override
    public Character read(int idCharacter) {
        return CHARACTER_REPOSITORY_MAP.get(idCharacter);
    }

    @Override
    public boolean add(Character character) {
        if(!CHARACTER_REPOSITORY_MAP.containsKey(character.getIdCharacter())) {
            CHARACTER_REPOSITORY_MAP.put(character.getIdCharacter(), character);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int idCharacter) {
        return CHARACTER_REPOSITORY_MAP.remove(idCharacter)!=null;
    }
}
