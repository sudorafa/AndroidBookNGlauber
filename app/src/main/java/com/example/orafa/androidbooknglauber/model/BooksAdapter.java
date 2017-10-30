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
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by o Rafa on 29/10/2017.
 */

public class BooksAdapter extends ArrayAdapter<Book> {

    public BooksAdapter(@NonNull Context context, List<Book> books) {
        super(context, 0, books);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book book = getItem(position);

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_book, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ButterKnife.bind(this, convertView);

        Picasso.with(getContext()).load(book.getCover()).into(viewHolder.imageViewCover);
        viewHolder.textViewTitle.setText(book.getTitle());
        viewHolder.textViewAuthor.setText(book.getAuthor());

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.imageViewCover)
        ImageView imageViewCover;
        @BindView(R.id.textViewTitle)
        TextView textViewTitle;
        @BindView(R.id.textViewAuthor)
        TextView textViewAuthor;

        public ViewHolder(View parent) {
            ButterKnife.bind(this, parent);
            parent.setTag(this);
        }
    }
}
