package com.bilgeadam.maraton_soru2_hibernate.service;

import com.bilgeadam.maraton_soru2_hibernate.entity.Musteri;
import com.bilgeadam.maraton_soru2_hibernate.entity.Siparis;
import com.bilgeadam.maraton_soru2_hibernate.entity.SiparisKalemi;
import com.bilgeadam.maraton_soru2_hibernate.entity.Urun;
import com.bilgeadam.maraton_soru2_hibernate.repository.SiparisDao;

import java.util.Arrays;
import java.util.List;

public class SiparisService {
    public static void main(String[] args) {
        // bi kere veritabanına kaydedilince ust uste yazmasın diye
        //idli construtor ile veridm ki uzerine yazsın eklemesin yeni.
        Musteri m1=new Musteri(1,"Ali","Kaya");
        Musteri m2=new Musteri(2,"Veli","Özkan");

        Urun u1=new Urun(1,"Iphone11",17000);
        Urun u2=new Urun(2,"Samsung S21",18000);
        Urun u3=new Urun(3,"LG Led TV",8500);
        Urun u4=new Urun(4,"Arçelik Süpürge",2500);

        SiparisKalemi sk1=new SiparisKalemi(u1,1);
        SiparisKalemi sk2=new SiparisKalemi(u2,2);
        Siparis s1=new Siparis(m1, Arrays.asList(sk1,sk2));

        SiparisKalemi sk3=new SiparisKalemi(u2,2);
        SiparisKalemi sk4=new SiparisKalemi(u3,1);
        Siparis s2=new Siparis(m2, Arrays.asList(sk3,sk4));

        SiparisKalemi sk5=new SiparisKalemi(u4,2);
        Siparis s3=new Siparis(m1, Arrays.asList(sk5));

        Siparis s4=new Siparis(m2, Arrays.asList(new SiparisKalemi(u1,1)));
        Siparis s5=new Siparis(m1, Arrays.asList(new SiparisKalemi(u2,1)));

        //save(s5);
        getAllSiparis();


    }
    static SiparisDao siparisDao=new SiparisDao();

    public static void save(Siparis siparis){
        try{
            siparisDao.save(siparis);
            System.out.println(siparis.getMusteri().getAd()+" isimli kişini isparisi database kaydedilmiştir(siparisService)");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void getAllSiparis(){
        List<Siparis> siparisList=siparisDao.getAllSiparis();
        int toplam=0;
        for (Siparis item: siparisList){
            System.out.println("ID: "+item.getId()+" Müşteri: "+item.getMusteri().getAd()
                    +item.getMusteri().getSoyad()+" Musteri ID: "+item.getMusteri().getId());
            for (SiparisKalemi item2:item.getSiparisKalemiList()){
                System.out.println("Ürün: "+item2.getUrun().getUrunAdi()+" Fiyat: "+item2.getUrun().getFiyat()
                +" Adet Sayısı: "+item2.getAdet());
                toplam=item2.getUrun().getFiyat();
            }
            System.out.println("Sipariş Toplam:"+toplam );
        }
        System.out.println("******************************************");
    }
}
