package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kupengfinance.Fragment.SettingFragment;
import com.example.kupengfinance.R;

public class ChangePasswordActivity extends AppCompatActivity {

    ImageView cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        cancel = (ImageView) findViewById(R.id.cancelchange);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent (ChangePasswordActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }
        });
    }
}