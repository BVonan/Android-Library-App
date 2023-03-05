package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.List;



import com.example.project2part3.databinding.GenreBinding;

@Entity(tableName = "BookBank")
public class Books  {
//    private GenreBinding binding;
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo
    private String title;

    @ColumnInfo
    private String author;

    @ColumnInfo
    private String genre;

    public Books(String title,String author,String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;

        Log.d("Book", "Book made");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
            return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        return title + "/n" + author;
    }
//
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//        binding = GenreBinding.inflate(getLayoutInflater());
////        setContentView(binding.getRoot());
////        binding.compSci.setOnClickListener(v -> {
////            Intent cs = new Intent(Books.this, AccountManageInfo.class);
////            startActivity(cs);
////        });
////        binding.fiction.setOnClickListener(v -> {
////            Intent f = new Intent(Books.this, AccountManageInfo.class);
////            startActivity(f);
//        });
//    }
//
//    private ListView booksListView;
//    //    private ArrayAdapter<csbooks> accountAdapter;
//
////
////
//        private Books binding;
//        private ListView csbooksListView;
//        //    private ArrayAdapter<books> accountAdapter;
//        private List<com.example.project2part3.Books> BooksList;
//        private com.example.project2part3.Books selectedQ;
//
//        public com.example.project2part3.Books getSelectedQ() {
//            return selectedQ;
//        }
//
//        public void setSelectedQ(com.example.project2part3.Books selectedQ) {
//            this.selectedQ = selectedQ;
//        }
////
////        protected void onCreate(Bundle savedInstanceState) {
////            super.onCreate(savedInstanceState);
////
////
////            csbooksListView.setOnItemClickListener((parent, view, position, id) -> {
////
////                com.example.project2part3.CSBooks q = (com.example.project2part3.CSBooks) csbooksListView.getItemAtPosition(position);
////
////                if (q != null) {
////                    this.setSelectedQ(q);
////                }
////                int qPrimaryKey = q.getId();
////            });
////        }
    }







