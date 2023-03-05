package com.example.project2part3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.project2part3.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private AccountDatabase db;
    private List<Account> accountBank;
    private TextView tv;
    private int currentIndex = 0;
    private String account;
    private DialogFragment dialogFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Button manage = findViewById(R.id.manage_system);
        Button hold = findViewById(R.id.place_hold);
        dialogFragment = new AddAccountInfo();
        db = AccountDatabase.getInstance(MainActivity.this);
        db.populateInitialData();
        accountBank = db.account().getAll();

        binding.createAccount.setOnClickListener(v -> dialogFragment.show(getSupportFragmentManager(), ""));

        manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ml = new Intent(MainActivity.this, AdminLogin.class);
                startActivity(ml);
            }
        });

        hold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ph = new Intent(MainActivity.this, PlaceHold.class);
                startActivity(ph);
            }
        });


    }
}


