package com.example.makeup.controller;

import android.content.SharedPreferences;
import android.text.TextUtils;


import com.example.makeup.RestApiMakeUp;
import com.example.makeup.model.Blush;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBlushController {
    public FavoritesFragment view;
    private RestApiMakeUp response;
    private SharedPreferences sharedPreferences;

    public MyBlushController(FavoritesFragment view, RestApiMakeUp response, SharedPreferences sharedPreferences) {
        this.view = view;
        this.response = response;
        this.sharedPreferences = sharedPreferences;
    }

    public void onCreate() {
        Call<List<Blush>> call = response.getBlushData();
        call.enqueue(new Callback<List<Blush>>() {
            @Override
            public void onResponse(Call<List<Blush>> call, Response<List<Blush>> response) {
                List<Blush> restApiBlush = response.body();
                List<Blush> blushList = restApiBlush;
                view.showList(blushList);
            }

            @Override
            public void onFailure(Call<List<Blush>> call, Throwable t) {

            }

            private void storeData(List<Blush> blushList) {
                Gson gson = new Gson();
                String listMU = gson.toJson(blushList);
                sharedPreferences
                        .edit()
                        .putString("mu_string", listMU)
                        .apply();
            }

            private List<Blush> getDataFromCache() {
                String listMUString = sharedPreferences.getString("mu_string", "");
                if(listMUString != null && !TextUtils.isEmpty(listMUString)){
                    Type listType = new TypeToken<List<Blush>>(){}.getType();
                    List<Blush> blushList = new Gson().fromJson(listMUString, listType);
                    return blushList;
                }
                return new ArrayList<>();
            }
        });
    }
}