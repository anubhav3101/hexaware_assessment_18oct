package Entity;

public class Appointment {
    private int AppointmentId;
    private Patient Patient;
    private Doctor Doctor;
    private String AppointmentDate;
    private String Description;

    public Appointment(){

    }
    public Appointment(int appointmentId, Patient patient, Doctor doctor, String appointmentDate, String description){
        this.AppointmentId = appointmentId;
        this.Patient = patient;
        this.Doctor = doctor;
        this.AppointmentDate = appointmentDate;
        this.Description = description;
    }

    public int getAppointmentId() {
        return AppointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        AppointmentId = appointmentId;
    }

    public Patient getPatient() {
        return Patient;
    }

    public void setPatient(Patient patient) {
        Patient = patient;
    }

    public Doctor getDoctor() {
        return Doctor;
    }

    public void setDoctor(Doctor doctor) {
        Doctor = doctor;
    }

    public String getAppointmentDate() {
        return AppointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        AppointmentDate = appointmentDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString(){
        return "Appointment Id "+AppointmentId+"  ";
    }

}
