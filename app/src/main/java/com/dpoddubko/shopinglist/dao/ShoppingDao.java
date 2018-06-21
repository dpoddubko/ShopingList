package com.dpoddubko.shopinglist.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface ShoppingDao {

    @Insert
    void insertAll(Shopping... shoppings);

    @Delete
    void delete(Shopping shopping);

    @Query("SELECT * FROM shopping")
    Flowable<List<Shopping>> getAllShopping();

    @Query("SELECT * FROM shopping WHERE completed = :isCompleted")
    Flowable<List<Shopping>> getAllShoppingByCompletion(boolean isCompleted);

    @Query("UPDATE shopping SET completed = :completed WHERE id = :id")
    void setCompleted(int id, boolean completed);

    @Query("UPDATE shopping SET completed = :completed")
    void setAllAsCompleted(boolean completed);
}
