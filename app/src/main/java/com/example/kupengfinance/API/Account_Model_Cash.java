package com.example.kupengfinance.API;

public class Account_Model_Cash {

    public  String userId;
    public String cashName;
    public String cashBalance;

    public Account_Model_Cash(String userId, String cashName, String cashBalance) {
        this.userId = userId;
        this.cashName = cashName;
        this.cashBalance = cashBalance;
    }


    public String getUserId() {
        return userId;
    }

    public String getCashName() {
        return cashName;
    }

    public String getCashBalance() {
        return cashBalance;
    }
}
