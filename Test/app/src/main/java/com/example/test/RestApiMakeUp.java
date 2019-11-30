package com.example.test;

import com.example.test.model.Lipstick;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiMakeUp {
   @GET("products.json?product_category=lipstick&product_type=lipstick")
    Call<List<Lipstick>> getLipstickData();

    /*@GET("products?product_category=liquid&product_type=foundation")
    Call<List<Foundation>> getFoundationData();

    @GET("products?product_category=powder&product_type=blush")
    Call<List<Blush>> getBlushData();*/
}
