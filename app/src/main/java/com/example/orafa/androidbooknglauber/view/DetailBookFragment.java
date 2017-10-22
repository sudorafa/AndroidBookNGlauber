package com.example.orafa.androidbooknglauber.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.R;

public class DetailBookFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String EXTRA_BOOK = "param1";

    // TODO: Rename and change types of parameters
    private Book mBook;
    ViewHolder mViewHolder = new ViewHolder();

    public DetailBookFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static DetailBookFragment newInstance(Book livro) {
        DetailBookFragment fragment = new DetailBookFragment();
        Bundle args = new Bundle();
        args.putParcelable(EXTRA_BOOK, livro);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mBook = getArguments().getParcelable(EXTRA_BOOK);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detail_book, container, false);

        this.mViewHolder.textViewBook = (TextView)view.findViewById(R.id.textViewBook);
        this.mViewHolder.textViewBook.setText(mBook.toString());

        return view;
    }

    private static class ViewHolder {
        TextView textViewBook;
    }

}
