package com.example.kupengfinance.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kupengfinance.API.Account_Model_Card;
import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.Fragment.AccountFragment;
import com.example.kupengfinance.R;

import java.util.List;

public class RecyclerViewAdapterAccountCard extends RecyclerView.Adapter<RecyclerViewAdapterAccountCard.MyViewHolder> {
    private List<Account_Model_Card> cardNamelist;
    private List<Account_Model_Card>  cardBalanceList;
    Context context;


    AccountFragment accountMenu;
    public RecyclerViewAdapterAccountCard(AccountFragment accountMenu){
        this.accountMenu = accountMenu;
    }


    @NonNull
    @Override
    public RecyclerViewAdapterAccountCard.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_account,parent,false);
        return new RecyclerViewAdapterAccountCard.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterAccountCard.MyViewHolder holder, int position) {

        Account_Model_Card account_model_card_name = cardNamelist.get(position);
        Account_Model_Card account_model_card_balance = cardBalanceList.get(position);
        Log.d("Test list", String.valueOf(cardNamelist.size()));
        holder.categoryTxt.setText(account_model_card_name.getCardName());
        holder.cashTxt.setText("Rp. " + String.valueOf(account_model_card_balance.getCardBalance()));
    }

    @Override
    public int getItemCount() {
        return cardBalanceList.size();
    }

    public void setCardList(List<Account_Model_Card> cardNamelist,List<Account_Model_Card>  cardBalanceList){
        this.cardNamelist =cardNamelist;
        this.cardBalanceList = cardBalanceList;
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
