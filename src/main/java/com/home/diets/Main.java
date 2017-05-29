package com.home.diets;

import com.home.diets.db.models.Shop;
import com.home.diets.db.models.User;
import com.home.diets.db.services.UserService;
import com.home.diets.db.services.impl.UserServiceImpl;
import com.home.diets.utils.HibernateUtils;
import org.hibernate.Session;

/**
 * Created by user on 28.05.2017.
 */
public class Main{
    public static void main(String[] args){
        Session session = HibernateUtils.getSessionFactory().openSession();

        session.beginTransaction();

        UserService userService = new UserServiceImpl();
        User user = new User("name", "login", "password", true);
        userService.addUser(user);
        System.out.println(userService.getUserById(1L));
        System.out.println(userService.getUserByName("name"));

        Shop shop = new Shop("1", "2", "3");
        session.save(shop);
        session.getTransaction().commit();
    }
}
