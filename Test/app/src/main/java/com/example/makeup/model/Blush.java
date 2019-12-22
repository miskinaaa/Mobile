package com.example.makeup.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Blush implements Serializable  {
    @SerializedName("id")
    private String id;

    @SerializedName("brand")
    private String brand;

    @SerializedName("name")
    private String name;

    @SerializedName("image_link")
    private String image_link;

    private String price;
    private String price_sign;
    private String description;

    public String getId() {
        return id;
    }
    public String getBrand() {
        return brand;
    }
    public String getName(){
        return name;
    }
    public String getImage_link() {
        return image_link;
    }
    public String getPrice() {
        return price;
    }
    public String getPrice_sign() {
        return price_sign;
    }
    public String getDescription() {
        return description;
    }

}
