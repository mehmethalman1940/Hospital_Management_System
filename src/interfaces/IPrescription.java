package interfaces;

import model.Appointment;
import model.Prescription;

import java.util.ArrayList;

public interface IPrescription {

    public void createPrescription();
    ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
}
