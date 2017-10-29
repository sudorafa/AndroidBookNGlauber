package com.example.orafa.androidbooknglauber.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by o Rafa on 26/10/2017.
 */

public class Editor {

    @SerializedName("novatec")
    List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
