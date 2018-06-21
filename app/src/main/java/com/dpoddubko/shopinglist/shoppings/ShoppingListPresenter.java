package com.dpoddubko.shopinglist.shoppings;

import android.annotation.SuppressLint;

import com.dpoddubko.shopinglist.dao.Shopping;

import io.reactivex.Completable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ShoppingListPresenter implements Presenter {

    private ShoppingListModel model;
    private View view;

    public ShoppingListPresenter(ShoppingListModel model) {
        this.model = model;
    }


    @Override
    public void viewIsReady() {
        loadList();
    }

    @SuppressLint("CheckResult")
    private void loadList() {
        model.getAllShopping(SelectionsMode.ALL)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(view::showList, t -> {
                    view.showError(t);
                });

    }

    @Override
    public void attachView(View view) {
        this.view = view;
    }

    @Override
    public void destroy() {
        this.view = null;
    }

    @SuppressLint("CheckResult")
    @Override
    public void insert(Shopping... shoppings) {
        Completable.fromAction(() -> model.insertAll(shoppings))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(
                this::loadList, t -> view.showError(t));
    }

    @SuppressLint("CheckResult")
    @Override
    public void delete(Shopping shopping) {
        Completable.fromAction(() -> model.delete(shopping))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(
                this::loadList, t -> view.showError(t));

    }

    @SuppressLint("CheckResult")
    @Override
    public void setCompleted(int id, boolean completed) {
        Completable.fromAction(() -> model.setCompleted(id, completed))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(
                this::loadList, t -> view.showError(t));
    }

    @SuppressLint("CheckResult")
    @Override
    public void setAllAsCompleted(boolean completed) {
        Completable.fromAction(() -> model.setAllAsCompleted(completed))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(
                this::loadList, t -> view.showError(t));
    }

}
