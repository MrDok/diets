package com.home.diets.db.services.impl;

import com.home.diets.db.models.Diet;
import com.home.diets.db.services.DietService;
import com.home.diets.utils.HibernateUtils;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by user on 28.05.2017.
 */
public class DietServiceImpl implements DietService{
    public Diet getDietById(Long id){
        return HibernateUtils.getSession().get(Diet.class, id);
    }

    public Diet getDietByName(String name){
        Query query = HibernateUtils.getSessionFactory().openSession().createQuery("from Diet where name= :name");
        query.setParameter("name", name);
        return (Diet) query.getSingleResult();
    }

    public void addDiet(Diet diet){
        HibernateUtils.getSession().save(diet);
    }

    @Override
    public List<Diet> getAllDiets(){
        Query query = HibernateUtils.getSession().createQuery("from Diet");
        return query.list();
    }
}
