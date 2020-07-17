package com.example.calculatorandcurrencyconverter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

public class ListOfCurrenciesTopRecyclerViewAdapter extends RecyclerView.Adapter<ListOfCurrenciesTopRecyclerViewAdapter.ViewHolderTop> {

    List<Map.Entry<String,Double>> listOfCurrenciesTop;

    public ListOfCurrenciesTopRecyclerViewAdapter(List<Map.Entry<String, Double>> listOfCurrencies) {
        this.listOfCurrenciesTop = listOfCurrencies;
    }


    @NonNull
    @Override
    public ViewHolderTop onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_top, parent, false);

        return new ViewHolderTop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderTop holder, final int position) {
        holder.textViewNameTopCurrency.setText(listOfCurrenciesTop.get(position).getKey());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String baseName=listOfCurrenciesTop.get(position).getKey();
                double base=listOfCurrenciesTop.get(position).getValue();
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                SharedPreferences.Editor editor = v.getContext().getSharedPreferences("Currency", Context.MODE_PRIVATE).edit();
                editor.putString("baseName", baseName);
                editor.putFloat("base",Float.parseFloat(String.valueOf(base)));
                editor.apply();
                v.getContext().startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfCurrenciesTop.size();
    }

    public class ViewHolderTop extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView textViewNameTopCurrency;
        public ViewHolderTop(@NonNull View itemView) {
            super(itemView);

            cardView=itemView.findViewById(R.id.cardViewTop);
            textViewNameTopCurrency=itemView.findViewById(R.id.textViewCurrencyTopXml);
        }
    }
}
