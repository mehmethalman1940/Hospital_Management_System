package main;

import enums.AppointmentStatus;
import model.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Hospital {

    private HashMap<Integer, Doctor> doctorListHashMap = new HashMap<Integer, Doctor>();
    private HashMap<Integer, Sick> sickListHashMap = new HashMap<Integer, Sick>();
    private ArrayList<Nurse> nurseList = new ArrayList<Nurse>();
    private ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();

    public HashMap<Integer, Doctor> getDoctorListHashMap() {
        return doctorListHashMap;
    }
    public HashMap<Integer, Sick> getSickListHashMap() {
        return sickListHashMap;
    }
    public ArrayList<Nurse> getNurseList() {
        return nurseList;
    }

    public ArrayList<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void addDoctorToMap(Doctor doctor){
        doctorListHashMap.put(doctor.getId(), doctor);
    }

    public void addSick(Sick sick){
        sickListHashMap.put(sick.getId(),sick);
            sick.readInformation(this);
    }

    public void addNurse(Nurse nurse){
        nurseList.add(nurse);
    }

    public void creatAppointment(Appointment appointment){
        appointmentList.add(appointment);
    }
}
