package com.example.kupengfinance.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kupengfinance.Activity.ChangePasswordActivity;
import com.example.kupengfinance.Activity.PreviewLoginActivity;
import com.example.kupengfinance.Activity.TransactionActivity;
import com.example.kupengfinance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class LastMonthFragment extends Fragment {

    FloatingActionButton totrans;

    public LastMonthFragment() {
        // Required empty public constructor
    }

    public static LastMonthFragment getInstance() {
        return new LastMonthFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_last_month, container, false);
        totrans = (FloatingActionButton) view.findViewById(R.id.totrans);

        totrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TransactionActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}