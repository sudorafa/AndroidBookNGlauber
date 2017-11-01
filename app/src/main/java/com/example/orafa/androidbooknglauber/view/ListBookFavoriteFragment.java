package com.example.orafa.androidbooknglauber.view;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.orafa.androidbooknglauber.R;
import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.model.BooksAdapter;
import com.example.orafa.androidbooknglauber.model.Category;
import com.example.orafa.androidbooknglauber.model.ClickBookListener;
import com.example.orafa.androidbooknglauber.model.Editor;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListBookFavoriteFragment extends Fragment {

    @BindView(R.id.listViewBook)
    ListView mListViewBook;

    List<Book> mBooks;
    ArrayAdapter<Book> mAdapterBooks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

        mBooks = new ArrayList<>();

        mBooks.add(new Book("Titulo do Livro Favorito 1", "Autor do Livro Favorito 1", 2017, 25, "capa"));
        mBooks.add(new Book("Titulo do Livro Favorito 2", "Autor do Livro Favorito 2", 2017, 25, "capa"));
        mBooks.add(new Book("Titulo do Livro Favorito 3", "Autor do Livro Favorito 3", 2017, 25, "capa"));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_list_book_favorite, container, false);
        ButterKnife.bind(this, layout);

        mAdapterBooks = new BooksAdapter(getContext(), mBooks);
        mListViewBook.setAdapter(mAdapterBooks);

        return layout;
    }

    @OnItemClick(R.id.listViewBook)
    public void itemSelectedBook(int position) {
        Book book = mBooks.get(position);
        if (getActivity() instanceof ClickBookListener) {
            ClickBookListener listener = (ClickBookListener) getActivity();
            listener.bookClicked(book);
        }
    }
}
