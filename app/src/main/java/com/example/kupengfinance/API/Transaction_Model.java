package com.example.kupengfinance.API;

public class Transaction_Model {

    public  String category;
    public String transaction;
    public String account;
    public String cash;

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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setCash(String cash) {
        this.cash = cash;
    }
}
