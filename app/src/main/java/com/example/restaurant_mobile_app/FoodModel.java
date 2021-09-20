package com.example.restaurant_mobile_app;

public class FoodModel {

    int Image_id;
    String name;
    String price;

    public FoodModel(int image_id, String name, String price) {
        Image_id = image_id;
        this.name = name;
        this.price = price;
    }

    public int getImage_id() {
        return Image_id;
    }

    public void setImage_id(int image_id) {
        Image_id = image_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price= price;
    }


}
