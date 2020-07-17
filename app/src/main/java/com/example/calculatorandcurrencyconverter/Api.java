package com.example.calculatorandcurrencyconverter;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {

    String BASE_URL = "http://data.fixer.io/api/";

    @GET("latest")
    Call<ApiRates> getRates(@Query("access_key")String key);

    @GET
    Call<ApiRates> getHistory(@Url String date,@Query("access_key")String key);
}

