package com.example.kupengfinance.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.example.kupengfinance.API.Account_Model_Cash;
import com.example.kupengfinance.Activity.AccountActivity;
import com.example.kupengfinance.Adapter.RecyclerViewAdapterAccountCard;
import com.example.kupengfinance.Adapter.RecyclerViewAdapterAccountCash;
import com.example.kupengfinance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import com.example.kupengfinance.API.RetrofitInterface;
import retrofit2.converter.gson.GsonConverterFactory;

public class AccountFragment extends Fragment {

    private ArrayList<Account_Model_Card> listCard = new ArrayList<>();
    private ArrayList<Account_Model_Cash> listCash = new ArrayList<>();

    SharedPreferences sharedPreferences;
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
//    private void initRecycleView(View view) {
//
//        buildListData();
//
//    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buildListDataCard(view);
        buildListDataCash(view);
    }

    private void buildListDataCard(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        //JADIIN CLASS
        sharedPreferences = getActivity().getSharedPreferences("USERID", Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("USERID", 0);

        Account_Model_Card getuserId = new Account_Model_Card(userId);
        Call<List<Account_Model_Card>> call = retrofitInterface.getCard(getuserId);
        call.enqueue(new Callback<List<Account_Model_Card>>() {
            @Override
            public void onResponse(Call<List<Account_Model_Card>> call, Response<List<Account_Model_Card>> response) {
                    List<Account_Model_Card> myCashAndCardBalance = response.body();
                    List<Account_Model_Card> cardNameList = new ArrayList<Account_Model_Card>();
                    List<Account_Model_Card> cardBalanceList = new ArrayList<Account_Model_Card>();

                    float[] cardBalance = new float[myCashAndCardBalance.size()];
                    String[] cardName = new String[myCashAndCardBalance.size()];
                    for (int i = 0; i < myCashAndCardBalance.size(); i++) {

                        Account_Model_Card model_card_name = new Account_Model_Card();
                        Account_Model_Card model_card_balance = new Account_Model_Card();

                        cardName[i] = myCashAndCardBalance.get(i).getCardName();
                        model_card_name.setCardName(cardName[i]);

                        cardBalance[i] = myCashAndCardBalance.get(i).getCardBalance();
                        model_card_balance.setCardBalance(cardBalance[i]);

                        cardNameList.add(model_card_name);
                        cardBalanceList.add(model_card_balance);
                    }
                    RecyclerView recyclerView = view.findViewById(R.id.viewCardAcc);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

                    recyclerView.setLayoutManager(layoutManager);
    //        RecyclerViewAdapterAccountCard adapter = new RecyclerViewAdapterAccountCard(listCard);
                    RecyclerViewAdapterAccountCard adapter = new RecyclerViewAdapterAccountCard(AccountFragment.this);
                    recyclerView.setAdapter(adapter);
                    adapter.setCardList(cardNameList,cardBalanceList);

            }

            @Override
            public void onFailure(Call<List<Account_Model_Card>> call, Throwable t) {
                Log.d("Ngambil2", "gagal");
            }
        });

    }
    private void buildListDataCash(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        sharedPreferences = getActivity().getSharedPreferences("USERID", Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("USERID", 0);

        Account_Model_Cash getuserId = new Account_Model_Cash(userId);
        Call<List<Account_Model_Cash>> call = retrofitInterface.getCash(getuserId);
        call.enqueue(new Callback<List<Account_Model_Cash>>() {
            @Override
            public void onResponse(Call<List<Account_Model_Cash>> call, Response<List<Account_Model_Cash>> response) {
                List<Account_Model_Cash> myCashAndCardBalance = response.body();
                List<Account_Model_Cash> cashNameList = new ArrayList<Account_Model_Cash>();
                List<Account_Model_Cash> cashBalanceList = new ArrayList<Account_Model_Cash>();

                float[] cashBalance = new float[myCashAndCardBalance.size()];
                String[] cashName = new String[myCashAndCardBalance.size()];

                for (int i = 0; i < myCashAndCardBalance.size(); i++) {
                    Account_Model_Cash model_cash_name = new Account_Model_Cash();
                    Account_Model_Cash model_cash_balance = new Account_Model_Cash();

                    cashName[i] = myCashAndCardBalance.get(i).getCashName();
                    model_cash_name.setCashName(cashName[i]);

                    cashBalance[i] = myCashAndCardBalance.get(i).getCashBalance();
                    model_cash_balance.setCashBalance(cashBalance[i]);

                    cashNameList.add(model_cash_name);
                    cashBalanceList.add(model_cash_balance);
                }
                RecyclerView recyclerView = view.findViewById(R.id.viewCashAcc);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(layoutManager);
                RecyclerViewAdapterAccountCash adapter = new RecyclerViewAdapterAccountCash(AccountFragment.this);
                recyclerView.setAdapter(adapter);
                adapter.setCashList(cashNameList,cashBalanceList);

            }

            @Override
            public void onFailure(Call<List<Account_Model_Cash>> call, Throwable t) {
                Log.d("Ngambil2", "gagal");
            }
        });

    }
}