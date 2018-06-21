package com.dpoddubko.shopinglist.shoppings;

import com.dpoddubko.shopinglist.dao.Shopping;

import java.util.List;

import io.reactivex.Flowable;

interface Model {

    Flowable<List<Shopping>> getAllShopping(SelectionsMode mode);

    void insertAll(Shopping... shoppings);

    void delete(Shopping shopping);

    void setCompleted(int id, boolean completed);

    void setAllAsCompleted(boolean completed);
}
