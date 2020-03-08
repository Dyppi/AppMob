package com.example.projetapplimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    private Button scan;
    private Button liste;
    public static TextView json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.scan = (Button) findViewById(R.id.buttonScan);

        this.json = (TextView) findViewById(R.id.jsonContent);

       /* this.scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ScanCodeActivity.class));

            }
        });

        this.liste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ListeProduits.class));
            }
        });*/

        this.scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JSONText().execute("https://world.openfoodfacts.org/api/v0/product/5050083501661.json?fields=product_name_en,product_name_fr");
            }
        });



    }
}
