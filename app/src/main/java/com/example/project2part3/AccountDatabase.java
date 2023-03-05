package com.example.project2part3;

import android.content.Context;

import androidx.room.Database;


import android.content.Context;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Account.class, Books.class, Transaction.class}, version=12, exportSchema = false)
public abstract class AccountDatabase extends RoomDatabase {

    private static AccountDatabase sInstance;
    public abstract AccountDao account();
    public abstract BooksDao book();
    public abstract TransactionDao transaction();
    public static synchronized AccountDatabase getInstance(Context context) {

        if (sInstance == null) {
            sInstance = Room.databaseBuilder(context.getApplicationContext(),
                            AccountDatabase.class, "account.db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return sInstance;

    }

    public void populateInitialData() {
        runInTransaction(() -> {

            if (account().count() == 0) {
                account().addAccount(new Account("shirleybee", "carmel2chicago"));
                account().addAccount(new Account("bernie", "thyr01dExp3rt"));
            }
            if (book().count() == 0){
                book().addBooks(new Books("Strengthening Deep Neural Networks", "Avner Ross", "Computer Science"));
                book().addBooks(new Books("Frankenstein", "Avner StienBerg", "Fiction"));
                book().addBooks(new Books("Angelas Ashes", "Avner Walter Heisenberg White", "Memoir"));


            }
        });
    }
}