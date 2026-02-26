package main;

import enums.AppointmentStatus;
import enums.BloodGroup;
import enums.DoctorsSpecialty;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hospital {
    Scanner scanner = new Scanner(System.in);


    private String name;
    HashMap<Integer, Doctor> doctorListHashMap = new HashMap<Integer, Doctor>();
    HashMap<Integer, Sick> sickListHashMap = new HashMap<Integer, Sick>();
    ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
    ArrayList<Prescription> prescriptionList = new ArrayList<Prescription>();
    ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
    DoctorsSpecialty doctorsSpecialty;
    private Sick sick;

    public HashMap<Integer, Doctor> getDoctorListHashMap() {
        return doctorListHashMap;
    }

    public void setDoctorListHashMap(HashMap<Integer, Doctor> doctorListHashMap) {
        this.doctorListHashMap = doctorListHashMap;
    }

    public HashMap<Integer, Sick> getSickListHashMap() {
        return sickListHashMap;
    }

    public void addDoctor(){
        System.out.print("Doktorun Id'sini Giriniz: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        for (Doctor doctor: doctorListHashMap.values()){
            if (doctor.getId() == id){
                System.out.println("Aynı id'ye sahip doktor mevcut yeni id giriniz");
                id = scanner.nextInt();
            }
            else {
                System.out.println("Id başarı ile eklendi...");
            }
        }
        System.out.print("Doktorun Adını Giriniz: ");
        String name = scanner.nextLine();

        System.out.print("Doktorun Soy Adını Giriniz: ");
        String surName = scanner.nextLine();
        System.out.print("Doktorun Telefon Numarasını Giriniz: ");
        int phoneNumber = scanner.nextInt();
        System.out.print("Doktor Uzmanlık Alanları... ");
        for (DoctorsSpecialty doctorsSpecialty1 :DoctorsSpecialty.values()){
            System.out.println((doctorsSpecialty1.ordinal()+1)+ " - "+ doctorsSpecialty1);
        }
       int secim;

        System.out.print("Doktorun Uzmanlık Alanını Numarasını Giriniz: ");
        secim= scanner.nextInt();
        if (secim>0 &&  secim<9 ){
            System.out.println("Uzmanlık Alanı Başarı ile eklendi...");
        }
        if (secim<0||secim>9){
            System.out.println("Geçersiz seçim yaptınız 1-9 arası bir rakam giriniz...");
            secim = scanner.nextInt();
        }
        DoctorsSpecialty expertise = DoctorsSpecialty.values()[secim +1];
        System.out.print("Doktorun diploma notunu giriniz: ");
        int degreeNo = scanner.nextInt();
        Doctor doctor1 = new Doctor(id,name,surName,phoneNumber,expertise,degreeNo);
        doctorListHashMap.put(id,doctor1);
        System.out.println(" ---Ekleme işlemi tamamlandı---");
    }

    public void addSick(){
        System.out.print("Hastanın Id'sini giriniz:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Hastanın adını giriniz: ");
        String name = scanner.nextLine();
        System.out.print("Hatsanın soyadını giriniz: ");
        String surName = scanner.nextLine();
        System.out.print("Hastanın telefon numarasını giriniz: ");
        int phoneNumber = scanner.nextInt();
        System.out.print("Hastanın TC Numarsaını giriniz: ");
        int TCNo = scanner.nextInt();
        System.out.print("Kan Grupları... ");
        for (BloodGroup bloodGroup :BloodGroup.values()){
            System.out.println((bloodGroup.ordinal()+1)+ " - "+ bloodGroup);
        }
        System.out.print("Hastanın kan grubunu giriniz: ");
        int secim1 = scanner.nextInt();
        BloodGroup bloodGroup = BloodGroup.values()[secim1+1];
        System.out.print("Hastanın varsa hastalık geçmişini giriniz: ");
        scanner.nextLine();
        String medicalHistory = scanner.nextLine();
        System.out.println("Sistemde reçetesi varsa görünecektir");
        Prescription prescription = null;
        Sick sick1 = new Sick(id,name,surName,phoneNumber,TCNo,bloodGroup,medicalHistory,prescription);
        sickListHashMap.put(id,sick1);
    }

    public void addNurse(){
        System.out.print("Hemşire Id'sini giriniz: ");
        int id = scanner.nextInt();
        System.out.print("Hemşire adını giriniz: ");
        String name = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Hemşire soyadını giriniz: ");
        String surName = scanner.nextLine();
        System.out.print("Hemşire telefon numarasını giriniz: ");
        int phoneNumber = scanner.nextInt();
        System.out.print("Hemşire vardiyasını giriniz(gece-gündüz): ");
        String shift = scanner.nextLine();
        System.out.print("Hemşire departmanını giriniz: ");
        String department = scanner.nextLine();
        Nurse nurse1 = new Nurse(id,name,surName,phoneNumber,shift,department);
        nurseList.add(nurse1);
        System.out.println("----Hemşire Başarı İle Eklendi----");
    }

    public void listNurse(){
        for(Nurse nurse : nurseList){
            System.out.println("ID: "+ nurse.getId());
            System.out.println("Ad: "+ nurse.getName());
            System.out.println("Soyad: "+ nurse.getSurName());
            System.out.println("Telefon: "+ nurse.getPhoneNumber());
            System.out.println("Vardiya: "+ nurse.getShift());
            System.out.println("Departman: "+ nurse.getDepartment());
        }
    }

    public void listDoctors(){
        System.out.println("--Doktorlar--");
        for (Doctor doctor : doctorListHashMap.values()) {
            System.out.println("ID: " + doctor.getId());
            System.out.println("Ad: " + doctor.getName());
            System.out.println("Soyad: " + doctor.getSurName());
            System.out.println("Telefon: " + doctor.getPhoneNumber());
            System.out.println("Uzmanlık: " + doctor.getExpertise());
            System.out.println("Diploma No: " + doctor.getDegreeNo());
            System.out.println("------------------------");
        }
    }

    public void listSick(){
        for (Sick sick : sickListHashMap.values()){
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

    public void searchSick(){
        System.out.print("Aramak istediğiniz hastanın TC'sini giriniz: ");
        int selectedTC = scanner.nextInt();
        for (Sick sick: sickListHashMap.values()){
            if (selectedTC == sick.getTCNo()){
                System.out.println("Aradığınız Hasta Mevcut: "+ sick.getName());
            }
            else {
                System.out.println("Aradığınız Hasta bulunamadı...");
            }
        }
    }

    public void sickHistory(){
        System.out.print("Hastnaın Hastalık Geçmişi: ");
        for (Sick sick: sickListHashMap.values()) {
            System.out.println(sick.getMedicalHistory());
        }
    }

    public void updateSickİnformation(){
        System.out.println("----Hastalar----");
        listSick();
        System.out.print("Güncellemek istediğiniz hasta id'sini giriniz: ");
        int updateSickId = scanner.nextInt();
        for (Sick sick : sickListHashMap.values()){
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
                System.out.println("Yeni soyad: "+sick.getSurName());
            }
            else {
                System.out.println("Hasta bulunamadı...");
            }
        }
    }

    public void creatAppointment(){
        System.out.print("Oluşturmak istrediğiniz randevu Id'sini giriniz: ");
        String id = scanner.nextLine();
        for (Appointment appointment: appointmentList){
            if (appointment.getId().equals(id)){
                System.out.println("Aynı id'ye sahip randevu bulunmakta yeni id giriniz: ");
                id=scanner.nextLine();
            }
        }
        System.out.println("Hasta Bilgileri...");
        for (Sick sick:sickListHashMap.values()){
            System.out.println("-------");
            System.out.println("Hasta adı: "+ sick.getName());
            System.out.println("Hasta Id'si: "+ sick.getId());
        }
        System.out.println("Randevu almak istediğiniz hastanın id'sini giriniz: ");
        int secimSick = scanner.nextInt();
        Sick sick = sickListHashMap.get(secimSick);

        System.out.println("Doktor bilgileri");
        for (Doctor doctor: doctorListHashMap.values()){
            System.out.println("-------");
            System.out.println("Doktor Id'si: "+ doctor.getId());
            System.out.println("Doktor adı: "+ doctor.getName());
        }
        System.out.println("Randevu almak istediğiniz doktorun id'sini giriniz: ");
        int secimDoctor= scanner.nextInt();
        scanner.nextLine();
        Doctor doctor = doctorListHashMap.get(secimDoctor);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.print("Lütfen randevu almak istediğiniz tarihi giriniz (gg.AA.yyyy): ");
        String girilenTarih = scanner.nextLine();
        LocalDate date = LocalDate.parse(girilenTarih, formatter);
        System.out.print("Lütfen randevu almak istediğiniz saati giriniz (SS:dd örneğin 14:30): ");
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("HH:mm");
        String girilenZaman = scanner.nextLine();
        LocalTime time = LocalTime.parse(girilenZaman, zamanFormati);
        System.out.println("Randevu Statusu");
        for (AppointmentStatus appointmentStatus: AppointmentStatus.values()){
            System.out.println((appointmentStatus.ordinal()+1)+ "-" +appointmentStatus);
        }
        System.out.println("Randevu statusu sırasını giriniz: ");
        int secimStatus = scanner.nextInt();
        AppointmentStatus status= AppointmentStatus.values()[secimStatus-1];
        System.out.print("Hastanın bir şikayeti varsa giriniz: ");
        String complaint = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Hastanın bir notu varsa giriniz: ");
        String notes = scanner.nextLine();
        Appointment appointment = new Appointment(id,sick,doctor,date,time,complaint,status,notes);
        appointmentList.add(appointment);
    }

    public void listAppointment(){
        for (Appointment appointment: appointmentList){
            System.out.println("-----");
            System.out.println("Id: "+ appointment.getId());
            System.out.println("Hasta: "+appointment.getSick().getName());
            System.out.println("Doctor: "+appointment.getDoctor().getName());
            System.out.println("Status: "+appointment.getStatus());
            System.out.println("Tarih: "+appointment.getDate());
            System.out.println("Zaman: "+ appointment.getTime());
            System.out.println("Not: "+appointment.getNotes());
            System.out.println("Şikayet: "+ appointment.getComplaint());
        }
    }

    public void canceledAppointment(){
        listAppointment();
        System.out.print("İptal etmek istediğiniz randevunun id'sini giriniz: ");
        String canceledId = scanner.nextLine();
        for (Appointment appointment: appointmentList){
            if (appointment.getId().equals(canceledId)){
                appointment.setStatus(AppointmentStatus.CANCELED);
                System.out.println("Randevunuz iptal edilmiştir...");
            }
        }
        listAppointment();
    }

    public void newAppointmentStatus(){
        for (Appointment appointment: appointmentList){
            System.out.println("Id: "+appointment.getId());
            System.out.println("Ad: "+ appointment.getSick().getName());
            System.out.println("Soyad: "+ appointment.getSick().getSurName());
            System.out.println("Tarih: "+ appointment.getDate());
            System.out.println("Saat: "+ appointment.getTime());
            System.out.println("Durum: "+ appointment.getStatus());
        }
        System.out.println("Durumunu güncellemek istediğiniz id'yi seçiniz: ");
        String id = scanner.nextLine();
        for (Appointment appointment: appointmentList){
            if (appointment.getId().equals(id)){
                System.out.println("0-PENDING,\n" +
                        "    1-APPROVED,\n" +
                        "    2-COMPLETED,\n" +
                        "    3-CANCELED,\n" +
                        "    4-NOTRECEIVED");
                System.out.print("Yeni durumunuzu seçiniz: ");
                int secim = scanner.nextInt();
                AppointmentStatus yeniDurum = AppointmentStatus.values()[secim];
                appointment.setStatus(yeniDurum);
                System.out.println("Randevunuz Güncellendi...");
                System.out.println(appointment.getSick().getName());
                System.out.println(appointment.getSick().getSurName());
                System.out.println(appointment.getStatus());
                System.out.println(appointment.getDate());
                System.out.println(appointment.getTime());
            }
        }
    }


}
