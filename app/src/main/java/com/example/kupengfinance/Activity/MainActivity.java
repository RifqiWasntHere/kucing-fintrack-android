package com.example.kupengfinance.Activity;

import android.os.Bundle;

import com.example.kupengfinance.Fragment.AccountFragment;
import com.example.kupengfinance.Fragment.HomeFragment;
import com.example.kupengfinance.Fragment.LogoutFragment;
import com.example.kupengfinance.Fragment.TransactionFragment;
import com.example.kupengfinance.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
    implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.transaction);
    }
    HomeFragment homeFragment = new HomeFragment();
    TransactionFragment transactionFragment = new TransactionFragment();
    AccountFragment accountFragment = new AccountFragment();
    LogoutFragment logoutFragment = new LogoutFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, homeFragment)
                        .commit();
                return true;

            case R.id.transaction:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment,transactionFragment)
                        .commit();
                return true;

            case R.id.account:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, accountFragment)
                        .commit();
                return true;

            case R.id.logout:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.flFragment, logoutFragment)
                        .commit();
                return true;
        }
        return false;
    }
}
