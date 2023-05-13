package com.example.kupengfinance.API;

public class Otp_model {
    private String otp;
    private String email;

    public Otp_model(String otp, String email){
        this.otp = otp;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOTP() {
        return otp;
    }

    public void setOTP(String email) {
        this.otp = otp;
    }
}
