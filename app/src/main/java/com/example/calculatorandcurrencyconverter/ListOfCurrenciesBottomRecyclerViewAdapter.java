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

public class ListOfCurrenciesBottomRecyclerViewAdapter  extends RecyclerView.Adapter<ListOfCurrenciesBottomRecyclerViewAdapter.ViewHolderBottom> {

    List<Map.Entry<String,Double>> listOfCurrencies;

    public ListOfCurrenciesBottomRecyclerViewAdapter(List<Map.Entry<String, Double>> listOfCurrencies) {
        this.listOfCurrencies = listOfCurrencies;
    }

    @NonNull
    @Override
    public ViewHolderBottom onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_bottom, parent, false);
        return new ViewHolderBottom(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderBottom holder, final int position) {
        holder.textViewBottomCurrency.setText(listOfCurrencies.get(position).getKey());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String coinName=listOfCurrencies.get(position).getKey();
                double coin=listOfCurrencies.get(position).getValue();
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                SharedPreferences.Editor editor = v.getContext().getSharedPreferences("Currency", Context.MODE_PRIVATE).edit();
                editor.putString("coinName", coinName);
                editor.putFloat("coin",Float.parseFloat(String.valueOf(coin)));
                editor.apply();
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfCurrencies.size();
    }

    public class ViewHolderBottom extends RecyclerView.ViewHolder {

        TextView textViewBottomCurrency;
        CardView cardView;
        public ViewHolderBottom(@NonNull View itemView) {
            super(itemView);

            cardView=itemView.findViewById(R.id.cardViewBottom);
            textViewBottomCurrency=itemView.findViewById(R.id.textViewCurrencyBottomXml);
        }
    }
}
