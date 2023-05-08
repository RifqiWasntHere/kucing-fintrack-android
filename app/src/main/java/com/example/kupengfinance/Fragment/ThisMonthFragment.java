package com.example.kupengfinance.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.Activity.TransactionActivity;
import com.example.kupengfinance.Adapter.RecyclerViewAdapterTransaction;
import com.example.kupengfinance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ThisMonthFragment extends Fragment {

    private ArrayList<Transaction_Model> list = new ArrayList<>();
    FloatingActionButton ttotrans;

    public ThisMonthFragment() {
        // Required empty public constructor
    }

    public static ThisMonthFragment getInstance() {
        return new ThisMonthFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_january, container, false);
        ttotrans = (FloatingActionButton) view.findViewById(R.id.ttotrans);

        ttotrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TransactionActivity.class);
                startActivity(intent);
            }
        });
     return view;
    }
    private void initRecycleView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.viewThisMonth);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterTransaction adapter = new RecyclerViewAdapterTransaction(list);
        recyclerView.setAdapter(adapter);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buildListData();
        initRecycleView(view);
    }

    private void buildListData(){
        list.add(new Transaction_Model("Pengeluaran", "Jajan","Charish","10000"));
        list.add(new Transaction_Model("Pengeluaran", "Makan","Charish","50000"));
        list.add(new Transaction_Model("Pengeluaran", "Bensin","Charish","70000"));
        list.add(new Transaction_Model("Pengeluaran", "Nonton","Charish","100000"));
        list.add(new Transaction_Model("Pengeluaran", "Jajan","Charish","10000"));
        list.add(new Transaction_Model("Pengeluaran", "Makan","Charish","50000"));
        list.add(new Transaction_Model("Pengeluaran", "Bensin","Charish","70000"));
        list.add(new Transaction_Model("Pengeluaran", "Nonton","Charish","100000"));
        list.add(new Transaction_Model("Pengeluaran", "Jajan","Charish","10000"));
        list.add(new Transaction_Model("Pengeluaran", "Makan","Charish","50000"));
        list.add(new Transaction_Model("Pengeluaran", "Bensin","Charish","70000"));
        list.add(new Transaction_Model("Pengeluaran", "Nonton","Charish","100000"));
        list.add(new Transaction_Model("Pengeluaran", "Jajan","Charish","10000"));
        list.add(new Transaction_Model("Pengeluaran", "Makan","Charish","50000"));
        list.add(new Transaction_Model("Pengeluaran", "Bensin","Charish","70000"));
        list.add(new Transaction_Model("Pengeluaran", "Nonton","Charish","100000"));
        list.add(new Transaction_Model("Pengeluaran", "Jajan","Charish","10000"));
        list.add(new Transaction_Model("Pengeluaran", "Makan","Charish","50000"));
        list.add(new Transaction_Model("Pengeluaran", "Bensin","Charish","70000"));
        list.add(new Transaction_Model("Pengeluaran", "Nonton","Charish","100000"));
    }
}