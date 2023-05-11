package com.example.kupengfinance.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account_Model_Cash {
    @SerializedName("userId")
    @Expose
    public  int userId;

    @SerializedName("cashName")
    @Expose
    public String cashName;

    @SerializedName("cashBalance")
    @Expose
    public float cashBalance;

    public Account_Model_Cash(int userId, String cashName, float cashBalance) {
        this.userId = userId;
        this.cashName = cashName;
        this.cashBalance = cashBalance;
    }
    public Account_Model_Cash(int userId) {
        this.userId = userId;
    }
    public Account_Model_Cash(){

    }

    public int getUserId() {
        return userId;
    }

    public String getCashName() {
        return cashName;
    }

    public float getCashBalance() {
        return cashBalance;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCashName(String cashName) {
        this.cashName = cashName;
    }

    public void setCashBalance(float cashBalance) {
        this.cashBalance = cashBalance;
    }
}
