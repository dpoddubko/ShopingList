package com.dpoddubko.shopinglist.shoppings;

import com.dpoddubko.shopinglist.dao.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
@Module
public class ShoppingListModule {
    @Provides
    @Singleton
    public ShoppingListModel model(AppDatabase database) {
        return new ShoppingListModel(database);
    }

    @Provides
    @Singleton
    public ShoppingListPresenter presenter(ShoppingListModel model) {
        return new ShoppingListPresenter(model);
    }
}
