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

import com.example.kupengfinance.API.Account_Model_Card;
import com.example.kupengfinance.API.Account_Model_Cash;
import com.example.kupengfinance.Activity.AccountActivity;
import com.example.kupengfinance.Adapter.RecyclerViewAdapterAccountCard;
import com.example.kupengfinance.Adapter.RecyclerViewAdapterAccountCash;
import com.example.kupengfinance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AccountFragment extends Fragment {

    private ArrayList<Account_Model_Card> listCard = new ArrayList<>();
    private ArrayList<Account_Model_Cash> listCash = new ArrayList<>();
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
    private void initRecycleView(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.viewCardAcc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterAccountCard adapter = new RecyclerViewAdapterAccountCard(listCard);
        recyclerView.setAdapter(adapter);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buildListData();
        initRecycleView(view);
        buildListData2();
        initRecycleView2(view);
    }

    private void buildListData(){
        listCard.add(new Account_Model_Card("48", "Mandiri","100000"));
        listCard.add(new Account_Model_Card("48", "Bca","100000"));
    }

    private void initRecycleView2(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.viewCashAcc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterAccountCash adapter = new RecyclerViewAdapterAccountCash(listCash);
        recyclerView.setAdapter(adapter);
    }

    private void buildListData2(){
        listCash.add(new Account_Model_Cash("48", "Jajan","100000"));
        listCash.add(new Account_Model_Cash("48", "Jajan","100000"));
    }
}