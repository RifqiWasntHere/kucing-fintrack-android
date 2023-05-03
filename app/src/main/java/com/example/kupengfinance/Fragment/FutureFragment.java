package com.example.kupengfinance.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kupengfinance.Activity.TransactionActivity;
import com.example.kupengfinance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FutureFragment extends Fragment {

    FloatingActionButton ftotrans;

    public FutureFragment() {
        // Required empty public constructor
    }

    public static FutureFragment getInstance() {
        return new FutureFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_future, container, false);

        ftotrans = (FloatingActionButton) view.findViewById(R.id.ftotrans);

        ftotrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TransactionActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}