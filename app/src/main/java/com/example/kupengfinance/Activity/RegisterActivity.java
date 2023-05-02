package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kupengfinance.API.RetrofitInterface;
import com.example.kupengfinance.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    TextView tosign;
    ImageView backfsignup;
    Button btnsignup;
    EditText username_edittext;
    EditText password_edittext;
    EditText email_edittext;

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    private String BASE_URL = "https://kucing-finance-backend-production.up.railway.app/user/signup/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        backfsignup = (ImageView) findViewById(R.id.backfsignup);
        backfsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, PreviewLoginActivity.class);
                startActivity(loginIntent);
            }
        });
        tosign = (TextView) findViewById(R.id.tosignin);
        tosign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, SignInActivity.class);
                startActivity(loginIntent);
            }
        });
        btnsignup = (Button) findViewById(R.id.signup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUp();
            }
        });
    }

    private void handleSignUp() {

        username_edittext = (EditText) findViewById(R.id.Rusername);
        email_edittext = (EditText) findViewById(R.id.Remail);
        password_edittext = (EditText) findViewById(R.id.Rpassword);

        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, String> map = new HashMap<>();

                map.put("username", username_edittext.getText().toString());
                map.put("email", email_edittext.getText().toString());
                map.put("password", password_edittext.getText().toString());

                Call<Void> call = retrofitInterface.executeSignUp(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.code() == 200){
                            Toast.makeText(RegisterActivity.this, "Signed Up Successfuly", Toast.LENGTH_LONG).show();
                        } else if (response.code() == 400){
                            Toast.makeText(RegisterActivity.this, "Already Registered", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(RegisterActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}