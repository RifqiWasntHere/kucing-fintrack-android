package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kupengfinance.API.ForgetPass_model;
import com.example.kupengfinance.API.Otp_model;
import com.example.kupengfinance.API.RetrofitInterface;
import com.example.kupengfinance.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OTPActivity extends AppCompatActivity {

    EditText otp;
    Button submitForget;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        otp = (EditText)findViewById(R.id.otpText);
        submitForget = (Button)findViewById(R.id.submitForget);

        submitForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(otp.getText().toString().equals("")){
                    Toast.makeText(OTPActivity.this, "Please Fill The Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    sharedPreferences = getSharedPreferences("EMAIL", Context.MODE_PRIVATE);
                    String email = sharedPreferences.getString("EMAIL", null);
                    handleForgetOTP(email, otp.getText().toString());
                }
            }
        });
    }
    private void handleForgetOTP(String email, String otp){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Otp_model otp_model = new Otp_model(otp, email);

        Call<Otp_model> call = retrofitInterface.executeForgetOtp(otp_model);

        call.enqueue(new Callback<Otp_model>() {
            @Override
            public void onResponse(Call<Otp_model> call, Response<Otp_model> response) {
                if (response.code() == 200){
                    Intent intent = new Intent(OTPActivity.this, MainActivity.class);
                    startActivity(intent);
                } else if (response.code() == 401){
                    Toast.makeText(OTPActivity.this, "OTP is not Authorized", Toast.LENGTH_LONG).show();
                } else if (response.code() == 400){
                    Toast.makeText(OTPActivity.this, "Action failed", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<Otp_model> call, Throwable t) {
                Toast.makeText(OTPActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}