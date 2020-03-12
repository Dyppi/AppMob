package com.example.projetapplimobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class ChoixDeLaDate extends AppCompatActivity {

    private CalendarView calendrier;
    private Button ok;
    private TextView mydate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_de_la_date);

        ok = (Button) findViewById(R.id.buttonOK);
        calendrier = (CalendarView) findViewById(R.id.calendarView);
        mydate = (TextView) findViewById(R.id.calenderDate);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScanCodeActivity.date.setVisibility(View.VISIBLE);
                ScanCodeActivity.boutonAjouter.setVisibility(View.VISIBLE);

                onBackPressed();
            }
        });

        this.calendrier.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String newdate = dayOfMonth + "/" + (month+1) + "/" + year;
                ScanCodeActivity.date.setText(newdate);
                mydate.setText(newdate);
            }
        });
    }
}
