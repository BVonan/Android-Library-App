package com.example.project2part3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.List;
import com.example.project2part3.databinding.ActivityAccountManageBinding;

public class AccountManageInfo extends AppCompatActivity {

    private AccountDatabase db;
    private ActivityAccountManageBinding binding;
    private ListView accountListView;
    private ArrayAdapter<Account> accountAdapter;
    private List<Account> accountList;
    private List<Transaction> transactionlist;
    private DialogFragment dialogFragment;
    private Account selectedQ;

    public Account getSelectedQ() {
        return selectedQ;
    }

    public void setSelectedQ(Account selectedQ) {
        this.selectedQ = selectedQ;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAccountManageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        db = AccountDatabase.getInstance(this);

        accountList = db.account().getAll();
        transactionlist = db.transaction().getAll();
        String transactionstring = "";
        for (Transaction t : transactionlist) {
            transactionstring += t.getInfo() + "\n";
            Log.d("blah", t.getInfo());
        }
        binding.transactionTv.setText(transactionstring);
        binding.addBook.setOnClickListener(v ->{
            Intent ab = new Intent(AccountManageInfo.this, AddBook.class);
            startActivity(ab);        });
    }

    @Override
    protected void onResume() {
//        updateUI();
        super.onResume();
    }

    private void updateUI() {
        accountList = db.account().getAll();
        if (accountAdapter == null) {
            accountAdapter = new ArrayAdapter<>(this, R.layout.item_username,
                    R.id.username_item, accountList);
            accountListView.setAdapter(accountAdapter);
        } else {
            accountAdapter.clear();
            accountAdapter.addAll(accountList);
            accountAdapter.notifyDataSetChanged();
        }
    }


}
