package com.bilgeadam.maraton_soru1_jdbc.entity;

public class Sirket {
    private Integer id;
    private String sirketIsmi;
    private String sirketSahibi;
    private String unvani;
    private String faliyetAlani;
    private int kurulusYili;

    public Sirket(Integer id) {
        this.id = id;
    }

    public Sirket(String sirketIsmi, String sirketSahibi, String unvani, String faliyetAlani, int kurulusYili) {
        this.sirketIsmi = sirketIsmi;
        this.sirketSahibi = sirketSahibi;
        this.unvani = unvani;
        this.faliyetAlani = faliyetAlani;
        this.kurulusYili = kurulusYili;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getSirketIsmi() {
        return sirketIsmi;
    }
    public void setSirketIsmi(String sirketIsmi) {
        this.sirketIsmi = sirketIsmi;
    }
    public String getSirketSahibi() {
        return sirketSahibi;
    }
    public void setSirketSahibi(String sirketSahibi) {
        this.sirketSahibi = sirketSahibi;
    }
    public String getUnvani() {
        return unvani;
    }
    public void setUnvani(String unvani) {
        this.unvani = unvani;
    }
    public String getFaliyetAlani() {
        return faliyetAlani;
    }
    public void setFaliyetAlani(String faliyetAlani) {
        this.faliyetAlani = faliyetAlani;
    }
    public int getKurulusYili() {
        return kurulusYili;
    }
    public void setKurulusYili(int kurulusYili) {
        this.kurulusYili = kurulusYili;
    }

    @Override
    public String toString() {
        return "Sirket{" +
                "id=" + id +
                ", sirketIsmi='" + sirketIsmi + '\'' +
                ", sirketSahibi='" + sirketSahibi + '\'' +
                ", unvani='" + unvani + '\'' +
                ", faliyetAlani='" + faliyetAlani + '\'' +
                ", kurulusYili=" + kurulusYili +
                '}';
    }
}
