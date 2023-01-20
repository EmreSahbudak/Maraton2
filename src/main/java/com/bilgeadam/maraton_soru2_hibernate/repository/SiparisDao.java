package com.bilgeadam.maraton_soru2_hibernate.repository;

import com.bilgeadam.maraton_soru2_hibernate.entity.Siparis;
import com.bilgeadam.maraton_soru2_hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class SiparisDao {
    public void save(Siparis siparis){
        try{
            Session session= HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(siparis);
            session.getTransaction().commit();
            System.out.println(siparis.getMusteri().getAd()+" isimli müsteri siparişi database kaydedildi.(siparisDao)");
            session.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public List<Siparis> getAllSiparis() { //
        List<Siparis> list=null;
        try{
            Session session=HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            list=session.createQuery("select siparis from Siparis siparis").list();
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
















}
