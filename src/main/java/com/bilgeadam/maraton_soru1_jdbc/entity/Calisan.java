package com.bilgeadam.maraton_soru1_jdbc.entity;

public class Calisan {
    private Integer id;
    private String calisanIsmi;
    private int yas;
    private double maas;
    private String departman;
    private Sirket sirket;

    public Calisan(String calisanIsmi, int yas, double maas, String departman, Sirket sirket) {
        this.calisanIsmi = calisanIsmi;
        this.yas = yas;
        this.maas = maas;
        this.departman = departman;
        this.sirket = sirket;
    }

    public Calisan(Integer id, String calisanIsmi, int yas, double maas, String departman, Sirket sirket) {
        this.id = id;
        this.calisanIsmi = calisanIsmi;
        this.yas = yas;
        this.maas = maas;
        this.departman = departman;
        this.sirket = sirket;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCalisanIsmi() {
        return calisanIsmi;
    }
    public void setCalisanIsmi(String calisanIsmi) {
        this.calisanIsmi = calisanIsmi;
    }
    public int getYas() {
        return yas;
    }
    public void setYas(int yas) {
        this.yas = yas;
    }
    public double getMaas() {
        return maas;
    }
    public void setMaas(double maas) {
        this.maas = maas;
    }
    public String getDepartman() {
        return departman;
    }
    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "id=" + id +
                ", calisanIsmi='" + calisanIsmi + '\'' +
                ", yas=" + yas +
                ", maas=" + maas +
                ", departman='" + departman + '\'' +
                ", sirket=" + sirket +
                '}';
    }
}
