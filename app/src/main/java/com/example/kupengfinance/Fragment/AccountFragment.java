package com.example.kupengfinance.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kupengfinance.Activity.AccountActivity;
import com.example.kupengfinance.Activity.TransactionActivity;
import com.example.kupengfinance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AccountFragment extends Fragment {

    FloatingActionButton addaccount;

    public AccountFragment() {
        // Required empty public constructor
    }

    public static AccountFragment getInstance() {
        return new AccountFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);
        addaccount = (FloatingActionButton) view.findViewById(R.id.addaccount);

        addaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AccountActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}