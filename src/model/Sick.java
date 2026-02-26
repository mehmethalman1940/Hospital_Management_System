package model;

import enums.BloodGroup;
import main.Hospital;

import java.util.Scanner;

public class Sick extends Person{
    Scanner scanner = new Scanner(System.in);

    private int TCNo;
    private BloodGroup bloodGroup;
    private String medicalHistory;
    private Prescription activePrescription;

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

    @Override
    public String role() {
        return "";
    }

    @Override
    public void readInformation(Hospital hospital) {
        System.out.println("--HASTALAR--");
        if (hospital.getSickListHashMap().isEmpty()){
            System.out.println("Boş");
        }
        for (Sick sick : hospital.getSickListHashMap().values()){
            System.out.println("ID: " + sick.getId());
            System.out.println("Ad: " + sick.getName());
            System.out.println("Soyad: " + sick.getSurName());
            System.out.println("Telefon: " + sick.getPhoneNumber());
            System.out.println("Hastalık geçmişi: " + sick.getMedicalHistory());
            System.out.println("Kan Grubu: " + sick.getBloodGroup());
            System.out.println("Aktif Reçete: " + sick.getActivePrescription());
            System.out.println("------------------------");
        }
    }

    public void addSick(Hospital hospital){
        System.out.print("Hastanın Id'sini giriniz:");
        int id = scanner.nextInt();
        while (hospital.getSickListHashMap().containsKey(id)){
            System.out.println("Aynı id'ye sahip başka hasta bulunmakta Yeni id: ");
            id = scanner.nextInt();
        }
        this.setId(id);
        scanner.nextLine();
        System.out.print("Hastanın adını giriniz: ");
        String name = scanner.nextLine();
        this.setName(name);
        System.out.print("Hatsanın soyadını giriniz: ");
        String surName = scanner.nextLine();
        this.setSurName(surName);
        System.out.print("Hastanın telefon numarasını giriniz: ");
        int phoneNumber = scanner.nextInt();
        this.setPhoneNumber(phoneNumber);
        System.out.print("Hastanın TC Numarsaını giriniz: ");
        int TCNo = scanner.nextInt();
        this.setTCNo(TCNo);
        System.out.println("Kan Grupları... ");
        for (BloodGroup bloodGroup :BloodGroup.values()){
            System.out.println((bloodGroup.ordinal()+1)+ " - "+ bloodGroup);
        }
        System.out.print("Hastanın kan grubunu giriniz: ");
        int bloodGrup = scanner.nextInt();
        BloodGroup bloodGroup = BloodGroup.values()[bloodGrup -1];
        this.setBloodGroup(bloodGroup);
        System.out.print("Hastanın varsa hastalık geçmişini giriniz: ");
        scanner.nextLine();
        String medicalHistory = scanner.nextLine();
        this.setMedicalHistory(medicalHistory);
        System.out.println("Sistemde reçetesi varsa görünecektir");
        hospital.addSick(this);
    }

    public void searchSick(Hospital hospital){
        System.out.print("Aramak istediğiniz hastanın TC'sini giriniz: ");
        int selectedTC = scanner.nextInt();
        for (Sick sick:hospital.getSickListHashMap().values() ){
            if (selectedTC == sick.getTCNo()){
                System.out.println("Aradığınız Hasta Mevcut: "+ sick.getName());
            }
            else {
                System.out.println("Aradığınız Hasta bulunamadı...");
            }
        }
    }

    public void sickHistory(Hospital hospital){
        System.out.print("Hastnaın Hastalık Geçmişi: ");
        for (Sick sick: hospital.getSickListHashMap().values()) {
            System.out.println(sick.getMedicalHistory());
        }
    }

    public void updateSickİnformation(Hospital hospital){
        System.out.println("----Hastalar----");
        readInformation(hospital);
        System.out.print("Güncellemek istediğiniz hasta id'sini giriniz: ");
        int updateSickId = scanner.nextInt();
        for (Sick sick : hospital.getSickListHashMap().values()){
            if (updateSickId == sick.getId()){
                System.out.print("Yeni ad: ");
                scanner.nextLine();
                String newName = scanner.nextLine();
                sick.setName(newName);
                System.out.print("Yeni Soyad: ");
                String newSurname= scanner.nextLine();
                sick.setSurName(newSurname);
                System.out.println("Güncellenen bilgiler ile hasta: ");
                System.out.println("Yeni Ad: "+ sick.getName());
                System.out.println("Yeni soyad: "+ sick.getSurName());
            }
            else {
                System.out.println("Hasta bulunamadı...");
            }
        }
    }
}
