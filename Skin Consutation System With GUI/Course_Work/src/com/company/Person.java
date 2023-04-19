package com.company;

import java.util.Date;

public class Person {
    private String name;
    private String sur_name;
    private String date_of_birth;
    private int mobile_number;

    public Person(String name, String sur_name, String date_of_birth, int mobile_number) {
        this.name = name;
        this.sur_name = sur_name;
        this.date_of_birth = date_of_birth;
        this.mobile_number = mobile_number;
    }

    public Person() {
    }

    public void setName(String name) {
        this.name=name;
    }
    public String getName() {

        return name;
    }

    public void setSur_name(String sur_name) {

        this.sur_name = sur_name;
    }

    public String getSur_name() {
        return sur_name;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setMobile_number(int mobile_number) {
        this.mobile_number = mobile_number;
    }

    public int getMobile_number() {
        return mobile_number;
    }
}
