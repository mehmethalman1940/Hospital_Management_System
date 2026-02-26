package exceptions;

public class AppointmentConflictExpection extends Exception {
    public AppointmentConflictExpection(String message) {
        super(message);
    }
}
