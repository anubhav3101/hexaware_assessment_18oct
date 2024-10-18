package exception;

public class PatientNumberNotFoundException extends Exception {
    public PatientNumberNotFoundException(String message) {
        super(message);
    }
    public PatientNumberNotFoundException(int patientId){
        super("Patient Id"+patientId+" not found");
    }
}
