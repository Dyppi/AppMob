package com.example.projetapplimobile;

import android.os.AsyncTask;

import com.example.projetapplimobile.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class JSONText extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        try {
            URL url = new URL(params[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            String finalJson = buffer.toString();
            JSONObject parentObject = new JSONObject(finalJson);
            //System.out.println("***************************************************************************************************************************");
            // System.out.println(parentObject.toString());
            //JSONObject product = parentObject.getJSONObject("product");

            //JSONObject finalObject = parentArray.getJSONObject(0);
            //String productNameFr = finalObject.getString("product_name_fr");
            //String productNameEn = finalObject.getString("product_name_en");

            CameraScan.json = parentObject.toString();
            CameraScan.isRecuperer = true;
            return parentObject.toString();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }

            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        //System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////");
        super.onPostExecute(result);
    }
}