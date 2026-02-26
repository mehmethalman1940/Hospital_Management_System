package model;

import java.time.LocalDate;

public class Nurse extends Person {

    private String shift;
    private String department;

    public Nurse(int id, String name, String surName, int phoneNumber, String shift, String department) {
        super(id, name, surName, phoneNumber);
        this.shift = shift;
        this.department = department;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String role() {
        return "";
    }

    @Override
    public void readInformation() {
        System.out.println("Name: "+ getName());
        System.out.println("Sur Name: "+getSurName());
        System.out.println("Departmen:"+getDepartment());
        System.out.println("Phone Number: "+getPhoneNumber());
        System.out.println("Shifft: "+getShift());
    }
}
