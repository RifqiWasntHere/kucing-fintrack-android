package com.example.kupengfinance.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kupengfinance.API.Account_Model_Card;
import com.example.kupengfinance.API.Account_Model_Cash;
import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.Fragment.AccountFragment;
import com.example.kupengfinance.R;

import java.util.List;

public class RecyclerViewAdapterAccountCash extends RecyclerView.Adapter<RecyclerViewAdapterAccountCash.MyViewHolder>  {
    private List<Account_Model_Cash> cashNamelist;
    public List<Account_Model_Cash> cashBalanceList;
    Context context;

    AccountFragment accountMenu;
    public RecyclerViewAdapterAccountCash(AccountFragment accountMenu){
        this.accountMenu = accountMenu;
    }

    @NonNull
    @Override
    public RecyclerViewAdapterAccountCash.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cash_account,parent,false);
        return new RecyclerViewAdapterAccountCash.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterAccountCash.MyViewHolder holder, int position) {

        Account_Model_Cash account_model_cash_name = cashNamelist.get(position);
        Account_Model_Cash account_model_cash_balance = cashBalanceList.get(position);
        holder.categoryTxt.setText(account_model_cash_name.cashName);
        holder.cashTxt.setText("Rp. " + String.valueOf(account_model_cash_balance.getCashBalance()));
    }

    @Override
    public int getItemCount() {
        return cashBalanceList.size();
    }

    public void setCashList(List<Account_Model_Cash> cashNamelist,List<Account_Model_Cash>  cashBalanceList){
        this.cashNamelist =cashNamelist;
        this.cashBalanceList = cashBalanceList;
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
