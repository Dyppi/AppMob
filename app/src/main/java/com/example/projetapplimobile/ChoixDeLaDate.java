package com.example.projetapplimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

public class ChoixDeLaDate extends AppCompatActivity {

    private CalendarView calendrier;
    private Button ok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_de_la_date);

        ok = (Button) findViewById(R.id.buttonOK);
        calendrier = (CalendarView) findViewById(R.id.calendarView);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScanCodeActivity.date.setVisibility(View.VISIBLE);
                ScanCodeActivity.boutonAjouter.setVisibility(View.VISIBLE);
                onBackPressed();
            }
        });
    }
}
