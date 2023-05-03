package com.example.kupengfinance.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("login/")
    Call<Login_model> executeLogin(@Body Login_model login_model);

    @POST("signup/")
    Call<Signup_model> createSignUp(@Body Signup_model signup_model);

}
