package main;

import model.Doctor;
import model.Sick;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Hospital hospital = new Hospital();
        Doctor doctor = new Doctor();
        Sick sick4 = new Sick(1,"Mehmet","Halman",23424);
        Sick sick2 = new Sick(2,"Mert","Demir",23424);
        Sick sick3 = new Sick(3,"Orhan","Ararat",23424);
        hospital.sickListHashMap.put(sick4.getId(), sick4);
        hospital.sickListHashMap.put(sick2.getId(), sick2);
        hospital.sickListHashMap.put(sick3.getId(), sick3);
        Doctor doctor4 = new Doctor(1,"Kemal", "Kaya",323);
        Doctor doctor2 = new Doctor(2,"Kasım", "Norm",323);
        Doctor doctor3 = new Doctor(3,"Deren", "Şahin",323);
        hospital.doctorListHashMap.put(doctor4.getId(), doctor4);
        hospital.doctorListHashMap.put(doctor2.getId(), doctor2);
        hospital.doctorListHashMap.put(doctor3.getId(), doctor3);
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== HASTANE YÖNETİM SİSTEMİ ===");
        System.out.println("1. Personel İşlemleri");
        System.out.println("2. Hasta İşlemleri");
        System.out.println("3. Randevu İşlemleri");
        System.out.println("4. Reçete İşlemleri");
        System.out.println("5. Raporlar");

        int islem;
        System.out.print("Yapmak İstediğiniz İşlemi Giriniz; ");
        islem = scanner.nextInt();

        while (true) {

            if (islem == 1) {
                System.out.println("----PERSONEL iŞLEMLERİ----");
                System.out.println("1.1. Yeni Doktor Ekle\n" +
                        " 1.2. Yeni Hemşire Ekle\n" +
                        " 1.3. Doktor Listele \n" +
                        " 1.4. Personel Bilgilerini Görüntüle");
                System.out.print("Personel İşleminizi Giriniz: ");
                int islem2;
                islem2 = scanner.nextInt();

                switch (islem2) {
                    case 1:
                        hospital.addDoctor();
                        break;
                    case 2:
                        hospital.addNurse();
                        break;
                    case 3:
                        hospital.listDoctors();
                        break;
                    case 4:
                        System.out.println("----Doktor Listesi----");
                        hospital.listDoctors();
                        System.out.println("----Hemşire Listesi----");
                        hospital.listNurse();
                        break;
                }
                System.out.println(" ");
                System.out.println("=== HASTANE YÖNETİM SİSTEMİ ===");
                System.out.println("1. Personel İşlemleri");
                System.out.println("2. Hasta İşlemleri");
                System.out.println("3. Randevu İşlemleri");
                System.out.println("4. Reçete İşlemleri");
                System.out.println("5. Raporlar");
                System.out.println(" ");
                System.out.print("Yapmak İstediğiniz İşlemi Giriniz; ");
                islem = scanner.nextInt();
            }
            if (islem==2){
                System.out.println(" ");
                System.out.println("----Hasta İşlemleri----\n" +
                        " 2.1. Yeni Hasta Kaydı\n" +
                        " 2.2. Hasta Ara (TC/Ad ile)\n" +
                        " 2.3. Hasta Geçmişini Görüntüle\n" +
                        " 2.4. Hasta Bilgilerini Güncelle");
                System.out.print("Hasta İşlemini Seçiniz: ");
                int islem3 = scanner.nextInt();

                switch (islem3){
                    case 1:
                        hospital.addSick();
                        break;
                    case 2:
                        hospital.searchSick();
                        break;
                    case 3:
                        hospital.sickHistory();
                        break;
                    case 4:
                        hospital.updateSickİnformation();
                        break;
                }
                System.out.println(" ");
                System.out.println("=== HASTANE YÖNETİM SİSTEMİ ===");
                System.out.println("1. Personel İşlemleri");
                System.out.println("2. Hasta İşlemleri");
                System.out.println("3. Randevu İşlemleri");
                System.out.println("4. Reçete İşlemleri");
                System.out.println("5. Raporlar");
                System.out.println(" ");
                System.out.print("Yapmak İstediğiniz İşlemi Giriniz; ");
                islem = scanner.nextInt();
            }
            if (islem==3){
                System.out.println("----Randevu İşlemleri----\n" +
                        " 3.1. Randevu Oluştur\n" +
                        " 3.2. Randevuları Listele\n" +
                        " 3.3. Randevu İptal Et\n" +
                        " 3.4. Randevu Durumu Güncelle\n");

                System.out.print("Randevu İşleminizi Seçiniz: ");
                int islem3 = scanner.nextInt();
                switch (islem3){
                    case 1:
                        hospital.creatAppointment();
                        break;
                    case 2:
                        hospital.listAppointment();
                        break;
                    case 3:
                        hospital.canceledAppointment();
                        break;
                    case 4:
                        hospital.newAppointmentStatus();
                        break;
                }
                System.out.println(" ");
                System.out.println("=== HASTANE YÖNETİM SİSTEMİ ===");
                System.out.println("1. Personel İşlemleri");
                System.out.println("2. Hasta İşlemleri");
                System.out.println("3. Randevu İşlemleri");
                System.out.println("4. Reçete İşlemleri");
                System.out.println("5. Raporlar");
                System.out.println(" ");
                System.out.print("Yapmak İstediğiniz İşlemi Giriniz; ");
                islem = scanner.nextInt();
            }

            if (islem == 4){
                System.out.println("---Reçete İşlemleri---\n" +
                        " 4.1. Yeni Reçete Yaz\n" +
                        " 4.2. Hasta Reçetelerini Görüntüle\n" +
                        " 4.3. Aktif Reçeteler\n" +
                        " 4.4. Reçete Detayı");
                System.out.println("Reçete İşleminizi Seçiniz: ");
                int islem4 = scanner.nextInt();

                switch (islem4){
                    case 1:

                }
            }
        }

    }
}