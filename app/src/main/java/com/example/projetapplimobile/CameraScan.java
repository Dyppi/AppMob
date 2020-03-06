package com.example.projetapplimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CameraScan extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result) { //c'est ce qui se passe lorsque nous avons trouvé un résultat
        ScanCodeActivity.resultat.setText(result.getText());
        ScanCodeActivity.layout.setVisibility(View.VISIBLE);
        //ScanCodeActivity.boutonAjouter.setVisibility(View.VISIBLE);
        onBackPressed();
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(this);
        scannerView.startCamera();
    }

    @Override
    protected void onPause(){
        super.onPause();
        scannerView.stopCamera();
    }
}
