package com.home.diets.db.services;

import com.home.diets.db.models.Diet;

import java.util.List;

/**
 * Created by user on 28.05.2017.
 */
public interface DietService{
    Diet getDietById(Long id);
    Diet getDietByName(String name);
    void addDiet(Diet diet);
    List<Diet> getAllDiets();
}
