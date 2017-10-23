package com.example.orafa.androidbooknglauber.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import butterknife.OnItemSelected;

public class ListBookFragment extends Fragment {

    @BindView(R.id.listViewBook)
    ListView mListViewBook;

    List<Book> mBooks;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBooks = new ArrayList<>();

        mBooks.add(new Book("Título do Livro 1", "Ator do Livro 1"));
        mBooks.add(new Book("Título do Livro 2", "Ator do Livro 2"));
        mBooks.add(new Book("Título do Livro 3", "Ator do Livro 3"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_list_book, container, false);
        ButterKnife.bind(this, layout);

        mListViewBook.setAdapter(new ArrayAdapter<Book>(getActivity(), android.R.layout.simple_list_item_1, mBooks));

        return layout;
    }

    @OnItemSelected(R.id.listViewBook)
    public void itemSelectedBook(int position){
        Book book = mBooks.get(position);
        if(getActivity() instanceof ClickBookListener){
            ClickBookListener listener = (ClickBookListener)getActivity();
            listener.bookClicked(book);
        }
    }

    //Para fazer o if no onItemClick para ver se implementa esta interface // se foi será notificda
    //E implementar no BookActivity
    public interface ClickBookListener{
        void bookClicked(Book book);
    }

}
