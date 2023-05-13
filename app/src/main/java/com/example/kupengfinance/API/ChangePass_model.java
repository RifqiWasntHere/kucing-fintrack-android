package com.example.kupengfinance.API;

public class ChangePass_model {
    private int id;
    private String pass;

    public ChangePass_model(int id,  String pass) {
        this.id = id;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
