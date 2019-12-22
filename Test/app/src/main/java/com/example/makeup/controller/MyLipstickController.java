package com.example.makeup.controller;

import android.content.SharedPreferences;
import android.text.TextUtils;


import com.example.makeup.RestApiMakeUp;
import com.example.makeup.model.Lipstick;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyLipstickController {
    public HomeFragment view;
    private RestApiMakeUp response;
    private SharedPreferences sharedPreferences;

    public MyLipstickController(HomeFragment view, RestApiMakeUp response, SharedPreferences sharedPreferences) {
        this.view = view;
        this.response = response;
        this.sharedPreferences = sharedPreferences;
    }

    public void onCreate() {
        Call<List<Lipstick>> call = response.getLipstickData();
        call.enqueue(new Callback<List<Lipstick>>() {
            @Override
            public void onResponse(Call<List<Lipstick>> call, Response<List<Lipstick>> response) {
                List<Lipstick> restApiLipstick = response.body();
                List<Lipstick> lipstickList = restApiLipstick;
                view.showList(lipstickList);
            }

            @Override
            public void onFailure(Call<List<Lipstick>> call, Throwable t) {

            }

            private void storeData(List<Lipstick> lipstickList) {
                Gson gson = new Gson();
                String listMU = gson.toJson(lipstickList);
                sharedPreferences
                        .edit()
                        .putString("mu_string", listMU)
                        .apply();
            }

            private List<Lipstick> getDataFromCache() {
                String listMUString = sharedPreferences.getString("mu_string", "");
                if(listMUString != null && !TextUtils.isEmpty(listMUString)){
                    Type listType = new TypeToken<List<Lipstick>>(){}.getType();
                    List<Lipstick> lipstickList = new Gson().fromJson(listMUString, listType);
                    return lipstickList;
                }
                return new ArrayList<>();
            }
        });
    }
}