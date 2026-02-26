package main;

import model.Appointment;
import model.Doctor;
import model.Nurse;
import model.Sick;

import java.util.Scanner;


public class Main {

    public static void allReadProcess(){
        System.out.println("---HASTANE yÖNETİM SİSTEMİ---\n"+
                "1. Personel İşlemleri\n" +
                "2. Hasta İşlemleri\n" +
                "3. Randevu İşlemleri");
    }

    public static void personallProcess(){
        System.out.println("----PERSONEL iŞLEMLERİ----");
        System.out.println("1.1. Yeni Doktor Ekle\n" +
                " 1.2. Yeni Hemşire Ekle\n" +
                " 1.3. Doktor Listele \n" +
                " 1.4. Personel Bilgilerini Görüntüle");
        System.out.print("Personel İşleminizi Giriniz: ");
    }

    public static void sickProcess(){
        System.out.println(" ");
        System.out.println("----Hasta İşlemleri----\n" +
                " 2.1. Yeni Hasta Kaydı\n" +
                " 2.2. Hasta Ara (TC/Ad ile)\n" +
                " 2.3. Hasta Geçmişini Görüntüle\n" +
                " 2.4. Hasta Bilgilerini Güncelle");
        System.out.print("Hasta İşlemini Seçiniz: ");
    }

    public static void appointmentProcess(){
        System.out.println("----Randevu İşlemleri----\n" +
                " 3.1. Randevu Oluştur\n" +
                " 3.2. Randevuları Listele\n" +
                " 3.3. Randevu İptal Et\n" +
                " 3.4. Randevu Durumu Güncelle\n");
    }

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Nurse nurse = new Nurse();
        Appointment appointment =new Appointment();
        Scanner scanner = new Scanner(System.in);

        allReadProcess();
        int process;
        System.out.print("Yapmak İstediğiniz İşlemi Giriniz; ");
        process = scanner.nextInt();
        while (true) {
            Doctor doctor = new Doctor();
            Sick sick =new Sick();
            if (process == 1) {
                personallProcess();
                int personnelProcess;
                personnelProcess = scanner.nextInt();
                switch (personnelProcess) {
                    case 1:
                        doctor.addDoctor(hospital);
                        break;
                    case 2:
                        nurse.addNurse(hospital);
                        break;
                    case 3:
                        doctor.readInformation(hospital);
                        break;
                    case 4:
                        System.out.println("----Doktor Listesi----");
                        doctor.readInformation(hospital);
                        System.out.println("----Hemşire Listesi----");
                        nurse.readInformation(hospital);
                        break;
                }
                allReadProcess();
                System.out.print("Yapmak İstediğiniz İşlemi Giriniz; ");
                process = scanner.nextInt();
            }
            if (process ==2){
                sickProcess();
                int sickProcces = scanner.nextInt();

                switch (sickProcces){
                    case 1:
                        sick.addSick(hospital);
                        break;
                    case 2:
                        sick.searchSick(hospital);
                        break;
                    case 3:
                        sick.sickHistory(hospital);
                        break;
                    case 4:
                        sick.updateSickİnformation(hospital);
                        break;
                }
                allReadProcess();
                System.out.print("Yapmak İstediğiniz İşlemi Giriniz; ");
                process = scanner.nextInt();
            }
            if (process ==3){
                appointmentProcess();
                System.out.print("Randevu İşleminizi Seçiniz: ");
                int appointmentProcess = scanner.nextInt();
                switch (appointmentProcess){
                    case 1:
                        appointment.creatAppointment(hospital);
                        break;
                    case 2:
                        appointment.readInformation(hospital);
                        break;
                    case 3:
                        appointment.canceledAppointment(hospital);
                        break;
                    case 4:
                        appointment.newAppointmentStatus(hospital);
                        break;
                }
                allReadProcess();
                process = scanner.nextInt();
            }
        }

    }
}