package com.bilgeadam.maraton_soru2_hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade =  CascadeType.ALL)
    private Urun urun;

    private int adet;

    public SiparisKalemi(Urun urun, int adet) {
        this.urun = urun;
        this.adet = adet;
    }
}
