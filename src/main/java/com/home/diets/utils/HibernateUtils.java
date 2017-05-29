package com.home.diets.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by user on 28.05.2017.
 */
public class HibernateUtils {

    private static Session session;
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession(){
        if (session == null){
            try{
                sessionFactory.getCurrentSession();
            }catch (Exception e){
                return sessionFactory.openSession();
            }
        }

        return sessionFactory.openSession();
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }

}