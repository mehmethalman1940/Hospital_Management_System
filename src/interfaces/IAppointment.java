package interfaces;

import model.Appointment;

import java.util.ArrayList;

public interface IAppointment {

    public void creatAppointment();
    public void appointmentCancelled();
    ArrayList<Appointment> getAppointment();
}
