package Entity;

public class Patient {
    private int PatientId;
    private String FirstName;
    private String LastName;
    private String DOB;
    private String Gender;
    private int Contact;
    private String Address;

    public Patient(){
    }

    public Patient(int PatientId,String FirstName, String LastName, String DOB, String Gender, int Contact,String Address){
        this.PatientId = PatientId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.DOB = DOB;
        this.Gender = Gender;
        this.Contact = Contact;
        this.Address = Address;
    }

    public Patient(int patientId) {
        this.PatientId = patientId;
    }


    public void setPatientId(int PaitientId) {
        this.PatientId = PaitientId;
    }

    public void setFirstName(String FirstName) {
        this.FirstName= FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }
    public void setContact(int Contact){
        this.Contact = Contact;
    }
    public int getPatientId() {
        return PatientId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getDOB() {
        return DOB;
    }

    public String getGender() {
        return Gender;
    }

    public String getAddress() {
        return Address;
    }
    @Override
    public String toString(){
        return "Patient{ "+"Patient Id"+PatientId +" Full Name" + FirstName+" "+LastName+"Date Of Birth "+ DOB+ "Gender "+ Gender + "Contact Number "+ Contact + "Address "+ Address;
    }

    public int getContact() {
        return Contact;
    }
}
