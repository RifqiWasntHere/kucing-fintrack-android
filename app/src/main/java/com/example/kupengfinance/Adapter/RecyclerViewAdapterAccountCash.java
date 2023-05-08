package com.example.kupengfinance.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kupengfinance.API.Account_Model_Cash;
import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.R;

import java.util.List;

public class RecyclerViewAdapterAccountCash extends RecyclerView.Adapter<RecyclerViewAdapterAccountCash.MyViewHolder>  {
    private List<Account_Model_Cash> list;
    Context context;

    public RecyclerViewAdapterAccountCash(List<Account_Model_Cash> list){
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerViewAdapterAccountCash.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cash_account,parent,false);
        return new RecyclerViewAdapterAccountCash.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterAccountCash.MyViewHolder holder, int position) {

        Account_Model_Cash account_model_cash = list.get(position);
        holder.categoryTxt.setText(account_model_cash.cashName);
        holder.cashTxt.setText((int)account_model_cash.cashBalance);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTxt, cashTxt;

        public MyViewHolder(View view){
            super(view);
            categoryTxt = view.findViewById(R.id.textCategory);
            cashTxt = view.findViewById(R.id.textCash);
        }
    }


}
