package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.kupengfinance.R;

public class TransactionActivity extends AppCompatActivity {
ImageView canceltransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        canceltransaction = (ImageView) findViewById(R.id.canceltransaction);

        canceltransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent (TransactionActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}