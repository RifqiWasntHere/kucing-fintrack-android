package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kupengfinance.API.Account_Model_Card;
import com.example.kupengfinance.API.Login_model;
import com.example.kupengfinance.API.RetrofitInterface;
import com.example.kupengfinance.API.Signup_model;
import com.example.kupengfinance.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.Response;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignInActivity extends AppCompatActivity {
    Button sign;
    TextView gosignup;
    TextView forgetpass;
    ImageView backfsignin;
    EditText emailEdt, passwordEdt;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        sharedPreferences = getSharedPreferences("USERID", Context.MODE_PRIVATE);


        emailEdt = (EditText) findViewById(R.id.email);
        passwordEdt = (EditText) findViewById(R.id.pass);

        sign = (Button) findViewById(R.id.btnsign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (emailEdt.getText().toString().equals("") || passwordEdt.getText().toString().equals("")){
                    Toast.makeText(SignInActivity.this, "Please Fill The Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    handleLogin(emailEdt.getText().toString(), passwordEdt.getText().toString());
                }
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
        forgetpass = (TextView) findViewById(R.id.forget);
        forgetpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(SignInActivity.this, ForgetPasswordActivity.class);
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
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(this, "Please Sign In First", Toast.LENGTH_SHORT).show();
    }

    private void handleLogin(String email, String pass) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Login_model login = new Login_model(email, pass);

        Call<Login_model> call = retrofitInterface.executeLogin(login);

        call.enqueue(new Callback<Login_model>(){
            @Override
            public void onResponse(Call<Login_model> call, Response<Login_model> response){
                if (response.code() == 200) {
                    Toast.makeText(SignInActivity.this, "Signed In Successfuly", Toast.LENGTH_LONG).show();
                    Login_model tempUserId = response.body();
                    int userId = tempUserId.getUserId();
//                    Log.i("Ngambil2", String.valueOf(userId));

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt("USERID", userId);
                    editor.apply();

                    Intent loginIntent = new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(loginIntent);
                } else if (response.code() == 400) {
                    Toast.makeText(SignInActivity.this, "User Not Found", Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Login_model> call, Throwable t) {
                Toast.makeText(SignInActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
       });
    }
}