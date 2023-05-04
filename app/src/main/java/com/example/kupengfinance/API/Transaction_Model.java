package com.example.kupengfinance.API;

public class Transaction_Model {

    String category, transaction, account, cash;

    public Transaction_Model(String category, String transaction, String account, String cash) {
        this.category = category;
        this.transaction = transaction;
        this.account = account;
        this.cash = cash;
    }

    public String getCategory() {
        return category;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getAccount() {
        return account;
    }

    public String getCash() {
        return cash;
    }
}
