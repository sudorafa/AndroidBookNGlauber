package com.example.orafa.androidbooknglauber.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by o Rafa on 26/10/2017.
 */

public class Category {

    @SerializedName("nome")
    String name;

    @SerializedName("livros")
    List<Book> books;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
