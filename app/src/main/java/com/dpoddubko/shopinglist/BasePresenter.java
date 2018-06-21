package com.dpoddubko.shopinglist;

public interface BasePresenter<V> {

    void attachView(V view);

    void destroy();

}
