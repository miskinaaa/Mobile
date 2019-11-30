package com.example.makeup.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.makeup.model.Foundation;
import com.example.makeup.model.Lipstick;
import com.example.test.R;
import com.squareup.picasso.Picasso;

public class SecondActivityFoundation extends AppCompatActivity {

    private static final String selection = "selection_label";

    private TextView brand;
    private TextView name;
    private TextView price;
    private TextView price_sign;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

       Foundation fd = (Foundation) getIntent().getSerializableExtra("Foundation");


        description = findViewById(R.id.desc);
        brand = findViewById(R.id.brand);
        name = findViewById(R.id.titre);
        price = findViewById(R.id.prix);
        price_sign = findViewById(R.id.prix_b);
        ImageView image_link = findViewById(R.id.imageView);
        Picasso.get().load(fd.getImage_link()).into(image_link);

        description.setText(fd.getDescription());
        brand.setText(fd.getBrand());
        name.setText(fd.getName());
        price.setText(fd.getPrice());
        price_sign.setText(fd.getPrice_sign());


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}