package com.example.kupengfinance.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kupengfinance.API.Account_Model_Card;
import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.Fragment.FebruaryFragment;
import com.example.kupengfinance.Fragment.JanuaryFragment;
import com.example.kupengfinance.Fragment.TransactionFragment;
import com.example.kupengfinance.R;

import java.util.List;

public class RecyclerViewAdapterTransaction extends RecyclerView.Adapter<RecyclerViewAdapterTransaction.MyViewHolder> {
    private List<Transaction_Model> cateIdList;
    private List<Transaction_Model> transTypeList;
    private List<Transaction_Model> transAmountList;
    private List<Transaction_Model> transNoteList;
    Context context;

    Fragment fragment;

    public RecyclerViewAdapterTransaction(Fragment fragment){
        this.fragment = fragment;
    }
    @NonNull
    @Override
    public RecyclerViewAdapterTransaction.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_month_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapterTransaction.MyViewHolder holder, int position) {

        Transaction_Model transaction_model_cate = cateIdList.get(position);
        Transaction_Model transaction_model_type = transTypeList.get(position);
        Transaction_Model transaction_model_amount = transAmountList.get(position);
        Transaction_Model transaction_model_note = transNoteList.get(position);
        holder.categoryTxt.setText(String.valueOf(transaction_model_cate.category));
        holder.typeTxt.setText(transaction_model_type.transType);
        holder.amountTxt.setText("Rp. " + String.valueOf(transaction_model_amount.getTransAmount()));
        holder.noteTxt.setText(transaction_model_note.transNote);
    }

    @Override
    public int getItemCount() {
        return transAmountList.size();
    }

    public void setTransList(List<Transaction_Model>cateIdList, List<Transaction_Model> transTypeList, List<Transaction_Model> transAmountList,List<Transaction_Model> transNoteList ){
        this.cateIdList =cateIdList;
        this.transTypeList = transTypeList;
        this.transAmountList = transAmountList;
        this.transNoteList = transNoteList;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView categoryTxt, typeTxt, accountTxt, amountTxt, noteTxt;

        public MyViewHolder(View view){
            super(view);
            categoryTxt = view.findViewById(R.id.textCategory);
            typeTxt = view.findViewById(R.id.textType);
            accountTxt = view.findViewById(R.id.textAccount);
            amountTxt = view.findViewById(R.id.textAmount);
            noteTxt = view.findViewById(R.id.textNote);
        }
    }
}
