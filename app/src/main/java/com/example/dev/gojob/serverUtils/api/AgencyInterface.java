package com.example.dev.gojob.serverUtils.api;

import com.example.dev.gojob.serverUtils.retrofitModel.AgencyList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by d1mys1klapo4ka on 17.06.2017.
 */

public interface AgencyInterface {

    @GET("/api/v1/agencies")
    Call<AgencyList> getAllData();

    @POST("/api/v1/agencies")
    Call addAgency(@Field("name") String name, @Field("price") String price, @Field("phone") String phone,
                   @Field("address") String address, @Field("schrdule") String schrdule,
                   @Field("requisites") String requisites, @Field("credit_card") String creditCard);

}
