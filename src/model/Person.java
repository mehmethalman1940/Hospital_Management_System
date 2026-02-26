package model;

import main.Hospital;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    private int id;
    private String name;
    private String surName;
    private int phoneNumber;

    public Person(){}

    public Person(int id, String name, String surName, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.phoneNumber = phoneNumber;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public abstract String role();

    public abstract void readInformation(Hospital hospital);




}
