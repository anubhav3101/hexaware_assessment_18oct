package Entity;

public class Doctor {
    private int DoctorId;
    private String FirstName;
    private String LastName;
    private String Specialization;
    private int Contact;

    public Doctor(int doctorId){}

    public Doctor(int DoctorId, String FirstName,String LastName, String Specialization, int Contact){
        this.DoctorId = DoctorId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Specialization = Specialization;
        this.Contact = Contact;
    }

    public int getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(int doctorId) {
        DoctorId = doctorId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
    }

    @Override
    public String toString(){
        return "Patient{ "+"Patient Id"+DoctorId +" Full Name" + FirstName+" "+LastName+ "Contact Number "+ Contact +" Specialization "+ Specialization;
    }

}
