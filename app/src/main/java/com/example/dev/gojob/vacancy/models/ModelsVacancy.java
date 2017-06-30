package com.example.dev.gojob.vacancy.models;

/**
 * Created by d1mys1klapo4ka on 01.06.2017.
 */

public class ModelsVacancy {

    private int id;
    private String name;
    private String address;
    private String phone;
    private String price;

    public ModelsVacancy(String name, String address, String phone, String price){

        this.name = name;
        this.address = address;
        this.phone = phone;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}


