package com.bilgeadam.maraton_soru2_hibernate.repository;

import com.bilgeadam.maraton_soru2_hibernate.entity.Musteri;
import com.bilgeadam.maraton_soru2_hibernate.entity.Siparis;
import com.bilgeadam.maraton_soru2_hibernate.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class MusteriDao {

        public List<Musteri> getAllMusteri(){
            List<Musteri> list=null;
            try{
                Session session= HibernateUtil.getSessionFactory().openSession();
                session.beginTransaction();
                list=session.createQuery("select musteri from Musteri musteri").list();
                session.getTransaction().commit();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            return list;
        }
        public void siparisAdedi(){
            String nativeSql="select  m.id,count(*) from siparis as s\n" +
                    "inner join musteri as m on m.id=s.musteri_id\n" +
                    "inner join siparis_sipariskalemi as ssk on s.id=ssk.siparis_id\n" +
                    "inner join sipariskalemi as sk on sk.id=ssk.siparisKalemiList_id\n" +
                    "inner join urun as u on u.id=sk.urun_id group by m.id";
            try{
                EntityManager entityManager=HibernateUtil.getSessionFactory().createEntityManager();
                List<Object[]> list=entityManager.createNativeQuery(nativeSql).getResultList();
                for (Object[] item: list){
                    System.out.println(
                            "Müsteri Id: " + item[0] + " --"
                                    + " Sipariş Sayısı: " + item[1] + " --"
                    );
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        public void musteriAdSoyad(){
            String sql="select m.ad,m.soyad, s.id from siparis as s\n" +
                    "inner join musteri as m on m.id=s.musteri_id\n" +
                    "inner join siparis_sipariskalemi as ssk on s.id=ssk.siparis_id\n" +
                    "inner join sipariskalemi as sk on sk.id=ssk.siparisKalemiList_id\n" +
                    "inner join urun as u on u.id=sk.urun_id group by s.id";
            try{
                EntityManager entityManager=HibernateUtil.getSessionFactory().createEntityManager();
                List<Object[]> list=entityManager.createNativeQuery(sql).getResultList();
                for (Object[] item: list){
                    System.out.println(
                            "Müsteri Ad: " + item[0] + " --"
                                    + " Müşteri Soyad: " + item[1] + " --"
                                    + " Sipariş Id: " + item[2] + " --"
                    );
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }



}
