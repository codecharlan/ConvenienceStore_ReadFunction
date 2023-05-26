package com.codecharlan.conveniencestore.model;

import com.codecharlan.conveniencestore.enums.Gender;

public abstract class People {
    private String name;
    private Gender gender;
    private String address;


    public People(String name, Gender gender, String address) {
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                '}';
    }
}
