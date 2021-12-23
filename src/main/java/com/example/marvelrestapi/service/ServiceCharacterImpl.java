package com.example.marvelrestapi.service;

import com.example.marvelrestapi.DAO.CharacterDAO;
import com.example.marvelrestapi.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCharacterImpl implements ServiceCharacter{

    private CharacterDAO CHARACTER_REPOSITORY;

    @Autowired
    public void setCHARACTER_REPOSITORY(CharacterDAO CHARACTER_REPOSITORY) {
        this.CHARACTER_REPOSITORY = CHARACTER_REPOSITORY;
    }

    @Override
    public List<Character> readAll() { return CHARACTER_REPOSITORY.readAll(); }

    @Override
    public Character read(int idCharacter) { return CHARACTER_REPOSITORY.read(idCharacter); }

    @Override
    public boolean add(Character character) { return CHARACTER_REPOSITORY.add(character);}

    @Override
    public boolean delete(int idCharacter) { return CHARACTER_REPOSITORY.delete(idCharacter);}
}
