package com.home.diets.db.services.impl;

import com.home.diets.db.models.Recipe;
import com.home.diets.db.models.RecipeGroup;
import com.home.diets.db.models.Shop;
import com.home.diets.db.services.RecipeService;
import com.home.diets.utils.HibernateUtils;
import org.hibernate.query.Query;

/**
 * Created by user on 28.05.2017.
 */
public class RecipeServiceImpl implements RecipeService{
    public Recipe getRecipeById(Long id){
        return HibernateUtils.getSession().get(Recipe.class, id);
    }

    public Recipe getRecipeByName(String name){
        Query query = HibernateUtils.getSessionFactory().openSession().createQuery("from Recipe where name= :name");
        query.setParameter("name", name);
        return (Recipe) query.getSingleResult();
    }

    public void addRecipe(Recipe recipe){
        HibernateUtils.getSession().save(recipe);
    }

    public void addNewRecipeGroup(RecipeGroup recipeGroup){
        HibernateUtils.getSession().save(recipeGroup);
    }
}
