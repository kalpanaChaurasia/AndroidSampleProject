package com.codeguy.myallcomponent.models;

import com.codeguy.myallcomponent.activity.recyclerviewdemo.RecyclerViewItem;

/**
 * Created by amary on 25-03-2018.
 */
//Object of Header item
public class Header extends RecyclerViewItem {
    private String HeaderText;
    private String Category;
    private String ImageUrl;

    public Header(String headerText, String category, String imageUrl) {
        HeaderText = headerText;
        Category = category;
        ImageUrl = imageUrl;
    }

    public String getHeaderText() {
        return HeaderText;
    }

    public void setHeaderText(String headerText) {
        HeaderText = headerText;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
}