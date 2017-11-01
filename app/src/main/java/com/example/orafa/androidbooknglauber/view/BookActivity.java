package com.example.orafa.androidbooknglauber.view;
import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.R;
import com.example.orafa.androidbooknglauber.model.ClickBookListener;

import org.parceler.Parcels;

import butterknife.BindDimen;
import butterknife.BindView;
import butterknife.ButterKnife;

public class BookActivity extends AppCompatActivity implements ClickBookListener {

    @BindView(R.id.viewPageListBook)
    ViewPager mViewPagerListBook;

    @BindView(R.id.tabLayout)
    TabLayout mTabLayout;

    @BindView(R.id.toolBar)
    Toolbar mtoolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        ButterKnife.bind(this);

        setSupportActionBar(mtoolBar);

        mViewPagerListBook.setAdapter(new BookPager(getSupportFragmentManager()));
        mTabLayout.setupWithViewPager(mViewPagerListBook);
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

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0) {
                return getString(R.string.abaWeb);
            } else {
                return getString(R.string.favorite);
            }
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
