package com.bilgeadam.maraton_soru1_jdbc.service;

import com.bilgeadam.maraton_soru1_jdbc.entity.Calisan;
import com.bilgeadam.maraton_soru1_jdbc.entity.Sirket;
import com.bilgeadam.maraton_soru1_jdbc.repository.CalisanDao;

public class CalisanService {
    public static void main(String[] args) {
        //save();
        //getAll();
        //delete(4);
        //update(2,"araba yıkama bölümü");

    }
    static CalisanDao calisanDao=new CalisanDao();
    public static void save(){
        Calisan calisan=new Calisan("Ali Remzi",50,9500,"Halisaha",
                new Sirket(3));
        try{
            calisanDao.save(calisan);
            System.out.println(calisan.getCalisanIsmi()+" isimli calisan database kaydedildi(CalisanService)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void getAll(){
        try{
            calisanDao.getAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static  void delete(int id){
        try{
            calisanDao.delete(id);
            System.out.println(id+". li satır silindi(calisanService)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void update(int id,String abc){
        try{
            calisanDao.update(id,abc);
            System.out.println(id+". li satır update edildi(calisanService)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
