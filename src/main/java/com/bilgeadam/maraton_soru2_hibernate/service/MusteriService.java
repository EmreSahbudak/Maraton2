package com.bilgeadam.maraton_soru2_hibernate.service;

import com.bilgeadam.maraton_soru2_hibernate.entity.Musteri;
import com.bilgeadam.maraton_soru2_hibernate.entity.Siparis;
import com.bilgeadam.maraton_soru2_hibernate.entity.SiparisKalemi;
import com.bilgeadam.maraton_soru2_hibernate.repository.MusteriDao;

import java.util.List;

public class MusteriService {
    public static void main(String[] args) {
        getAllMusteri();
        //siparisAdedi();
        //musteriAdSoyad();
    }
    static MusteriDao musteriDao=new MusteriDao();

    public static void getAllMusteri(){
        List<Musteri> musteriList=musteriDao.getAllMusteri();
        int toplam=0;
        for (Musteri item: musteriList){
            System.out.println("ID: "+item.getId()+" Müşteri Adı: "+item.getAd()
                    +" Müşteri Soyadı:"+item.getSoyad());
            for (Siparis item2:item.getSiparisList()){
                System.out.println("Sipariş Id: "+item2.getId());
                for (SiparisKalemi item3: item2.getSiparisKalemiList()){
                    System.out.println("Ürün: "+item3.getUrun().getUrunAdi()+" Fiyat: "+item3.getUrun().getFiyat()
                            +" Adet Sayısı: "+item3.getAdet());
                    toplam=toplam+item3.getUrun().getFiyat();
            }
            System.out.println("Sipariş Toplam:"+toplam );
        }
        System.out.println("******************************************");
    }
    }
    public static void siparisAdedi(){
        try{
            musteriDao.siparisAdedi();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void musteriAdSoyad(){
        try{
            musteriDao.musteriAdSoyad();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
