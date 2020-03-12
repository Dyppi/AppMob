package com.example.projetapplimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.zxing.Result;

import org.json.JSONException;
import org.json.JSONObject;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CameraScan extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    ZXingScannerView scannerView;
    public static String json;
    public static boolean isRecuperer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZXingScannerView(this);
        json = "test wesh";
        isRecuperer = false;
        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result) { //c'est ce qui se passe lorsque nous avons trouvé un résultat
        ScanCodeActivity.layout.setVisibility(View.INVISIBLE);
        try {
            Integer.parseInt(result.getText());
        }catch (Exception e) { //
            ScanCodeActivity.resultat.setText("Ceci n'est pas un produit... désolé.");
        }
        new JSONText().execute("https://world.openfoodfacts.org/api/v0/product/" + result.getText() + ".json?fields=product_name_en,product_name_fr");
        int i = 0;
        int imax =  999999999;
        while (isRecuperer == false) {
            if(i > imax)
                break;
            i++;
        }
        try {
            JSONObject jsonobjet = new JSONObject(json);
            if(jsonobjet.getString("status_verbose").equals("product found")) {
                JSONObject product = jsonobjet.getJSONObject("product");
                ScanCodeActivity.resultat.setText(product.getString("product_name_fr"));
                ScanCodeActivity.layout.setVisibility(View.VISIBLE);
            }else {
                ScanCodeActivity.resultat.setText("Le produit n'a pas été trouvé...");
            }
        } catch (JSONException e) {
            ScanCodeActivity.resultat.setText("Une erreur s'est produite ...");
            //ScanCodeActivity.resultat.setText(json);
        }

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
