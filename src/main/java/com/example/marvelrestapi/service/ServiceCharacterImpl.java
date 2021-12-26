package com.example.marvelrestapi.service;

import com.example.marvelrestapi.DAO.CharacterDAO;
import com.example.marvelrestapi.model.Character;
import com.example.marvelrestapi.query.QueryCharacterModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceCharacterImpl implements ServiceCharacter{

    private CharacterDAO CHARACTER_REPOSITORY;

    @Autowired
    public void setCHARACTER_REPOSITORY(CharacterDAO CHARACTER_REPOSITORY) {
        this.CHARACTER_REPOSITORY = CHARACTER_REPOSITORY;
    }

    @Override
    public List<Character> readAll(QueryCharacterModel queryCharacterModel) {
        List<Character> result = CHARACTER_REPOSITORY.readAll();
        result.sort(Comparator.comparing(Character::getNameCharacter));
        if(queryCharacterModel == null)
            return result;
        for(Character character:CHARACTER_REPOSITORY.readAll()){
            if(queryCharacterModel.getNames() != null
                    && queryCharacterModel.getNames().equals(character.getNameCharacter())) result.add(character);
            if(queryCharacterModel.getNameStartsWith() != null
                    && character.getNameCharacter().startsWith(queryCharacterModel.getNameStartsWith())) result.add(character);
            if(queryCharacterModel.getComics() !=null){
                for(Integer comicIdQuery:queryCharacterModel.getComics()){
                        if(character.getComics().contains(comicIdQuery)) result.add(character);
                }
            }
        }
        return result;
    }

    @Override
    public Character read(int idCharacter) {
        return CHARACTER_REPOSITORY.read(idCharacter); }

    @Override
    public boolean add(Character character) {
        return CHARACTER_REPOSITORY.add(character);}

    @Override
    public boolean delete(int idCharacter) {
        return CHARACTER_REPOSITORY.delete(idCharacter);}
}
