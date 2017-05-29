package com.home.diets.db.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by user on 28.05.2017.
 */

@Entity
@Table(name = "diets")
public class Diet implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diet_id")
    private Long id;
    private String name;
    private String duration;
    private String description;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "diet")
    private List<User> users;

    public Diet(){
    }

    public Diet(String name, String duration, String description){
        this.name = name;
        this.duration = duration;
        this.description = description;
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

    public String getDuration(){
        return duration;
    }

    public void setDuration(String duration){
        this.duration = duration;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }


    @Override
    public String toString(){
        return "Diet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
