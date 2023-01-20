package com.bilgeadam.maraton_soru2_hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ad;
    private String soyad;

    @OneToMany(mappedBy = "musteri",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Siparis> siparisList;

    public Musteri(String ad, String soyad) {
        this.ad = ad;
        this.soyad = soyad;
    }

    public Musteri(Integer id, String ad, String soyad) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
    }
}
