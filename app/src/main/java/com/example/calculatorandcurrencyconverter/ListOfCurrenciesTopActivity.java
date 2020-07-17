package com.example.calculatorandcurrencyconverter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListOfCurrenciesTopActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListOfCurrenciesTopRecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_currencies);
        setTest();
    }

    private void setTest() {

        recyclerView=findViewById(R.id.recyclerViewListOfTopCurrenciesXml);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final ArrayList<Map.Entry<String,Double>> stringArrayList = new ArrayList();

        adapter = new ListOfCurrenciesTopRecyclerViewAdapter(stringArrayList);
        recyclerView.setAdapter(adapter);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Here we are using the GsonConverterFactory to directly convert json data to object
                .build();

        Api api = retrofit.create(Api.class);

        String key = "2bda1428228d6c3914926920dce1f07f";
        Call<ApiRates> call = api.getRates(key);

        call.enqueue(new Callback<ApiRates>() {
            @Override
            public void onResponse(Call<ApiRates> call, Response<ApiRates> response) {
                ApiRates rates = response.body();

                for(Map.Entry entry:rates.getRates().entrySet()){
                    stringArrayList.add(entry);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<ApiRates> call, Throwable t) {
                Log.i("sos",t.getMessage());
                Toast.makeText(ListOfCurrenciesTopActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
}
