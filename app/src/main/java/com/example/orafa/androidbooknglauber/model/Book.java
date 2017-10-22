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

    @Override
    public String toString() {
        return title + " - " + author;
    }
}
