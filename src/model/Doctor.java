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
    private DoctorsSpecialty expertise;
    private int degreeNo;
    ArrayList<LocalDate> appointmentList = new ArrayList<>();

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

    @Override
    public String role() {
        return "";
    }

    @Override
    public void readInformation(Hospital hospital) {
        System.out.println("--Doktorlar--");
        if (hospital.getDoctorListHashMap().isEmpty()){
            System.out.println("Boş");
        }
        for (Doctor doctor : hospital.getDoctorListHashMap().values()) {
            System.out.println("ID: " + doctor.getId());
            System.out.println("Ad: " + doctor.getName());
            System.out.println("Soyad: " + doctor.getSurName());
            System.out.println("Telefon: " + doctor.getPhoneNumber());
            System.out.println("Uzmanlık: " + doctor.getExpertise());
            System.out.println("Diploma No: " + doctor.getDegreeNo());
            System.out.println("------------------------");
        }
    }

    public void addDoctor(Hospital hospital){
        System.out.print("Doktorun Id'sini Giriniz: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        while (hospital.getDoctorListHashMap().containsKey(id)){
            System.out.print("Bu id mevcut yani id giriniz: ");
            id = scanner.nextInt();
        }
        this.setId(id);
        System.out.print("Doktorun Adını Giriniz: ");
        String name = scanner.nextLine();
        this.setName(name);
        System.out.print("Doktorun Soy Adını Giriniz: ");
        String surName = scanner.nextLine();
        this.setSurName(surName);
        System.out.print("Doktorun Telefon Numarasını Giriniz: ");
        int phoneNumber = scanner.nextInt();
        this.setPhoneNumber(phoneNumber);
        System.out.print("Doktor Uzmanlık Alanları... ");
        for (DoctorsSpecialty doctorsSpecialty1 :DoctorsSpecialty.values()){
            System.out.println((doctorsSpecialty1.ordinal()+1)+ " - "+ doctorsSpecialty1);
        }
        System.out.print("Doktorun Uzmanlık Alanı Numarasını Giriniz: ");
        int secim= scanner.nextInt();
        boolean gecerlimi= false;
        while (gecerlimi){
            if (secim>0 &&  secim<9 ){
                System.out.println("Uzmanlık Alanı Başarı ile eklendi...");
                gecerlimi = true;
            }
            else {
                System.out.println("Geçersiz seçim yaptınız 1-9 arası bir rakam giriniz...");
                gecerlimi = false;
            }
        }
        DoctorsSpecialty expertise = DoctorsSpecialty.values()[secim -1];
        this.setExpertise(expertise);
        System.out.print("Doktorun diploma notunu giriniz: ");
        int degreeNo = scanner.nextInt();
        this.setDegreeNo(degreeNo);
        hospital.addDoctorToMap(this);
    }


    @Override
    public void createPrescription() {
        /*System.out.print("Reçete no giriniz: ");
        String prescriptionNo = scanner.nextLine();
        System.out.println("Doktorlar... ");
        for (Doctor doctor:hospital.getDoctorListHashMap().values()){
            System.out.print("Doktorun Adı: "+ doctor.getName()+" ");
            System.out.println(doctor.getSurName());
            System.out.println("Doktorun Id'si: "+ doctor.getId());
        }
        System.out.print("Seçmek istediğiniz doktorun id'sini giriniz: ");
        int doctorId = scanner.nextInt();
        Doctor doctor = hospital.getDoctorListHashMap().get(doctorId);
        System.out.println("Hastalar...");
        for (Sick sick:hospital.getSickListHashMap().values()){
            System.out.println("Hasta Adı: "+ sick.getName()+ " " + sick.getSurName());
            System.out.println("Hastanın Id'si: "+ sick.getId());
        }
        System.out.print("Reçete yazılan hasta id'sini seçiniz: ");
        int sickId = scanner.nextInt();
        Sick sick = hospital.getSickListHashMap().get(sickId);
        System.out.println("İlaç adı Giriniz: ");
        prescription.setMedicines().add(medicine)
        System.out.println("Reçetenin tarihi oluşturuldu...");
        LocalDate nowDate = LocalDate.now();
        System.out.println("Günde kaç adet kullanılmalı: ");
        int usagePeriodDay = scanner.nextInt();
        System.out.println("Reçete onaylansınmı(1 yada 2 seçiniz): ");
        int secim = scanner.nextInt();
        boolean isActive;
        if (secim == 1){
            isActive= true;
        }
        else {
            isActive=false;
        }
        Prescription prescription = new Prescription(prescriptionNo,doctor,sick,medicine, nowDate,usagePeriodDay,isActive);
    */}
}
