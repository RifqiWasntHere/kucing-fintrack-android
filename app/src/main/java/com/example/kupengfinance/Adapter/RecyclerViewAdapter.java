package com.example.kupengfinance.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private List<Transaction_Model> list;
    Context context;

    public RecyclerViewAdapter(List<Transaction_Model> list){
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.this_month_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {

        Transaction_Model transaction_model = list.get(position);
        holder.categoryTxt.setText(transaction_model.category);
        holder.transactionTxt.setText(transaction_model.transaction);
        holder.accountTxt.setText(transaction_model.account);
        holder.cashTxt.setText(transaction_model.cash);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTxt, transactionTxt, accountTxt, cashTxt;

        public MyViewHolder(View view){
            super(view);
            categoryTxt = view.findViewById(R.id.textCategory);
            transactionTxt = view.findViewById(R.id.textTransaction);
            accountTxt = view.findViewById(R.id.textAccount);
            cashTxt = view.findViewById(R.id.textCash);
        }
    }

    public interface itemClickListerner{
        public void onItemClick (Transaction_Model transaction_model);
    }
}
