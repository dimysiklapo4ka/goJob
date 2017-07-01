package com.example.dev.gojob.serverUtils.api;

import com.example.dev.gojob.serverUtils.retrofitModel.UserModel;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.PATCH;
import retrofit2.http.POST;

/**
 * Created by d1mys1klapo4ka on 22.06.2017.
 */

public interface UserInterface {

    @FormUrlEncoded
    @POST("/api/v1/users/create")
    Call<UserModel> addUser(@Field("user[name]") String name, @Field("user[middle_name]") String middleName,
                            @Field("user[surname]") String surname, @Field("user[phone]") String phone,
                            @Field("user[address]") String address, @Field("user[email]") String email,
                            @Field("user[password]") String password, @Field("user[password_confirmation]") String passwordConfirm);


    @PATCH("/api/v1/users/update")
    Call<UserModel> updateUser(@Header("[HTTP_API_TOKEN]") String token);


    @DELETE("/api/v1/users/delete")
    Call<UserModel> deleteUser(@Header("[HTTP_API_TOKEN]") String token);

    @FormUrlEncoded
    @POST("/api/v1/sessions/login")
    Call<UserModel> loginUser(@Field("user[email]") String email,
                              @Field("user[password]") String password);


    @DELETE("/api/v1/sessions/logout")
    Call<UserModel> logoutUser(@Header("[HTTP_API_TOKEN]") String token);
}
