package com.dpoddubko.shopinglist.shoppings;

import com.dpoddubko.shopinglist.BasePresenter;
import com.dpoddubko.shopinglist.dao.Shopping;

interface Presenter extends BasePresenter<View> {

    void viewIsReady();

    void insert(Shopping... shoppings);

    void delete(Shopping shopping);

    void setCompleted(int id, boolean completed);

    void setAllAsCompleted(boolean completed);

}