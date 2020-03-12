package com.example.projetapplimobile;

import android.os.Parcelable;

import java.util.Calendar;
import java.util.Date;

public class Produit {
    private String nom;
    private Date date_ajout;
    private Date date_limite;
    private String date;

    public Produit(String nom, Date date_limite, String date){
        this.nom = nom;
        this.date_limite = date_limite;
        this.date_ajout = new Date();
    }

    public Produit(String nom, Date date_limite, Date date_ajout, String date){
        this.nom = nom;
        this.date_ajout = date_ajout;
        this.date_limite = date_limite;
        this.date = date;
    }

    public double nb_JourRestant(){
        Calendar calendrierA = Calendar.getInstance();
        calendrierA.setTime(date_ajout);

        Calendar calendrierL = Calendar.getInstance();
        calendrierL.setTime(date_limite);

        double ms = calendrierL.getTimeInMillis() - calendrierA.getTimeInMillis();
        long nbDays = Math.round(ms / (24 * 60 * 60 * 1000));

        return nbDays;
    }

    @Override
    public String toString(){
        return nom + " : " + date_ajout + " : " + date_limite;
    }

    public String getNom() {
        return nom;
    }

    public Date getDate_ajout() {
        return date_ajout;
    }

    public Date getDate_limite() {
        return date_limite;
    }

    public String getDate() {
        return date;
    }
}
