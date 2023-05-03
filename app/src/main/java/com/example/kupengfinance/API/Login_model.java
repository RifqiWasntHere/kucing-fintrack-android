package com.example.kupengfinance.API;

public class Login_model {

    private String email, password;

    public Login_model(String email, String password){
        this.email = email;
        this.password = password;
    }
    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {

        this.email = email;
    }
    public void setPassword(String password) {

        this.password = password;
    }


}
