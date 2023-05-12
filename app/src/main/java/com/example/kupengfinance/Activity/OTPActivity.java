package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kupengfinance.R;

public class OTPActivity extends AppCompatActivity {

    TextView otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otp = (EditText)findViewById(R.id.otpText);
    }
}