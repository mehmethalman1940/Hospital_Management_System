package model;

import enums.DoctorsSpecialty;
import interfaces.IPrescription;
import main.Hospital;

import javax.print.Doc;
import javax.swing.plaf.basic.BasicToolBarUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Person implements IPrescription {
    Scanner scanner = new Scanner(System.in);
    Medicine medicine = new Medicine();
    Hospital hospital = new Hospital();
    Prescription prescription = new Prescription();
    private DoctorsSpecialty expertise;
    private int degreeNo;
    ArrayList<LocalDate> appointmentList = new ArrayList<>();

    public Doctor(int id, String name, String surName, int phoneNumber, DoctorsSpecialty expertise, int degreeNo) {
        super(id, name, surName, phoneNumber);
        this.expertise = expertise;
        this.degreeNo = degreeNo;
    }
    public Doctor(int id, String name, String surName, int phoneNumber){
        super(id, name, surName, phoneNumber);
    }

    public DoctorsSpecialty getExpertise() {
        return expertise;
    }

    public void setExpertise(DoctorsSpecialty expertise) {
        this.expertise = expertise;
    }

    public int getDegreeNo() {
        return degreeNo;
    }

    public void setDegreeNo(int degreeNo) {
        this.degreeNo = degreeNo;
    }

    public ArrayList<LocalDate> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(ArrayList<LocalDate> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @Override
    public String role() {
        return "";
    }

    @Override
    public void readInformation() {
        System.out.println("Id: "+ getId());
        System.out.println("Name: "+getName());
        System.out.println("Surname: "+ getSurName());
        System.out.println("Expertise: "+getExpertise());
        System.out.println("Phone Number: "+getPhoneNumber());
        System.out.println("Degree No: "+getDegreeNo());
    }


    @Override
    public void createPrescription() {
        System.out.print("Reçete no giriniz: ");
        int prescriptionNo = scanner.nextInt();
        System.out.println("İlaç adı Giriniz: ");
        String ilac = scanner.nextLine();
        prescription.getMedicines().add(ilac);
        System.out.println("Reçetenin yazılma tarihini giriniz");
    }
}
