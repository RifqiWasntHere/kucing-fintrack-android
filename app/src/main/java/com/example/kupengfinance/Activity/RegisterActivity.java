package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kupengfinance.R;

public class RegisterActivity extends AppCompatActivity {
    TextView tosign;
    ImageView backfsignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        tosign = (TextView) findViewById(R.id.tosignin);
        backfsignup = (ImageView) findViewById(R.id.backfsignup);

        backfsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this,  PreviewLoginActivity.class);
                startActivity(loginIntent);
            }
        });
        tosign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this,  SignInActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}