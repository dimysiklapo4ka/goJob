package com.example.dev.gojob.serverUtils.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by d1mys1klapo4ka on 22.06.2017.
 */

public interface VacanciesInterface {

    /**t.string "name"
     t.integer "specialty_vacancy_id"
     t.decimal "salary"
     t.string "job_period"
     t.datetime "job_start"
     t.string "job_form"
     t.decimal "cost_house"
     t.string "duties"
     t.integer "amount_seats"
     t.string "place_work"
     t.string "responsibility"
     t.string "making_decisions"
     t.string "job_period"
     t.string "experience"
     t.string "comp_service"
     t.string "languages"
     t.string "courses"
     t.string "knowledge"
     t.string "skills"
     t.string "privileges"
     t.string "equipment"
     */

    @FormUrlEncoded
    @POST("/api/v1/vacancies")
    Call<Void> addVacancy(@Field("vacancy[name]") String name, @Field("vacancy[specialty_vacancy_id]") int specialtyVacancyId,
                          @Field("vacancy[salary]") double salary, @Field("vacancy[experience]") String experience,
                          @Field("vacancy[languages]") String languages, @Field("vacancy[courses]") String courses,
                          @Field("vacancy[skills]") String skills);
}
