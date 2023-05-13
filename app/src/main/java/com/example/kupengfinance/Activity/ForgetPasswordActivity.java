package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kupengfinance.API.ForgetPass_model;
import com.example.kupengfinance.API.RetrofitInterface;
import com.example.kupengfinance.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ForgetPasswordActivity extends AppCompatActivity {

    ImageView backsignup;
    Button btnsubmit;
    EditText emailEdt;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        sharedPreferences = getSharedPreferences("EMAIL", Context.MODE_PRIVATE);

        backsignup = (ImageView) findViewById(R.id.backfsignup);
        btnsubmit = (Button) findViewById(R.id.submitForget);
        emailEdt = (EditText) findViewById(R.id.forgetemail);

        backsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForgetPasswordActivity.this, SignInActivity.class);
                startActivity(intent);
            }
        });
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailEdt.getText().toString().equals("")){
                    Toast.makeText(ForgetPasswordActivity.this, "Please Fill The Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    handleForgetPass(emailEdt.getText().toString());
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("EMAIL", emailEdt.getText().toString());
                    editor.apply();
                }
            }
        });
    }

    private void handleForgetPass(String email){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        ForgetPass_model forgetPass = new ForgetPass_model(email);

        Call<ForgetPass_model> call = retrofitInterface.executeForgetEmail(forgetPass);

        call.enqueue(new Callback<ForgetPass_model>() {
            @Override
            public void onResponse(Call<ForgetPass_model> call, Response<ForgetPass_model> response) {
                if (response.code() == 200){
                    Intent intent = new Intent(ForgetPasswordActivity.this, OTPActivity.class);
                    startActivity(intent);
                } else if (response.code() == 401){
                    Toast.makeText(ForgetPasswordActivity.this, "Email not found!", Toast.LENGTH_LONG).show();
                } else if (response.code() == 400){
                    Toast.makeText(ForgetPasswordActivity.this, "Action failed", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<ForgetPass_model> call, Throwable t) {
                Toast.makeText(ForgetPasswordActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}