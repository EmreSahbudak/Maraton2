package com.bilgeadam.maraton_soru1_jdbc.service;

import com.bilgeadam.maraton_soru1_jdbc.entity.Sirket;
import com.bilgeadam.maraton_soru1_jdbc.repository.SirketDao;

public class SirketService {
    public static void main(String[] args) {
        //save();

    }
    static SirketDao sirketDao=new SirketDao();
    public static void save(){
        Sirket sirket=new Sirket("Hasan Tekin Ada","Hasan Tekin","HTAAL","HalıSaha",1997);
        try{
            sirketDao.save(sirket);
            System.out.println(sirket.getSirketIsmi()+" isimli şirket veirtabanına kaydedildi(sirketService)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
