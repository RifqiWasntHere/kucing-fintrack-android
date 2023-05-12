package com.example.kupengfinance.API;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction_Model {

    @SerializedName("userId")
    public int userId;
    @SerializedName("category")
    @Expose
    public int category;
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
    @SerializedName("transCash")
    @Expose
    public int transCash;
    @SerializedName("transCard")
    @Expose
    public @Nullable  Integer transCard;

    //need to be fixed
    public Transaction_Model(int userId, int transCash, @Nullable Integer transCard, int category, String transType, float transAmount, String transNote) {
        this.userId = userId;
        this.transCash = transCash;
        this.transCard = transCard;
        this.category = category;
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

    public int getTransCash() {
        return transCash;
    }

    public void setTransCash(int transCash) {
        this.transCash = transCash;
    }

    public int getTransCard() {
        return transCard;
    }

    public void setTransCard(int transCard) {
        this.transCard = transCard;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int cateId) {
        this.category = category;
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
