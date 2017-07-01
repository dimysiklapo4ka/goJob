package com.example.dev.gojob.serverUtils.retrofitModel;

/**
 * Created by d1mys1klapo4ka on 17.06.2017.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AgencyList {

    @SerializedName("agencies")
    @Expose
    private List<Agency> agencies = null;

    public List<Agency> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agency> agencies) {
        this.agencies = agencies;
    }

}