package com.example.project2part3;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;


@Dao
public interface BooksDao {

    @Insert
    void addBooks(Books q);

    @Query("SELECT COUNT(*) FROM BookBank")
    int count();

    @Query("select * from BookBank")
    List<Books> getAll();

    @Query("select * from Bookbank where genre = :genre")
    Books findBygenre(String genre);

    @Query("select * from Bookbank where title = :title")
    Books findBytitle(String title);

    @Update
    void update(Books q);

    @Delete
    void delete(Books q);


}

