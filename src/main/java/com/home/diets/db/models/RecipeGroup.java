package com.home.diets.db.models;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by user on 28.05.2017.
 */

@Entity
@Table(name = "recipeGroup")
public class RecipeGroup implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group")
    private List<Recipe> recipes;

    public RecipeGroup(){
    }

    public RecipeGroup(String name, List<Recipe> recipes){
        this.name = name;
        this.recipes = recipes;
    }

    public Long getId(){
        return id;
    }

    private void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "RecipeGroup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recipes=" + recipes +
                '}';
    }
}
