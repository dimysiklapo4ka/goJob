package com.example.dev.gojob.serverUtils.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static String BASE_URL = "http://server.gojob.com.ua";

    private static Retrofit getRetrofitInstance(){

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static AgencyInterface getAgencyInterface(){
        return getRetrofitInstance().create(AgencyInterface.class);
    }

    public static UserInterface getUserInterface(){
        return getRetrofitInstance().create(UserInterface.class);
    }

    public static VacanciesInterface getVacancyInterface(){
        return  getRetrofitInstance().create(VacanciesInterface.class);
    }
}
