package com.bilgeadam.maraton_soru2_hibernate.util;

import com.bilgeadam.maraton_soru2_hibernate.entity.Musteri;
import com.bilgeadam.maraton_soru2_hibernate.entity.Siparis;
import com.bilgeadam.maraton_soru2_hibernate.entity.SiparisKalemi;
import com.bilgeadam.maraton_soru2_hibernate.entity.Urun;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory==null){
            try{
                Configuration cfg=new Configuration();
                cfg.addAnnotatedClass(Musteri.class);
                cfg.addAnnotatedClass(Siparis.class);
                cfg.addAnnotatedClass(SiparisKalemi.class);
                cfg.addAnnotatedClass(Urun.class);
                sessionFactory=cfg.configure("hibernate.cfg.xml").buildSessionFactory();
                System.out.println("Success HibernateUtil");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        return sessionFactory;
    }
}
