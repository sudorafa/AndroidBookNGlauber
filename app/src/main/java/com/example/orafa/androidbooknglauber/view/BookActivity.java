package com.example.orafa.androidbooknglauber.view;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.R;

import org.parceler.Parcels;

public class BookActivity extends AppCompatActivity implements ListBookFragment.ClickBookListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }

    @Override
    public void bookClicked(Book book) {
        if (getResources().getBoolean(R.bool.tablet)) {
            DetailBookFragment detailBookFragment = DetailBookFragment.newInstance(book);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detail, detailBookFragment, "detail")
                    .commit();
        } else {
            Intent intent = new Intent(this, DetailBookActivity.class);
            Parcelable parcelable = Parcels.wrap(book);
            intent.putExtra(DetailBookActivity.EXTRA_BOOK, parcelable);
            startActivity(intent);
        }
    }
}
