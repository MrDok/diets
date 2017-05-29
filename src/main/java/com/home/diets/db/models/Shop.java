package com.home.diets.db.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by user on 28.05.2017.
 */

@Entity
@Table(name = "shops")
public class Shop implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @Column(nullable = false)
    private String address;

    public Shop(){
    }

    public Shop(String name, String description, String address){
        this.name = name;
        this.description = description;
        this.address = address;
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

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    @Override
    public String toString(){
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
