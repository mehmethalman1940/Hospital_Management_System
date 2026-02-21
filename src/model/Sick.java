package model;

import enums.BloodGroup;

public class Sick extends Person{

    private int TCNo;
    private BloodGroup bloodGroup;
    private String medicalHistory;
    private Prescription activePrescription;

    public Sick(int id, String name, String surName, int phoneNumber, int TCNo, BloodGroup bloodGroup, String medicalHistory, Prescription activePrescription) {
        super(id, name, surName, phoneNumber);
        this.TCNo = TCNo;
        this.bloodGroup = bloodGroup;
        this.medicalHistory = medicalHistory;
        this.activePrescription = activePrescription;
    }
    public Sick(int id, String name,String surName, int phoneNumber ){
        super(id,name,surName,phoneNumber);
    }

    public int getTCNo() {
        return TCNo;
    }

    public void setTCNo(int TCNo) {
        this.TCNo = TCNo;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Prescription getActivePrescription() {
        return activePrescription;
    }

    public void setActivePrescription(Prescription activePrescription) {
        this.activePrescription = activePrescription;
    }

    @Override
    public String role() {
        return "";
    }

    @Override
    public void readInformation() {
        System.out.println("Name: "+getName());
        System.out.println("Sur Name: "+getSurName());
        System.out.println("Phone Number"+getPhoneNumber());
        System.out.println("Blood Group: "+getBloodGroup());
        System.out.println("Active Prescription: "+getActivePrescription());
        System.out.println("Medical History: "+getMedicalHistory());
    }
}
