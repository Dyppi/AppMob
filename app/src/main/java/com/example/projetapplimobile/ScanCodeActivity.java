package com.example.projetapplimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScanCodeActivity extends AppCompatActivity {

    public static TextView resultat;
    Button bouton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        this.resultat = (TextView) findViewById(R.id.textView);
        this.bouton = (Button) findViewById(R.id.button);

        bouton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScanCodeActivity.this, CameraScan.class));
            }
        });
    }
}
