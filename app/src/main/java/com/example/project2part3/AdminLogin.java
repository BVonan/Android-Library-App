package com.example.project2part3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.project2part3.databinding.AdminLoginBinding;

//extends
public class AdminLogin extends AppCompatActivity {

    // in main activty create a new entiet which is the login screen
    // the login screen displays the xml
    // and in there create the if statements if they succeed transfer it to account manage info
    //

    private AdminLoginBinding binding;
    //    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AdminLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.adminLogin.setOnClickListener(v-> {
            EditText username = findViewById(R.id.admin_user);
            String name = username.getText().toString();
            EditText password = findViewById(R.id.admin_pass);
            String pass = password.getText().toString();
            Log.d("admin", String.valueOf(binding.adminPass.getText().equals("!admin2")));
            if (name.equals("!admin2") && pass.equals("!admin2")){
                Log.d("admin", "correct login");
                Intent mb = new Intent(AdminLogin.this, AccountManageInfo.class);
                startActivity(mb);
            }
        });
    }
}
