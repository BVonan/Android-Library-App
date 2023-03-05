package com.example.project2part3;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;


@Dao
public interface AccountDao {

    @Insert
    void addAccount(Account q);

    @Query("SELECT COUNT(*) FROM accountbank")
    int count();

    @Query("select * from accountbank")
    List<Account> getAll();

    @Query("select * from accountbank where id = :id")
    Account findById(int id);

    @Update
    void update(Account q);
}

