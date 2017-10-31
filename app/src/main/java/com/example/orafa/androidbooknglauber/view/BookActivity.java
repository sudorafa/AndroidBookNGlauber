package com.example.orafa.androidbooknglauber.view;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.R;
import com.example.orafa.androidbooknglauber.model.ClickBookListener;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookActivity extends AppCompatActivity implements ClickBookListener {

    @BindView(R.id.viewPageListBook)
    ViewPager mViewPagerListBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);

        mViewPagerListBook.setAdapter(new BookPager(getSupportFragmentManager()));
    }

    class BookPager extends FragmentPagerAdapter {

        public BookPager(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new ListBookFragment();
            } else {
                return new ListBookFavoriteFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    @Override
    public void bookClicked(Book book) {
        if (getResources().getBoolean(R.bool.tablet)) {
            DetailBookFragment detailBookFragment = DetailBookFragment.newInstance(book);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detail, detailBookFragment, "detail")
                    .commit();
        } else if (getResources().getBoolean(R.bool.land)) {
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
