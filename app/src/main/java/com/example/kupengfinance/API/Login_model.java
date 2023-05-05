package com.example.kupengfinance.API;

public class Login_model {

    private String email, pass;

    public Login_model(String email, String pass){
        this.email = email;
        this.pass = pass;
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
