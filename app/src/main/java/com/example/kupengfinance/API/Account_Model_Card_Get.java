package com.example.kupengfinance.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account_Model_Card_Get {

    @SerializedName("userId")
    @Expose
    public  int userId;

    public Account_Model_Card_Get(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
