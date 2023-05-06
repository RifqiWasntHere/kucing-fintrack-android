package com.example.kupengfinance.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kupengfinance.API.Account_Model_Card;
import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.R;

import java.util.List;

public class RecyclerViewAdapterAccountCard extends RecyclerView.Adapter<RecyclerViewAdapterAccountCard.MyViewHolder> {
    private List<Account_Model_Card> list;
    Context context;

    public RecyclerViewAdapterAccountCard(List<Account_Model_Card> list){
        this.list = list;
    }
    @NonNull
    @Override
    public RecyclerViewAdapterAccountCard.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_account,parent,false);
        return new RecyclerViewAdapterAccountCard.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterAccountCard.MyViewHolder holder, int position) {

        Account_Model_Card account_model_card = list.get(position);
        holder.categoryTxt.setText(account_model_card.cardName);
        holder.cashTxt.setText(account_model_card.cardBalance);
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

    public interface itemClickListerner{
        public void onItemClick (Transaction_Model transaction_model);
    }
}
