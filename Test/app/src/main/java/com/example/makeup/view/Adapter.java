package com.example.makeup.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.makeup.model.Lipstick;
import com.example.test.R;


import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Lipstick> values;
    private MainActivity mainActivity;
    private int position;

    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView img;
        public View layout;

        public ViewHolder(View view) {
            super(view);
            layout = view;
            txtHeader = (TextView) view.findViewById(R.id.firstLine);
            txtFooter = (TextView) view.findViewById(R.id.secondLine);
            img = (ImageView)view.findViewById((R.id.icon));
            //values = makeUpList;

            itemView.setOnClickListener(v -> {
                Intent newIntent = new Intent(v.getContext(), SecondActivity.class);
                newIntent.putExtra("Lipstick", values.get(getAdapterPosition()));
                v.getContext().startActivity(newIntent);
            });

        }

        /*public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), HomeFragment.class);
            intent.putExtra("Lipstick", values.get(getAdapterPosition()));
            v.getContext().startActivity(intent);
        }*/
    }

    public void add(int position, Lipstick item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }




    private static final String SelectedMakeUp = "selected_MakeUp";
    public void infoDisplay(int position){
        Log.d("position", String.valueOf(position));
        // Create an Intent to start the second activity
        Intent infoIntent = new Intent(mainActivity, SecondActivity.class);
        final Lipstick selectedLipstick = values.get(position);
        ArrayList<String> MakeUp= new ArrayList<>() ;
        MakeUp.add(selectedLipstick.getBrand());
        MakeUp.add(selectedLipstick.getName());
        MakeUp.add(selectedLipstick.getPrice());
        MakeUp.add(selectedLipstick.getPrice_sign());
        MakeUp.add(selectedLipstick.getDescription());
        infoIntent.putStringArrayListExtra(SelectedMakeUp,MakeUp);
// Start the new activity.
        mainActivity.startActivity(infoIntent);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Adapter(List<Lipstick> values) {
        this.values = values;
        this.mainActivity = mainActivity;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        this.position = position;

        Lipstick mu = values.get(position);


        holder.txtHeader.setText(mu.getName());
        if (mu.getBrand().matches("")) {
            holder.txtFooter.setText( mu.getBrand());
        }
        else {
            holder.txtFooter.setText(mu.getBrand().toUpperCase());
        }
        Log.d("URL", String.valueOf(position));
        Glide.with(holder.itemView).load(mu.getImage_link()).into(holder.img);
    }

    // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return values.size();
    }


}