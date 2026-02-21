package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Prescription {

    private String prescriptionNo;
    private Doctor doctor;
    private Sick sick;
    private ArrayList<String> medicines = new ArrayList<String>();
    private LocalDate date;
    private int usagePeriodDay;
    private boolean isActive;


    public Prescription() {
        this.prescriptionNo = prescriptionNo;
        this.doctor = doctor;
        this.medicines = medicines;
        this.sick = sick;
        this.date = date;
        this.usagePeriodDay = usagePeriodDay;
        this.isActive = isActive;
    }


    public String getPrescriptionNo() {
        return prescriptionNo;
    }

    public void setPrescriptionNo(String prescriptionNo) {
        this.prescriptionNo = prescriptionNo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Sick getSick() {
        return sick;
    }

    public void setSick(Sick sick) {
        this.sick = sick;
    }

    public ArrayList<String> getMedicines() {
        return medicines;
    }

    public void setMedicines(ArrayList<String> medicines) {
        this.medicines = medicines;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getUsagePeriodDay() {
        return usagePeriodDay;
    }

    public void setUsagePeriodDay(int usagePeriodDay) {
        this.usagePeriodDay = usagePeriodDay;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
