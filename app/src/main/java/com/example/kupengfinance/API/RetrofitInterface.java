package com.example.kupengfinance.API;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("/login")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    @POST("/signup")
    Call<Void> executeSignUp(@Body HashMap<String, String> map);

//    @FormUrlEncoded
//    @POST("signUp")
//    Call<ResponseBody> signUp(
//            @Field("username") String username,
//            @Field("email") String email,
//            @Field("password") String password
//    );


}
