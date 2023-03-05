package com.example.project2part3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.project2part3.databinding.ActivityAddBookBinding;
import com.example.project2part3.databinding.AdminLoginBinding;

public class AddBook extends AppCompatActivity {

    private ActivityAddBookBinding binding;
    private AccountDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = AccountDatabase.getInstance(this);
        binding.addBook.setOnClickListener(v->{
            String title = String.valueOf(binding.title.getText());
            String author = String.valueOf(binding.author.getText());
            String genre = String.valueOf(binding.genre.getText());
            Books b = new Books(title, author, genre);
            db.book().addBooks(b);
            Toast.makeText(this, "BOOK Added", Toast.LENGTH_LONG).show();
            AddBook.this.finish();
        });

    }
}