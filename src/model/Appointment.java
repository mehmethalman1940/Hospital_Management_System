package model;

import enums.AppointmentStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private String id;
    private Sick sick;
    private Doctor doctor;
    private LocalDate date;
    private LocalTime time;
    private AppointmentStatus status;
    private String complaint;
    private String notes;


    public Appointment(String id, Sick sick, Doctor doctor, LocalDate date, LocalTime time, String complaint, AppointmentStatus status, String notes) {
        this.id = id;
        this.sick = sick;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.complaint = complaint;
        this.status = status;
        this.notes = notes;
    }

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
}
