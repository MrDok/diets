package com.home.diets.db.services;

import com.home.diets.db.models.Diet;
import com.home.diets.db.models.User;

/**
 * Created by user on 28.05.2017.
 */
public interface UserService{
    User getUserById(Long id);
    User getUserByName(String name);
    void addUser(User user);
    boolean isAdmin(Long id);
    void addDiet(Long id, Diet diet);
    void removeDiet(Long id);
    User logIn(String login, String password);
    User signIn(String login, String password);
}
