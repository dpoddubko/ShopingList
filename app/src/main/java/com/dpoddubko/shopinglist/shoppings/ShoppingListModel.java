package com.dpoddubko.shopinglist.shoppings;

import android.annotation.SuppressLint;

import com.dpoddubko.shopinglist.dao.AppDatabase;
import com.dpoddubko.shopinglist.dao.Shopping;

import java.util.List;

import io.reactivex.Flowable;

public class ShoppingListModel implements Model {

    private AppDatabase database;

    public ShoppingListModel(AppDatabase database) {
        this.database = database;
    }

    @SuppressLint("CheckResult")
    @Override
    public Flowable<List<Shopping>> getAllShopping(SelectionsMode mode) {
        //switch
        return database.getShoppingDao().getAllShopping();
    }

    @Override
    public void insertAll(Shopping... shoppings) {
        database.getShoppingDao().insertAll(shoppings);
    }

    @Override
    public void delete(Shopping shopping) {
        database.getShoppingDao().delete(shopping);
    }

    @Override
    public void setCompleted(int id, boolean completed) {
        database.getShoppingDao().setCompleted(id, completed);
    }

    @Override
    public void setAllAsCompleted(boolean completed) {
        database.getShoppingDao().setAllAsCompleted(completed);
    }

}
