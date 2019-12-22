package com.example.makeup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    private static RestApiMakeUp restApiMakeUp;
    private static final String BASE_URL = "https://makeup-api.herokuapp.com/api/v1/";

    //Singleton
    public static RestApiMakeUp getRestApi(){
        if(restApiMakeUp == null){
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            restApiMakeUp = retrofit.create(RestApiMakeUp.class);
        }
        return restApiMakeUp;
    }
}
