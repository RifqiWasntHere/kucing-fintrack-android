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
        // below line is to create an instance for our retrofit api class.
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Signup_model signUp = new Signup_model(username, email, password);
//        Log.i(username.toString(),"Username");
//        Log.i(email.toString(),"Email");
//        Log.i(password.toString(),"Password");
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

                // we are getting response from our body
                // and passing it to our modal class.
                Signup_model responseFromAPI = response.body();

                // on below line we are getting our data from modal class
                // and adding it to our string.
//                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getUsername() + "\n" + "Email : " + responseFromAPI.getEmail();

                // below line we are setting our
                // string to our text view.
                Log.i(String.valueOf(response.code()), "ingfo");

            }


            @Override
            public void onFailure(Call<Signup_model> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}