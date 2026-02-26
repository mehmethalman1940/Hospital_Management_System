package exceptions;

import java.rmi.server.ExportException;

public class doctorUnavailableExpection extends ExportException {
    public doctorUnavailableExpection(String message) {
        super(message);
    }
}
