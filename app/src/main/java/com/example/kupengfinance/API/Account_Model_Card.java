package com.example.kupengfinance.API;

public class Account_Model_Card {

    public  String userId;
    public String cardName;
    public String cardBalance;

    public Account_Model_Card(String userId, String cardName, String cardBalance) {
        this.userId = userId;
        this.cardName = cardName;
        this.cardBalance = cardBalance;
    }

    public String getUserId() {
        return userId;
    }

    public String getCardName() {
        return cardName;
    }

    public String getCardBalance() {
        return cardBalance;
    }
}
