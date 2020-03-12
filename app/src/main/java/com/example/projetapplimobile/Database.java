package com.example.projetapplimobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Date;

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

    public void insertProduit(String name, Date date_ajout , Date date_Limite){
        name = name.replace("'", "''");
        String strSql = "insert into T_Produits (nomProduit, date_ajout, date_limite) values ('"
                        + name + "', " + date_ajout.getTime() + ", " + date_Limite.getTime() + ")";

        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "insertion a ete invoque");
    }
}
