package com.example.project2part3;

import android.content.Context;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TransactionDao {

    @Insert
    void addTransaction(Transaction q);

    @Query("SELECT COUNT(*) FROM transactionBank")
    int count();

    @Query("select * from transactionBank")
    List<Transaction> getAll();
}
