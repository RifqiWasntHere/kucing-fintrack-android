package com.example.kupengfinance.API;

public class Signup_model {

    private String username, email, pass;

    public Signup_model(String username, String email, String pass){
        this.username = username;
        this.email = email;
        this.pass = pass;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return pass;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public void setEmail(String email) {

        this.email = email;
    }
    public void setPassword(String password) {

        this.pass = pass;
    }
}
