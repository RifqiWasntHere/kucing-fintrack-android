package com.example.kupengfinance.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kupengfinance.API.ChangePass_model;
import com.example.kupengfinance.API.ForgetPass_model;
import com.example.kupengfinance.API.RetrofitInterface;
import com.example.kupengfinance.Fragment.SettingFragment;
import com.example.kupengfinance.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChangePasswordActivity extends AppCompatActivity {

    ImageView cancel;
    Button confirm;
    EditText newPass;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        confirm = (Button)findViewById(R.id.button);
        newPass = (EditText)findViewById(R.id.newpassword) ;
        sharedPreferences = getSharedPreferences("USERID", Context.MODE_PRIVATE);
        int id = sharedPreferences.getInt("USERID", 0);



        cancel = (ImageView) findViewById(R.id.cancelchange);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent (ChangePasswordActivity.this, MainActivity.class);
                startActivity(loginIntent);
            }

        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( newPass.getText().toString().equals("")){
                    Toast.makeText(ChangePasswordActivity.this, "Please Fill The Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    handleChangePass(id, newPass.getText().toString());
                    Toast.makeText(ChangePasswordActivity.this, "Succed changed Password", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ChangePasswordActivity.this, SignInActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void handleChangePass(int id, String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://kucing-finance-backend-production.up.railway.app/user/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        ChangePass_model changePass_model = new ChangePass_model(id, password);

        Call<ChangePass_model> call = retrofitInterface.excuteChangePass(changePass_model);

        call.enqueue(new Callback<ChangePass_model>() {
            @Override
            public void onResponse(Call<ChangePass_model> call, Response<ChangePass_model> response) {
                if (response.code() == 200){
                    Toast.makeText(ChangePasswordActivity.this, "User Updated Successfully", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(ChangePasswordActivity.this, SignInActivity.class);
                    startActivity(intent);
                } else if (response.code() == 400){
                    Toast.makeText(ChangePasswordActivity.this, "Action failed", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onFailure(Call<ChangePass_model> call, Throwable t) {
                Toast.makeText(ChangePasswordActivity.this, "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
