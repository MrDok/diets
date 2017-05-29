package com.home.diets.db.services.impl;

import com.home.diets.db.models.Shop;
import com.home.diets.db.services.ShopService;
import com.home.diets.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 * Created by user on 28.05.2017.
 */
public class ShopServiceImpl implements ShopService{
    public Shop getShopById(Long id){
        Session session = HibernateUtils.getSession();
        return session.get(Shop.class, id);
    }

    public Shop getShopByName(String name){
        Query query = HibernateUtils.getSessionFactory().openSession().createQuery("from Shop where name= :name");
        query.setParameter("name", name);
        return (Shop) query.getSingleResult();
    }

    public void addShop(Shop shop){
        Session session = HibernateUtils.getSession();
        session.save(shop);
    }
}
