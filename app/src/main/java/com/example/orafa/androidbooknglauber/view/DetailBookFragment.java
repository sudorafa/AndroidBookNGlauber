package com.example.orafa.androidbooknglauber.view;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orafa.androidbooknglauber.model.Book;
import com.example.orafa.androidbooknglauber.R;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DetailBookFragment extends Fragment {

    private static final String EXTRA_BOOK = "param1";

    @BindView(R.id.textViewBook)
    TextView textViewBook;

    private Book mBook;

    public DetailBookFragment() {
        // Required empty public constructor
    }

    public static DetailBookFragment newInstance(Book book) {
        DetailBookFragment fragment = new DetailBookFragment();
        Bundle args = new Bundle();
        Parcelable p = Parcels.wrap(book);
        args.putParcelable(EXTRA_BOOK, p);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Parcelable p = getArguments().getParcelable(EXTRA_BOOK);
            mBook = Parcels.unwrap(p);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_detail_book, container, false);

        ButterKnife.bind(this, view);
        textViewBook.setText(mBook.toString());

        return view;
    }

    @OnClick(R.id.buttonTestKnife)
    public void myButtonTest(){
        Toast.makeText(getContext(), "Que massa papai", Toast.LENGTH_SHORT).show();
    }
}
