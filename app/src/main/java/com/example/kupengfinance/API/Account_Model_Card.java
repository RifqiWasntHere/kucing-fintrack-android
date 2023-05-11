package com.example.kupengfinance.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account_Model_Card {

    @SerializedName("userId")
    public  int userId;
    @SerializedName("cardName")
    @Expose
    public String cardName;
    @SerializedName("cardBalance")
    @Expose
    public float cardBalance;

    public Account_Model_Card(int userId, String cardName, float cardBalance) {
        this.userId = userId;
        this.cardName = cardName;
        this.cardBalance = cardBalance;
    }
    public Account_Model_Card(int userId) {
        this.userId = userId;
    }
    public Account_Model_Card(){

    }

    public int getUserId() {
        return userId;
    }

    public String getCardName() {
        return cardName;
    }

    public float getCardBalance() {
        return cardBalance;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setCardBalance(float cardBalance) {
        this.cardBalance = cardBalance;
    }
}
