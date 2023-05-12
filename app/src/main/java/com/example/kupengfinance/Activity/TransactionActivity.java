package com.example.kupengfinance.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.kupengfinance.API.Account_Model_Cash;
import com.example.kupengfinance.API.RetrofitInterface;
import com.example.kupengfinance.API.Transaction_Model;
import com.example.kupengfinance.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TransactionActivity extends AppCompatActivity {

    Spinner spinner;
    Spinner spinnerAcc;
    Spinner spinnerAcc2;
    EditText cateEdt;
    EditText amountEdt;
    EditText noteEdt;
    Button confirm;
    String val, val1;
    Integer transCard = null;
    SharedPreferences sharedPreferences;


    ImageView canceltransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        sharedPreferences = getSharedPreferences("USERID", Context.MODE_PRIVATE);
        int userId = sharedPreferences.getInt("USERID", 0);


        spinner = (Spinner)findViewById(R.id.spin) ;
        spinnerAcc = (Spinner)findViewById(R.id.spinnerAcc);
        spinnerAcc2 = (Spinner)findViewById(R.id.spinnerAcc2);
        amountEdt = (EditText)findViewById(R.id.amountText);
        cateEdt = (EditText)findViewById(R.id.cateText);
        noteEdt = (EditText)findViewById(R.id.noteText);


        canceltransaction = (ImageView) findViewById(R.id.canceltransaction);
        canceltransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent (TransactionActivity.this, MainActivity.class);
                startActivity(loginIntent);

            }
        });

        confirm = (Button)findViewById(R.id.btnConfirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (val.equals("Select One") || val1.equals("Select One") ||cateEdt.getText().toString().equals("") || amountEdt.getText().toString().equals("") || noteEdt.getText().toString().equals("") ){
                    Toast.makeText(TransactionActivity.this, "Please Fill The Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(val.equals("income")){
                    handleTransactionIncome(userId,6,  null,  Integer.parseInt(cateEdt.getText().toString()), "income", Integer.parseInt(amountEdt.getText().toString()),noteEdt.getText().toString());

                    return;
                }
                if(val.equals("outcome")){
                    handleTransactionOutcome(userId, 6, null, Integer.parseInt(cateEdt.getText().toString()), "outcome", Integer.parseInt(amountEdt.getText().toString()),noteEdt.getText().toString());
                    return;
                }
            }
        });
        spinner.setOnItemSelectedListener( new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                val = spinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinnerAcc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                val1 = spinnerAcc.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void handleTransactionIncome(int userId, int transCash, @Nullable Integer transCard, int cateId, String transType, float transAmount, String transNote) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // below line is to create an instance for our retrofit api class.
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Transaction_Model transaction_model = new Transaction_Model(userId, transCash, transCard, cateId, transType, transAmount, transNote);

        Call<Transaction_Model> call = retrofitInterface.addTrans(transaction_model);

        call.enqueue(new Callback<Transaction_Model>() {
            @Override
            public void onResponse(Call<Transaction_Model> call, Response<Transaction_Model> response) {
                if (response.code() == 201) {
                    Toast.makeText(TransactionActivity.this, "Transaction In Added", Toast.LENGTH_LONG).show();
                    Intent loginIntent = new Intent(TransactionActivity.this, AccountActivity.class);
                    startActivity(loginIntent);
                } else if (response.code() == 400) {
                    Toast.makeText(TransactionActivity.this, "Already Registered", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(TransactionActivity.this, "API Reached", Toast.LENGTH_SHORT).show();

                // we are getting response from our body
                // and passing it to our modal class.
                Transaction_Model responseFromAPI = response.body();

                // on below line we are getting our data from modal class
                // and adding it to our string.
//                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getUsername() + "\n" + "Email : " + responseFromAPI.getEmail();

                // below line we are setting our
                // string to our text view.
                Log.i(String.valueOf(response.code()), "ingfo");

            }

            @Override
            public void onFailure(Call<Transaction_Model> call, Throwable t) {
                Toast.makeText(TransactionActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void handleTransactionOutcome(int userId, int transCash,  @Nullable Integer transCard, int cateId, String transType, float transAmount, String transNote) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // below line is to create an instance for our retrofit api class.
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Transaction_Model transaction_model = new Transaction_Model(userId, transCash, transCard, cateId, transType, transAmount, transNote);

        Call<Transaction_Model> call = retrofitInterface.addTrans(transaction_model);

        call.enqueue(new Callback<Transaction_Model>() {
            @Override
            public void onResponse(Call<Transaction_Model> call, Response<Transaction_Model> response) {
                if (response.code() == 201) {
                    Toast.makeText(TransactionActivity.this, "Transaction Out Added", Toast.LENGTH_LONG).show();
                    Intent loginIntent = new Intent(TransactionActivity.this, AccountActivity.class);
                    startActivity(loginIntent);
                } else if (response.code() == 400) {
                    Toast.makeText(TransactionActivity.this, "Already Registered", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(TransactionActivity.this, "API Reached", Toast.LENGTH_SHORT).show();

                // we are getting response from our body
                // and passing it to our modal class.
                Transaction_Model responseFromAPI = response.body();

                // on below line we are getting our data from modal class
                // and adding it to our string.
//                String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getUsername() + "\n" + "Email : " + responseFromAPI.getEmail();

                // below line we are setting our
                // string to our text view.
                Log.i(String.valueOf(response.code()), "ingfo");

            }

            @Override
            public void onFailure(Call<Transaction_Model> call, Throwable t) {
                Toast.makeText(TransactionActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

