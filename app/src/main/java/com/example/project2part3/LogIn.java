package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2part3.databinding.LogInBinding;

public class LogIn extends AppCompatActivity {
private LogInBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = LogInBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.enLogin.setOnClickListener(v -> {
            EditText username = findViewById(R.id.en_user);
            EditText password = findViewById(R.id.en_pass);
            Intent hp = new Intent(LogIn.this, MainActivity.class);
            startActivity(hp);
            int messageResId = 0;
            messageResId = R.string.correct;
            Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();


        });



    }
}
