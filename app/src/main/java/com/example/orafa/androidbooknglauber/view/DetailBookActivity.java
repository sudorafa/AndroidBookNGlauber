package com.example.orafa.androidbooknglauber.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orafa.androidbooknglauber.R;
import com.example.orafa.androidbooknglauber.model.Book;

import org.parceler.Parcels;

public class DetailBookActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK = "book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);

        Book book = Parcels.unwrap(getIntent().getParcelableExtra(EXTRA_BOOK));

        DetailBookFragment detailBookFragment = DetailBookFragment.newInstance(book);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.detail, detailBookFragment, "detail")
                .commit();
    }
}
