package com.example.orafa.androidbooknglauber.view;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.orafa.androidbooknglauber.R;
import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.model.Editor;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ListBookFragment extends Fragment {

    @BindView(R.id.listViewBook)
    ListView mListViewBook;

    List<Book> mBooks;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_list_book, container, false);
        ButterKnife.bind(this, layout);

        mBooks = new ArrayList<>();
        mListViewBook.setAdapter(new ArrayAdapter<Book>(getActivity(), android.R.layout.simple_list_item_1, mBooks));

        return layout;
    }

    //testar json
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new BooksTask().execute();
    }

    @OnItemClick(R.id.listViewBook)
    public void itemSelectedBook(int position) {
        Book book = mBooks.get(position);
        if (getActivity() instanceof ClickBookListener) {
            ClickBookListener listener = (ClickBookListener) getActivity();
            listener.bookClicked(book);
        }
    }

    //Para fazer o if no onItemClick para ver se implementa esta interface // se foi será notificda
    //E implementar no BookActivity
    public interface ClickBookListener {
        void bookClicked(Book book);
    }

    class BooksTask extends AsyncTask<Void, Void, Editor> {
        @Override
        protected Editor doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://raw.githubusercontent.com/nglauber/dominando_android/master/livros_novatec.json")
                    .build();
            try{
                Response response = client.newCall(request).execute();
                String jsonString = response.body().string();
                Log.d("testarJSON", jsonString);
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
    }
}
