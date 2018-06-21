package com.dpoddubko.shopinglist.app;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.dpoddubko.shopinglist.shoppings.ShoppingAdapter;
import com.dpoddubko.shopinglist.shoppings.ShoppingListModel;
import com.dpoddubko.shopinglist.shoppings.ShoppingListPresenter;
import com.dpoddubko.shopinglist.dao.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ContextModule.class})
public class AppModule {

    @Provides
    @Singleton
    public AppDatabase database(Context context) {
        return Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, "shopping-database")
                .build();
    }
}