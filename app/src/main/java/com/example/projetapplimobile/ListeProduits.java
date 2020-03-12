package com.example.projetapplimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListeProduits extends AppCompatActivity {
    private TextView AffichageProduits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produits);

        AffichageProduits = (TextView) findViewById(R.id.textView3);

        List<Produit> produits = MainActivity.database.tousProduits();
        for (Produit p: produits){
            AffichageProduits.append(p.toString());
        }

    }


}
