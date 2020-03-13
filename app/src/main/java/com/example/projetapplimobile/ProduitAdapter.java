package com.example.projetapplimobile;

import android.content.Context;
import android.net.sip.SipSession;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import java.util.Date;
import java.util.List;

public class ProduitAdapter extends BaseAdapter {
    private Context context;
    private List<Produit> produitList;
    private LayoutInflater inflater;

    public ProduitAdapter(Context context, List<Produit> produitList){
        this.context = context;
        this.produitList = produitList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produitList.size();
    }

    @Override
    public Object getItem(int i) {
        return produitList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_produit,null);

        Produit currentItem = (Produit) getItem(i);
        String produitNom = currentItem.getNom();
        String date = currentItem.getDate();

        TextView textNomView = view.findViewById(R.id.nomProduit);
        textNomView.setText(produitNom);

        TextView textDateView = view.findViewById(R.id.jourRestant);
        textDateView.setText(date);

        Button boutonSupp = view.findViewById(R.id.buttonSupprProduit);
        boutonSupp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //MainActivity.database.supprimerProduit(produitNom, date);
            }
        });


        return view;
    }

    public class ViewHolder{
          TextView nom;
          TextView date;
          Button supprimer;
    }
}
