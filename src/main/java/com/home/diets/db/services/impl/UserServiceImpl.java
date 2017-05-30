package com.home.diets.db.services.impl;

import com.home.diets.db.models.Diet;
import com.home.diets.db.models.User;
import com.home.diets.db.services.UserService;
import com.home.diets.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Created by user on 28.05.2017.
 */
public class UserServiceImpl implements UserService{
    public User getUserById(Long id){
        Session session = HibernateUtils.getSession();
        return session.get(User.class, id);
    }

    public User getUserByName(String name){
        Query query = HibernateUtils.getSessionFactory().openSession().createQuery("from User where name= :name");
        query.setParameter("name", name);
        return (User) query.getSingleResult();
    }

    public void addUser(User user){
        Session session = HibernateUtils.getSession();
        session.save(user);
    }

    public boolean isAdmin(Long id){
        Session session = HibernateUtils.getSession();
        User user = session.get(User.class, id);
        if (user != null){
            return user.getIsAdmin();
        }

        return false;
    }

    public void addDiet(Long id, Diet diet){
        User user = HibernateUtils.getSession().get(User.class, id);
        user.setDiet(diet);
        HibernateUtils.getSession().saveOrUpdate(user);
    }

    public void removeDiet(Long id){
        User user = HibernateUtils.getSession().get(User.class, id);
        user.setDiet(null);
        HibernateUtils.getSession().saveOrUpdate(user);
    }

    public User logIn(String login, String password){
        Query query = HibernateUtils.getSession().createQuery("from User where login= :login and password= :password");
        query.setParameter("login", login);
        query.setParameter("password", password);
        return (User) query.getSingleResult();
    }

    public void signIn(String login, String password){
        User user = new User(login, password, false);

        HibernateUtils.getSession().save(user);
    }
}
