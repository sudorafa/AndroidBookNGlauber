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

public class ListBookFragment extends Fragment {

    @BindView(R.id.swipeRefreshLayoutListViewBook)
    SwipeRefreshLayout mSwipeRefreshLayoutListViewBook;

    @BindView(R.id.listViewBook)
    ListView mListViewBook;

    List<Book> mBooks;
    ArrayAdapter<Book> mAdapterBooks;

    BooksTask mTask;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //para não distruir a instancia do fragment (Evitar carregar o json)
        //a view do fragment morre, mas o fragment em si não
        // aí os atrigutos serão mantidos
        //oncreate e onstart/resume que são chamados
        setRetainInstance(true);

        //para inicializar apenas uma vez. Já que o create só carrega de prima
        mBooks = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_list_book, container, false);
        ButterKnife.bind(this, layout);

        mAdapterBooks = new BooksAdapter(getContext(), mBooks);
        mListViewBook.setAdapter(mAdapterBooks);

        mSwipeRefreshLayoutListViewBook.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mTask = new BooksTask();
                mTask.execute();
            }
        });

        return layout;
    }

    //testar json
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //só carregar se tiver elemento na list
        if (mBooks.size() == 0 && mTask == null) {
            mTask = new BooksTask();
            mTask.execute();
        } else if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            mSwipeRefreshLayoutListViewBook.setRefreshing(true);
        }
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
        protected void onPreExecute() {
            super.onPreExecute();
            mSwipeRefreshLayoutListViewBook.setRefreshing(true);
        }

        @Override
        protected Editor doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url("https://raw.githubusercontent.com/nglauber/dominando_android/master/livros_novatec.json")
                    .build();
            try {
                Thread.sleep(5000);
                Response response = client.newCall(request).execute();
                String jsonString = response.body().string();
                Log.d("testarJSON", jsonString);
                Gson gson = new Gson();
                Editor editor = gson.fromJson(jsonString, Editor.class);
                return editor;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Editor editor) {
            super.onPostExecute(editor);
            if (editor != null) {
                mBooks.clear();
                for (Category category : editor.getCategories()) {
                    mBooks.addAll(category.getBooks());
                }
                mAdapterBooks.notifyDataSetChanged();
            }
            mSwipeRefreshLayoutListViewBook.setRefreshing(false);
        }
    }
}
