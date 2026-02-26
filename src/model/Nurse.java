package model;

import main.Hospital;

import java.time.LocalDate;
import java.util.Scanner;

public class Nurse extends Person {
    Scanner scanner = new Scanner(System.in);

    private String shift;
    private String department;


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
    public void readInformation(Hospital hospital) {
        for(Nurse nurse : hospital.getNurseList()){
            System.out.println("ID: "+ nurse.getId());
            System.out.println("Ad: "+ nurse.getName());
            System.out.println("Soyad: "+ nurse.getSurName());
            System.out.println("Telefon: "+ nurse.getPhoneNumber());
            System.out.println("Vardiya: "+ nurse.getShift());
            System.out.println("Departman: "+ nurse.getDepartment());
        }
    }

    public void addNurse(Hospital hospital){
        System.out.print("Hemşire Id'sini giriniz: ");
        int id = scanner.nextInt();
        while (hospital.getNurseList().contains(id)){
            System.out.print("Mevcut İd gitdiniz yeni id: ");
            id =scanner.nextInt();
        }
        this.setId(id);
        System.out.print("Hemşire adını giriniz: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        this.setName(name);
        System.out.print("Hemşire soyadını giriniz: ");
        String surName = scanner.nextLine();
        this.setSurName(surName);
        System.out.print("Hemşire telefon numarasını giriniz: ");
        int phoneNumber = scanner.nextInt();
        this.setPhoneNumber(phoneNumber);
        System.out.print("Hemşire vardiyasını giriniz(gece-gündüz): ");
        String shift = scanner.nextLine();
        this.setShift(shift);
        System.out.print("Hemşire departmanını giriniz: ");
        String department = scanner.nextLine();
        this.setDepartment(department);
        hospital.addNurse(this);
    }
}
