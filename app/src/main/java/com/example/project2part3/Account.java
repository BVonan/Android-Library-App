package com.example.project2part3;


import android.util.Log;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "AccountBank")
public class Account {

//    public String getAccount() {
//        return account;
//    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String username;

    @ColumnInfo
    private String password;

    public Account(String username,String password) {
        this.username = username;
        this.password = password;

        Log.d("Account", "created account");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String passowrd) {
        this.password = passowrd;
    }

        @Override
    public String toString() {
        return username ;
    }


}
