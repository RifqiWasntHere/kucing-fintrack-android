package com.example.kupengfinance.API;

public class Login_model {

    private String email, pass;
    private int userId;

    public Login_model(String email, String pass){
        this.email = email;
        this.pass = pass;
    }
    public Login_model(int userId){
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return pass;
    }

    public void setEmail(String email) {

        this.email = email;
    }
    public void setPass(String pass) {

        this.pass = pass;
    }


}
