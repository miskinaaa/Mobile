package com.example.makeup.controller;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.makeup.Injection;
import com.example.makeup.controller.MyBlushController;
import com.example.makeup.model.Blush;
import com.example.makeup.view.AdapterBlush;
import com.example.test.R;

import java.util.List;


public class FavoritesFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        MyBlushController controller = new MyBlushController(this, Injection.getRestApi(), sharedPreferences);
        controller.onCreate();

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void showList(List<Blush> blushList) {
        //Initialisation de la variable recyclerView
        recyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        //Optimisation des performances
        recyclerView.setHasFixedSize(true);
        // Layout Manager = Manage l'affichage
        //Initialisation de la variable layoutManager
        layoutManager = new LinearLayoutManager(getContext());

        //recyclerView.setLayoutManager(layoutManager);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        //Initialisation de la variable mAdapter
        mAdapter = new AdapterBlush(blushList);
        recyclerView.setAdapter(mAdapter);
    }

}