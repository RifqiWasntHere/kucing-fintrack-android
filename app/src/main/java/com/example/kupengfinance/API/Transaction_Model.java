package com.example.kupengfinance.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction_Model {

    @SerializedName("userId")
    public int userId;
    @SerializedName("transAccount")
    @Expose
    public int transAccount;
    @SerializedName("cateId")
    @Expose
    public int cateId;
    @SerializedName("transType")
    @Expose
    public String transType;
    @SerializedName("transAmount")
    @Expose
    public float transAmount;
    @SerializedName("transNote")
    @Expose
    public String transNote;
    @SerializedName("month")
    @Expose
    public int month;
    @SerializedName("year")
    @Expose
    public int year;

    public Transaction_Model(int userId, int transAccount, int cateId, String transType, float transAmount, String transNote) {
        this.userId = userId;
        this.transAccount = transAccount;
        this.cateId = cateId;
        this.transType = transType;
        this.transAmount = transAmount;
        this.transNote = transNote;
    }

    public Transaction_Model(int userId, int month, int year){
        this.userId = userId;
        this.month = month;
        this.year = year;
    }

    public Transaction_Model(){

    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTransAccount() {
        return transAccount;
    }

    public void setTransAccount(int transAccount) {
        this.transAccount = transAccount;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public float getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(float transAmount) {
        this.transAmount = transAmount;
    }

    public String getTransNote() {
        return transNote;
    }

    public void setTransNote(String transNote) {
        this.transNote = transNote;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
