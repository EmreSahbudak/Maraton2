package com.bilgeadam.maraton_soru2_hibernate.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Siparis {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Musteri musteri;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<SiparisKalemi> siparisKalemiList;

    public Siparis(Musteri musteri, List<SiparisKalemi> siparisKalemiList) {
        this.musteri = musteri;
        this.siparisKalemiList = siparisKalemiList;
    }
}
