package com.example.javaproject;

import java.util.ArrayList;
import java.util.Random;

public class Hastane {
    Random rand=new Random();
    private String isim;
    private String tarih;


    ArrayList<String> hastane=new ArrayList<>();

    ArrayList<String> date =new ArrayList<>();


    public Hastane() {
        this.isim = isim;
        this.tarih = tarih;
    }


    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public void hastane_olustur(){
        hastane.add("Acibadem Hastanesi");
        hastane.add("Memorial Hastanesi");
        hastane.add("Marmara Üniversitesi Hastanesi");
        int k=rand.nextInt(4);
        setIsim(hastane.get(k));
        Array.hastanearr.add(isim);
    }
    public void tarih_olustur(){
        date.add("31.05.2023");
        date.add("15.01.2023");
        date.add("23.02.2023");
        date.add("29.02.2023");
        int n = rand.nextInt(5);
        setTarih(date.get(n));
        Array.tarih.add(tarih);
    }
}
