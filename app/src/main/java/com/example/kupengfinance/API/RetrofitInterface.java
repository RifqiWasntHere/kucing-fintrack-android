package com.example.kupengfinance.API;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @POST("signin/")
    Call<Login_model> executeLogin(@Body Login_model login_model);

    @POST("signup/")
    Call<Signup_model> createSignUp(@Body Signup_model signup_model);

    @POST("cash/add/")
    Call<Account_Model_Cash> addCash(@Body Account_Model_Cash account_model_cash);

    @POST("card/add/")
    Call<Account_Model_Card> addCard(@Body Account_Model_Card account_model_card);

    @GET("cash/get/")
    Call<Account_Model_Card> getCard(@Query("userId") int userId);

}
