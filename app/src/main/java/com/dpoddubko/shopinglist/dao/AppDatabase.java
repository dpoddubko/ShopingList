package com.dpoddubko.shopinglist.dao;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Shopping.class }, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ShoppingDao getShoppingDao();
}