package com.example.kupengfinance.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kupengfinance.API.Account_Model_Card;
import com.example.kupengfinance.API.Account_Model_Card_Get;
import com.example.kupengfinance.API.Account_Model_Cash;
import com.example.kupengfinance.API.Login_model;
import com.example.kupengfinance.Activity.AccountActivity;
import com.example.kupengfinance.Adapter.RecyclerViewAdapterAccountCard;
import com.example.kupengfinance.Adapter.RecyclerViewAdapterAccountCash;
import com.example.kupengfinance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import com.example.kupengfinance.API.RetrofitInterface;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountFragment extends Fragment {

    private ArrayList<Account_Model_Card> listCard = new ArrayList<>();
    private ArrayList<Account_Model_Cash> listCash = new ArrayList<>();
    private ArrayList<Account_Model_Card_Get> getCard = new ArrayList<>();
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
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        //change paramater in Account_Model_Card_Get
//        Account_Model_Card_Get getCard = new Account_Model_Card_Get(48);

        Call<Account_Model_Card> call = retrofitInterface.getCard(48);
        call.enqueue(new Callback<Account_Model_Card>() {
            @Override
            public void onResponse(Call<Account_Model_Card> call, Response<Account_Model_Card> response) {
                if(response.isSuccessful()){
                    response.body();
                    int userId = response.body().getUserId();
                    String cardName = response.body().getCardName();
                    float cardBalance = response.body().getCardBalance();
                    Log.d("Ngambil", cardName);
                }
            }

            @Override
            public void onFailure(Call<Account_Model_Card> call, Throwable t) {

            }
        });
    }

    private void initRecycleView2(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.viewCashAcc);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapterAccountCash adapter = new RecyclerViewAdapterAccountCash(listCash);
        recyclerView.setAdapter(adapter);
    }

    private void buildListData2(){
        listCash.add(new Account_Model_Cash(48, "Jajan",100000));
        listCash.add(new Account_Model_Cash(48, "Jajan",100000));
    }
}