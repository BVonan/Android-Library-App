package com.example.project2part3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.project2part3.databinding.InfoManageAccountBinding;

public class ManageAccountInfo extends DialogFragment {

    private InfoManageAccountBinding binding;
    private int myPKey = -1;
    private AccountDatabase db;


    public static ManageAccountInfo newInstance(int num) {
        ManageAccountInfo mai = new ManageAccountInfo();
        Bundle args = new Bundle();
        args.putInt("pKey", num);
        mai.setArguments(args);
        return mai;
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        binding = InfoManageAccountBinding.inflate(LayoutInflater.from(getContext()));
        db = AccountDatabase.getInstance(getActivity());
        myPKey = getArguments().getInt("pKey");
        Account q = db.account().findById(myPKey);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        binding.accEd.setText(q.getUsername());
        builder.setView(binding.getRoot())
                .setTitle("Edit Account")
                .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("ManageAccount", "update clicked");
                        String newString = binding.accEd.getText().toString();
                        q.setUsername(newString);
                        db.account().update(q);
                    }
                })
                .setNeutralButton("Cancel", ((dialog, which) -> { }))
                .setNegativeButton("Delete", ((dialog, which) -> { }));
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }


}
