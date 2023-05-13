package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kupengfinance.R;

public class PreviewLoginActivity extends AppCompatActivity {
    Button tosign,toregist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_login);

        tosign = (Button) findViewById(R.id.btntosign);
        toregist = (Button) findViewById(R.id.btntoregist);

        tosign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(PreviewLoginActivity.this, SignInActivity.class);
                startActivity(loginIntent);
            }
        });
        toregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(PreviewLoginActivity.this, RegisterActivity .class);
                startActivity(loginIntent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }
    public void showDialog() {
        final AlertDialog.Builder builder=new AlertDialog.Builder(PreviewLoginActivity.this);
        builder.setTitle("");

        builder.setMessage("Do you want to EXIT?");

        builder.setCancelable(false);

        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                builder.create().dismiss();
            }
        });
        builder.show();
    }
}
