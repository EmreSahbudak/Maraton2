package com.bilgeadam.maraton_soru2_hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String urunAdi;
    private int fiyat;

    public Urun(String urunAdi, int fiyat) {
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }

    public Urun(Integer id, String urunAdi, int fiyat) {
        this.id = id;
        this.urunAdi = urunAdi;
        this.fiyat = fiyat;
    }
}
