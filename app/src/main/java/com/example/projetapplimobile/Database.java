package com.example.projetapplimobile;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NOM = "produits.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context){
        super(context, DATABASE_NOM, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String strSql = "create table T_Produits(" +
                        "   idProduit integer primary key autoincrement," +
                        "   nomProduit text not null," +
                        "   date_ajout integer not null," +
                        "   date_limite integer not null" +
                        ")";

        sqLiteDatabase.execSQL(strSql);
        Log.i("DATABASE", "onCreate a ete invoque");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int odlVersion, int newVersion) {

    }

    public void insertProduit(String name, Date date_Limite){
        name = name.replace("'", "''");
        String strSql = "insert into T_Produits (nomProduit, date_ajout, date_limite) values ('"
                        + name + "', " + new Date().getTime() + ", " + date_Limite.getTime() + ")";

        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "insertion a ete invoque");
    }

    public void supprimerProduit(){
        String strSql = "delete from T_Produits";

        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "insertion a ete invoque");
    }

    public List<Produit> tousProduits(){
        List<Produit> produits = new ArrayList<>();

        String strSql = "select * from T_Produits order by idProduit";
        Cursor cursor = this.getReadableDatabase().rawQuery(strSql,null);
        cursor.moveToFirst();

        while(! cursor.isAfterLast()){
            Date dataA = new Date();
            dataA.setTime(cursor.getInt(2));
            Date dataL = new Date();
            dataL.setTime(cursor.getInt(3));
            Produit produit = new Produit(cursor.getString(1),dataL, dataA);

            produits.add(produit);
            cursor.moveToNext();
        }
        cursor.close();

        return produits;
    }
}
