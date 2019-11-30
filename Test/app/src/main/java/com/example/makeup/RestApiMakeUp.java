package com.example.makeup;


import com.example.makeup.model.Blush;
import com.example.makeup.model.Foundation;
import com.example.makeup.model.Lipstick;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiMakeUp {
    @GET("products.json?product_category=lipstick&product_type=lipstick")
    Call<List<Lipstick>> getLipstickData();
    @GET("products.json?product_category=concealer&product_type=foundation")
    Call<List<Foundation>> getFoundationData();
    @GET("products.json?product_category=powder&product_type=blush")
    Call<List<Blush>> getBlushData();
}
