package com.dpoddubko.shopinglist.shoppings;

import com.dpoddubko.shopinglist.BaseView;
import com.dpoddubko.shopinglist.dao.Shopping;

import java.util.List;

interface View extends BaseView<Presenter> {

    void showList(List<Shopping> shoppings);

    void showError(Throwable t);
}
