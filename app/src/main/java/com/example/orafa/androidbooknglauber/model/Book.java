package com.example.orafa.androidbooknglauber.model;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by oRafa on 22/10/2017.
 */

@Parcel
public class Book{

    String title;
    String author;

    @ParcelConstructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return title + " - " + author;
    }
}
