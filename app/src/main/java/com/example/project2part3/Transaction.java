package com.example.project2part3;

import androidx.room.ColumnInfo;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transactionBank")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String info;

    public Transaction(String info) {
        this.info = info;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return  info;
    }
}
