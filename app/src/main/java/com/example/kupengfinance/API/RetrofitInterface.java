package com.example.kupengfinance.API;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

public interface RetrofitInterface {

    //USERS
    @POST("signin/")
    Call<Login_model> executeLogin(@Body Login_model login_model);

    @POST("signup/")
    Call<Signup_model> createSignUp(@Body Signup_model signup_model);

    @POST("forpassemail/")
    Call<ForgetPass_model> executeForgetEmail(@Body ForgetPass_model forgetPass_model);

    @POST("forpassotp/")
    Call<Otp_model> executeForgetOtp(@Body Otp_model otp_model);

    @PATCH("update/")
    Call<ChangePass_model> excuteChangePass(@Body ChangePass_model changePass_model);

    //TRANSACTIONS
    @POST("transactions/get")
    Call<List<Transaction_Model>> getTrans(@Body Transaction_Model transaction_model);

    @POST("transactions/add")
    Call<Transaction_Model> addTrans(@Body Transaction_Model transaction_model);

    //ACCOUNTS
    @POST("cash/add/")
    Call<Account_Model_Cash> addCash(@Body Account_Model_Cash account_model_cash);

    @POST("cash/get")
    Call<List<Account_Model_Cash>> getCash(@Body Account_Model_Cash account_model_cash);

    @POST("card/add/")
    Call<Account_Model_Card> addCard(@Body Account_Model_Card account_model_card);

    @POST("card/get")
    Call<List<Account_Model_Card>> getCard(@Body Account_Model_Card account_model_card);

}
