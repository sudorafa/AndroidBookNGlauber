package com.example.orafa.androidbooknglauber.model;

import java.util.List;

/**
 * Created by o Rafa on 26/10/2017.
 */

public class Category {
    String name;
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
