package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.kupengfinance.R;

public class AccountActivity extends AppCompatActivity {

    ImageView cancelaccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        cancelaccount = (ImageView) findViewById(R.id.cancelaccount);

        cancelaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent (AccountActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}