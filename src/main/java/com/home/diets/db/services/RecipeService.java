package com.home.diets.db.services;

import com.home.diets.db.models.Recipe;
import com.home.diets.db.models.RecipeGroup;

/**
 * Created by user on 28.05.2017.
 */

public interface RecipeService{
    Recipe getRecipeById(Long id);
    Recipe getRecipeByName(String name);
    void addRecipe(Recipe recipe);
    void addNewRecipeGroup(RecipeGroup recipeGroup);
}
