package com.example.makeup.controller;

import android.content.SharedPreferences;
import android.text.TextUtils;


import com.example.makeup.RestApiMakeUp;
import com.example.makeup.SearchFragment;
import com.example.makeup.model.Foundation;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyFoundationController {
    public SearchFragment view;
    private RestApiMakeUp response;
    private SharedPreferences sharedPreferences;

    public MyFoundationController(SearchFragment view, RestApiMakeUp response, SharedPreferences sharedPreferences) {
        this.view = view;
        this.response = response;
        this.sharedPreferences = sharedPreferences;
    }

    public void onCreate() {
        Call<List<Foundation>> call = response.getFoundationData();
        call.enqueue(new Callback<List<Foundation>>() {
            @Override
            public void onResponse(Call<List<Foundation>> call, Response<List<Foundation>> response) {
                List<Foundation> restApiFoundation = response.body();
                List<Foundation> foundationList = restApiFoundation;
                view.showList(foundationList);
            }

            @Override
            public void onFailure(Call<List<Foundation>> call, Throwable t) {

            }

            private void storeData(List<Foundation> foundationList) {
                Gson gson = new Gson();
                String listMU = gson.toJson(foundationList);
                sharedPreferences
                        .edit()
                        .putString("mu_string", listMU)
                        .apply();
            }

            private List<Foundation> getDataFromCache() {
                String listMUString = sharedPreferences.getString("mu_string", "");
                if(listMUString != null && !TextUtils.isEmpty(listMUString)){
                    Type listType = new TypeToken<List<Foundation>>(){}.getType();
                    List<Foundation> foundationList = new Gson().fromJson(listMUString, listType);
                    return foundationList;
                }
                return new ArrayList<>();
            }
        });
    }
}
