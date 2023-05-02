package com.example.kupengfinance.API;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/login/")
    Call<Signup_model> executeLogin(@Body HashMap<String, String> map);

    @POST("signup/")
    Call<Signup_model> createSignUp(@Body Signup_model signup_model);

}
