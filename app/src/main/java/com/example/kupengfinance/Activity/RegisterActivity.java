package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.kupengfinance.API.RetrofitInterface;
import com.example.kupengfinance.API.Signup_model;
import com.example.kupengfinance.R;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    TextView tosign;
    ImageView backfsignup;
    Button btnsignup;
    EditText usernameEdt, passwordEdt, emailEdt;

//    private Retrofit retrofit;
//    private RetrofitInterface retrofitInterface;
//    private String BASE_URL = "https://kucing-finance-backend-production.up.railway.app/user/signup/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        usernameEdt = (EditText) findViewById(R.id.Rusername);
        emailEdt = (EditText) findViewById(R.id.Remail);
        passwordEdt = (EditText) findViewById(R.id.Rpassword);
        tosign = (TextView) findViewById(R.id.tosignin);
        backfsignup = (ImageView) findViewById(R.id.backfsignup);

        btnsignup = (Button) findViewById(R.id.signup);
        backfsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, PreviewLoginActivity.class);
                startActivity(loginIntent);
            }
        });
        tosign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, SignInActivity.class);
                startActivity(loginIntent);
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usernameEdt.getText().toString().equals("") || emailEdt.getText().toString().equals("") || passwordEdt.getText().toString().equals("")){
                    Toast.makeText(RegisterActivity.this, "Please Fill The Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    handleSignUp(usernameEdt.getText().toString(), emailEdt.getText().toString(), passwordEdt.getText().toString());
                }
            }
        });
    }

    private void handleSignUp(String username, String email, String password) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Signup_model signUp = new Signup_model(username, email, password);

        Call<Signup_model> call = retrofitInterface.createSignUp(signUp);

        call.enqueue(new Callback<Signup_model>() {
            @Override
            public void onResponse(Call<Signup_model> call, Response<Signup_model> response) {
                if (response.code() == 201){
                    Toast.makeText(RegisterActivity.this, "Signed Up Successfuly", Toast.LENGTH_LONG).show();
                    Intent loginIntent = new Intent(RegisterActivity.this, SignInActivity.class);
                    startActivity(loginIntent);
                } else if (response.code() == 400){
                    Toast.makeText(RegisterActivity.this, "Already Registered", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(RegisterActivity.this, "API Reached", Toast.LENGTH_SHORT).show();

            }


            @Override
            public void onFailure(Call<Signup_model> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}