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

import com.example.kupengfinance.API.RetrofitInterface;
import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.Activity.TransactionActivity;
import com.example.kupengfinance.Adapter.RecyclerViewAdapterTransaction;
import com.example.kupengfinance.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FebruaryFragment extends Fragment {

    private ArrayList<Transaction_Model> list = new ArrayList<>();
    FloatingActionButton ttotrans;
    int month = 1;
    int year = 2023;

    public FebruaryFragment() {
        // Required empty public constructor
    }

    public static FebruaryFragment getInstance() {
        return new FebruaryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_february, container, false);
        ttotrans = (FloatingActionButton) view.findViewById(R.id.totrans);

        ttotrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TransactionActivity.class);
                startActivity(intent);
            }
        });
     return view;
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buildListDataJanuary(view);
//        initRecycleView(view);
    }

    private void buildListDataJanuary(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);
        //change paramater in Account_Model_Card_Get
//        Account_Model_Card_Get getCard = new Account_Model_Card_Get(48);
        Transaction_Model getTransa = new Transaction_Model(48, month, year);
        Call<List<Transaction_Model>> call = retrofitInterface.getTrans(getTransa);
        call.enqueue(new Callback<List<Transaction_Model>>() {
            @Override
            public void onResponse(Call<List<Transaction_Model>> call, Response<List<Transaction_Model>> response) {
                List<Transaction_Model> myTrans = response.body();
                List<Transaction_Model> cateId = new ArrayList<Transaction_Model>();
                List<Transaction_Model> transType = new ArrayList<Transaction_Model>();
                List<Transaction_Model> transAmount = new ArrayList<Transaction_Model>();
                List<Transaction_Model> transNote = new ArrayList<Transaction_Model>();

                int[] category = new int[myTrans.size()];
                String[] type = new String[myTrans.size()];
                float[] amount = new float[myTrans.size()];
                String[] note = new String[myTrans.size()];
                for (int i = 0; i < myTrans.size(); i++) {

                    Transaction_Model transaction_model_cate = new Transaction_Model();
                    Transaction_Model transaction_model_type = new Transaction_Model();
                    Transaction_Model transaction_model_amount = new Transaction_Model();
                    Transaction_Model transaction_model_note = new Transaction_Model();

                    category[i] = myTrans.get(i).getCateId();
                    transaction_model_cate.setCateId(category[i]);

                    type[i] = myTrans.get(i).getTransType();
                    transaction_model_type.setTransType(type[i]);

                    amount[i] = myTrans.get(i).getTransAmount();
                    transaction_model_amount.setTransAmount(amount[i]);

                    note[i] = myTrans.get(i).getTransNote();
                    transaction_model_note.setTransNote(note[i]);

                    cateId.add(transaction_model_cate);
                    transType.add(transaction_model_type);
                    transAmount.add(transaction_model_amount);
                    transNote.add(transaction_model_note);
                }
                RecyclerView recyclerView = view.findViewById(R.id.viewFebruary);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

                recyclerView.setLayoutManager(layoutManager);
                RecyclerViewAdapterTransaction adapter = new RecyclerViewAdapterTransaction (FebruaryFragment.this);
                recyclerView.setAdapter(adapter);
                adapter.setTransList(cateId,transType,transAmount,transNote);

            }

            @Override
            public void onFailure(Call<List<Transaction_Model>> call, Throwable t) {
                Log.d("Ngambil2", "gagal");
            }
        });

    }
}