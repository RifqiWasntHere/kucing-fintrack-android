package com.example.kupengfinance.API;

import com.google.gson.annotations.SerializedName;

public class LoginResult {

    private String username;
    private String email;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
