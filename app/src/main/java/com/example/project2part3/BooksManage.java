package com.example.project2part3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project2part3.databinding.BooksBinding;

import java.util.List;

public class BooksManage extends AppCompatActivity {

    private List<Books> bookslist;
    private List<Account> userlist;
    private AccountDatabase db;
    private BooksBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = BooksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String  passedString = "";
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            passedString = extras.getString("myBook");
        }
        final String bookName = passedString;
        db = AccountDatabase.getInstance(this);
        bookslist = db.book().getAll();
        userlist = db.account().getAll();
        String booksstring = "";
        for (Books b : bookslist) {
            booksstring += b.getTitle();
            booksstring += b.getAuthor();
            booksstring += b.getGenre();
            Log.d("blah", b.getTitle());
        }
        binding.booksTv.setText(passedString);

        binding.holdBook.setOnClickListener(v -> {
            for (Account a: userlist) {
                if (String.valueOf(binding.enUser.getText()).equals(a.getUsername())) {
                    Books myb = db.book().findBytitle(bookName);
                    if (myb != null) {
                        int resNum = myb.getId() + 7000;
                        db.book().delete(myb);
                        Intent Ma = new Intent(BooksManage.this, MainActivity.class);
                        String messageResId = myb.getTitle() + " " + resNum;
                        Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show();
                        startActivity(Ma);
                    } else {
                        Toast.makeText(this, "NO BOOK AVAILABE", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });


//            binding.enLogin.setOnClickListener(v -> {
//        EditText username = findViewById(R.id.en_user);
//        EditText password = findViewById(R.id.en_pass);
//    });
    }
}
