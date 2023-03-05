package com.example.project2part3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.project2part3.databinding.ActivityPlaceHoldBinding;
import com.example.project2part3.databinding.AdminLoginBinding;
import com.google.android.material.transition.Hold;

//import com.example.project2part3.databinding.GenreBinding;

public class PlaceHold extends AppCompatActivity {

    private ActivityPlaceHoldBinding binding;
    private AccountDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_hold);
        db = AccountDatabase.getInstance(this);

        binding = ActivityPlaceHoldBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.compSci.setOnClickListener(v -> {
            Books b = db.book().findBygenre("Computer Science" );
            Intent cs = new Intent(PlaceHold.this, BooksManage.class);
            Bundle extraInfo = new Bundle();
            if (b != null){
                extraInfo.putString("myBook", b.getTitle());
            } else{
                extraInfo.putString("myBook", "no book available");
            }
            cs.putExtras(extraInfo);
            startActivity(cs);
        });
        binding.fiction.setOnClickListener(v -> {
            Books b = db.book().findBygenre("Fiction" );
            Intent f = new Intent(PlaceHold.this, BooksManage.class);
            Bundle extraInfo = new Bundle();
            if (b != null){
                extraInfo.putString("myBook", b.getTitle());
            } else{
                extraInfo.putString("myBook", "no book available");
            }
            f.putExtras(extraInfo);
            startActivity(f);
        });
    }

//    only one book that shown.\ and the uder clicks place hold and it logs t
//
//            in place hold only one book. then have the log in
}