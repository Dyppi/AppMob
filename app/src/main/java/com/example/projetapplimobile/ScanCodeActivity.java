package com.example.projetapplimobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScanCodeActivity extends AppCompatActivity {

    public static TextView resultat;
    private Button bouton;
    public static Button boutonAjouter;
    public static ConstraintLayout layout;
    public Button boutonDate;
    public static TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        this.resultat = (TextView) findViewById(R.id.textView);
        this.bouton = (Button) findViewById(R.id.button);
        this.boutonAjouter = (Button) findViewById(R.id.boutonAjouter);
        this.layout = (ConstraintLayout) findViewById(R.id.layout);
        //this.calendrier = (CalendarView) findViewById(R.id.calendarView);
        this.boutonDate = (Button) findViewById(R.id.boutonDate);

        date = (TextView) findViewById(R.id.date);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScanCodeActivity.this, CameraScan.class));
            }
        });

        boutonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScanCodeActivity.this, ChoixDeLaDate.class));
                boutonDate.setVisibility(View.INVISIBLE);
            }
        });

        boutonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


                try {
                    String nomProduit = (String) resultat.getText();
                    Date dateL = sdf.parse((String) date.getText());

                    MainActivity.database.insertProduit(nomProduit, dateL);

                    Toast.makeText(getApplicationContext(),"c'est bon",Toast.LENGTH_LONG).show();

                } catch (ParseException e) {
                    e.printStackTrace();
                }



            }
        });

    }
}
