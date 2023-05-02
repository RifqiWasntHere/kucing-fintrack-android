package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kupengfinance.R;

public class SignInActivity extends AppCompatActivity {
    Button sign;
    TextView gosignup;
    TextView forgetpass;
    ImageView backfsignin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        sign = (Button) findViewById(R.id.btnsign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent (SignInActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });
        backfsignin = (ImageView) findViewById(R.id.backfsignin);
        backfsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(SignInActivity.this, PreviewLoginActivity.class);
                startActivity(loginIntent);
            }
        });
        gosignup = (TextView) findViewById(R.id.gosignup);
        gosignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(SignInActivity.this, RegisterActivity.class);
                startActivity(loginIntent);
            }
        });
        forgetpass = (TextView) findViewById(R.id.forget);
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(SignInActivity.this, ForgetPasswordActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}