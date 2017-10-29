package com.example.orafa.androidbooknglauber.model;

import android.content.Context;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orafa.androidbooknglauber.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by o Rafa on 29/10/2017.
 */

public class BooksAdapter extends ArrayAdapter<Book> {

    @BindView(R.id.imageViewCover)
    ImageView imageViewCover;

    @BindView(R.id.textViewTitle)
    TextView textViewTitle;

    @BindView(R.id.textViewAuthor)
    TextView textViewAuthor;

    public BooksAdapter(@NonNull Context context, List<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book book = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, null);
        }

        ButterKnife.bind(this, convertView);

        textViewTitle.setText(book.getTitle());
        textViewAuthor.setText(book.getAuthor());


        return convertView;
    }
}
