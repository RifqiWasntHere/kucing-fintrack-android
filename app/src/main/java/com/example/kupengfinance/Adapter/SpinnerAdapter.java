package com.example.kupengfinance.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.kupengfinance.API.Spinner_Model;
import com.example.kupengfinance.R;

import java.util.ArrayList;

public class SpinnerAdapter extends ArrayAdapter<Spinner_Model> {

    public SpinnerAdapter(Context context, ArrayList<Spinner_Model> spinnerList) {
        super(context, 0, spinnerList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable
    View convertView, @NonNull ViewGroup parent)
    {
        return initView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable
    View convertView, @NonNull ViewGroup parent) {
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent)
    {
        // It is used to set our custom view.
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_list, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.textCash);
        Spinner_Model currentItem = getItem(position);

        // It is used the name to the TextView when the
        // current item is not null.
        if (currentItem != null) {
            textViewName.setText(currentItem.getSpinnerList());
        }
        return convertView;
    }
}

