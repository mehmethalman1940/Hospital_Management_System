package model;

import enums.AppointmentStatus;
import main.Hospital;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Appointment {
    Scanner scanner =new Scanner(System.in);

    private String id;
    private Sick sick;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private AppointmentStatus status;
    private String complaint;
    private String notes;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Sick getSick() {
        return sick;
    }

    public void setSick(Sick sick) {
        this.sick = sick;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentStatus status) {
        this.status = status;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void creatAppointment(Hospital hospital){
        System.out.print("Oluşturmak istrediğiniz randevu Id'sini giriniz: ");
        String id = scanner.nextLine();
        while (hospital.getAppointmentList().contains(id)){
            System.out.print("Girdiğiniz id mevcut yeni id giriniz: ");
            id= scanner.nextLine();
        }
        this.setId(id);
        System.out.println("Hasta Bilgileri...");
        for (Sick sick:hospital.getSickListHashMap().values()){
            System.out.println("-------");
            System.out.println("Hasta adı: "+ sick.getName());
            System.out.println("Hasta Id'si: "+ sick.getId());
        }
        System.out.println("Randevu almak istediğiniz hastanın id'sini giriniz: ");
        int secimSick = scanner.nextInt();
        Sick sick = hospital.getSickListHashMap().get(secimSick);
        this.setSick(sick);
        System.out.println("Doktor bilgileri");
        for (Doctor doctor: hospital.getDoctorListHashMap().values()){
            System.out.println("-------");
            System.out.println("Doktor Id'si: "+ doctor.getId());
            System.out.println("Doktor adı: "+ doctor.getName());
        }
        System.out.println("Randevu almak istediğiniz doktorun id'sini giriniz: ");
        int secimDoctor= scanner.nextInt();
        scanner.nextLine();
        Doctor doctor = hospital.getDoctorListHashMap().get(secimDoctor);
        this.setDoctor(doctor);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.print("Lütfen randevu almak istediğiniz tarihi giriniz (gg.AA.yyyy): ");
        String girilenTarih = scanner.nextLine();
        LocalDate date = LocalDate.parse(girilenTarih, formatter);
        this.setDate(date);
        System.out.print("Lütfen randevu almak istediğiniz saati giriniz (SS:dd örneğin 14:30): ");
        DateTimeFormatter zamanFormati = DateTimeFormatter.ofPattern("HH:mm");
        String girilenZaman = scanner.nextLine();
        LocalTime time = LocalTime.parse(girilenZaman, zamanFormati);
        this.setTime(time);
        System.out.println("Randevu Statusu");
        for (AppointmentStatus appointmentStatus: AppointmentStatus.values()){
            System.out.println((appointmentStatus.ordinal()+1)+ "-" +appointmentStatus);
        }
        System.out.println("Randevu statusu seçiniz: ");
        int secimStatus = scanner.nextInt();
        AppointmentStatus status= AppointmentStatus.values()[secimStatus-1];
        this.setStatus(status);
        System.out.print("Hastanın bir şikayeti varsa giriniz: ");
        String complaint = scanner.nextLine();
        this.setComplaint(complaint);
        scanner.nextLine();
        System.out.print("Hastanın bir notu varsa giriniz: ");
        String notes = scanner.nextLine();
        this.setNotes(notes);
        hospital.creatAppointment(this);
    }

    public void readInformation(Hospital hospital){
        for (Appointment appointment: hospital.getAppointmentList()){
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

    public void canceledAppointment(Hospital hospital){
        readInformation(hospital);
        System.out.print("İptal etmek istediğiniz randevunun id'sini giriniz: ");
        String canceledId = scanner.nextLine();
        for (Appointment appointment: hospital.getAppointmentList()){
            if (appointment.getId().equals(canceledId)){
                appointment.setStatus(AppointmentStatus.CANCELED);
                System.out.println("Randevunuz iptal edilmiştir...");
            }
        }
        readInformation(hospital);
    }

    public  void newAppointmentStatus(Hospital hospital){
        for (Appointment appointment: hospital.getAppointmentList()){
            System.out.println("Id: "+appointment.getId());
            System.out.println("Ad: "+ appointment.getSick().getName());
            System.out.println("Soyad: "+ appointment.getSick().getSurName());
            System.out.println("Tarih: "+ appointment.getDate());
            System.out.println("Saat: "+ appointment.getTime());
            System.out.println("Durum: "+ appointment.getStatus());
        }
        System.out.println("Durumunu güncellemek istediğiniz id'yi seçiniz: ");
        String id = scanner.nextLine();
        for (Appointment appointment: hospital.getAppointmentList()){
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
