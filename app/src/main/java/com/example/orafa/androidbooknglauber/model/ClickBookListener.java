package com.example.orafa.androidbooknglauber.model;

//Para fazer o if no onItemClick para ver se implementa esta interface // se foi será notificda
//E implementar no BookActivity
public interface ClickBookListener {
    void bookClicked(Book book);
}