package com.bilgeadam.maraton_soru2_hibernate.service;

import com.bilgeadam.maraton_soru2_hibernate.entity.Musteri;
import com.bilgeadam.maraton_soru2_hibernate.entity.Siparis;
import com.bilgeadam.maraton_soru2_hibernate.entity.SiparisKalemi;
import com.bilgeadam.maraton_soru2_hibernate.entity.Urun;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Musteri m1=new Musteri("Ali","Kaya");
        Musteri m2=new Musteri("Veli","Özkan");

        Urun u1=new Urun("Iphone11",17000);
        Urun u2=new Urun("Samsung S21",18000);
        Urun u3=new Urun("LG Led TV",8500);
        Urun u4=new Urun("Arçelik Süpürge",2500);

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

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
    }


}
