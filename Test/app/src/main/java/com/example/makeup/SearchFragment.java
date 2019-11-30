package com.example.makeup;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.makeup.controller.MyFoundationController;
import com.example.makeup.model.Foundation;
import com.example.makeup.view.AdapterFoundation;
import com.example.test.R;

import java.util.List;


public class SearchFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        MyFoundationController controller = new MyFoundationController(this, Injection.getRestApi(), sharedPreferences);
        controller.onCreate();

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void showList(List<Foundation> foundationList) {
        //Initialisation de la variable recyclerView
        recyclerView = (RecyclerView) getView().findViewById(R.id.my_recycler_view);
        //Optimisation des performances
        recyclerView.setHasFixedSize(true);
        // Layout Manager = Manage l'affichage
        //Initialisation de la variable layoutManager
        layoutManager = new LinearLayoutManager(getContext());

        recyclerView.setLayoutManager(layoutManager);

        //Initialisation de la variable mAdapter
        mAdapter = new AdapterFoundation(foundationList);
        recyclerView.setAdapter(mAdapter);
    }

}