package com.codeguy.myallcomponent.models;

import com.codeguy.myallcomponent.activity.recyclerviewdemo.RecyclerViewItem;

//Object of food item
public class FoodItem extends RecyclerViewItem {
    private String title;
    private String description;
    private String imageUrl;
    private String price;
    private boolean isHot = false;

    public FoodItem(String title, String description, String imageUrl, String price, boolean isHot) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.isHot = isHot;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }
}