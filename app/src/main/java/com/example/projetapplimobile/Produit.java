package com.example.projetapplimobile;

import android.os.Parcelable;

import java.util.Calendar;
import java.util.Date;

public class Produit {
    private String nom;
    private Date date_ajout;
    private Date date_limite;

    public Produit(String nom, Date date_limite){
        this.nom = nom;
        this.date_limite = date_limite;
        this.date_ajout = new Date();
    }

    public int nb_JourRestant(){
        return 
    }

    @Override
    public String toString(){
        return nom + " : " + date_ajout + " : " + date_limite;
    }
}
