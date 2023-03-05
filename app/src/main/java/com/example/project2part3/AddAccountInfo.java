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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.project2part3.databinding.InfoAddAccountBinding;

import java.util.List;

public class AddAccountInfo extends DialogFragment{

    private InfoAddAccountBinding binding;
//    private RadioGroup radioGroup;
    private AccountDatabase db;
    private List<Account> accounts;
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        binding = InfoAddAccountBinding.inflate(LayoutInflater.from(getContext()));
        db = AccountDatabase.getInstance(getActivity());

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(binding.getRoot())
                .setTitle("Make an account")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        accounts = db.account().getAll();
                        String myU = String.valueOf(binding.qText.getText());
                        String myPass = String.valueOf(binding.qGenre.getText());
                        boolean found = false;
                        for (Account account : accounts) {
                            Log.d("account", account.getUsername()  + "  " + myU);
                            Log.d("account", String.valueOf(account.getUsername().equals(myU)));
                            if (account.getUsername().equals(myU)){
                                Log.d("account", "in the if");
                                found = true;
                                break;
                            } else{
                                Log.d("account", "hello");
                            }
                        }
                        if (found) {
                            Toast.makeText(getActivity(), "Account Already Exist", Toast.LENGTH_LONG).show();
                            Intent mm = new Intent(getActivity(), MainActivity.class);
                            startActivity(mm);
                        } else{
                            db.account().addAccount(new Account(myU,myPass));
                            db.transaction().addTransaction(new Transaction(" New account: " + myU));
                            Toast.makeText(getActivity(), "Account Made", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", ((info, which) -> { }));

        return builder.create();
    }
}