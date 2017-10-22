package com.example.orafa.androidbooknglauber.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.R;

public class BookActivity extends AppCompatActivity implements ListBookFragment.ClickBookListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
    }

    @Override
    public void bookClicked(Book book) {
        DetailBookFragment detailBookFragment = DetailBookFragment.newInstance(book);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detail, detailBookFragment, "detail")
                .commit();
    }
}
