package com.dpoddubko.shopinglist.app;

import com.dpoddubko.shopinglist.shoppings.ShoppingListActivity;
import com.dpoddubko.shopinglist.dao.AppDatabase;
import com.dpoddubko.shopinglist.shoppings.ShoppingListModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, ContextModule.class,ShoppingListModule.class})
public interface ApplicationComponent {

    AppDatabase database();

    void inject(ShoppingListActivity activity);
}
