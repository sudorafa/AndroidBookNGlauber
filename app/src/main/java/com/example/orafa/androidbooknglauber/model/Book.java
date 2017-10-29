package com.example.orafa.androidbooknglauber.model;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by oRafa on 22/10/2017.
 */

@Parcel
public class Book{

    @SerializedName("titulo")
    String title;
    @SerializedName("autor")
    String author;
    @SerializedName("ano")
    int year;
    @SerializedName("paginas")
    int pages;
    @SerializedName("capa")
    String cover;

    @ParcelConstructor
    public Book(String title, String author, int year, int pages, String cover) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.pages = pages;
        this.cover = cover;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Override
    public String toString() {
        return title + " - " + author;
    }
}
