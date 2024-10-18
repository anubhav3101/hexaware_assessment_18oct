package mainmod;

import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import dao.HospitalServiceImpl;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HospitalServiceImpl service = new HospitalServiceImpl();
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. View Appointment by ID");
            System.out.println("3. View Appointments for Patient");
            System.out.println("4. View Appointments for Doctor");
            System.out.println("5. Update Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            option = sc.nextInt();
            switch (option) {
                case 1:

                    try {
                        System.out.println("Enter patient ID:");
                        int patientId = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter doctor ID:");
                        int doctorId = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter appointment date (YYYY-MM-DD):");
                        String date = sc.nextLine();

                        System.out.println("Enter description:");
                        String description = sc.nextLine();


                        Appointment newAppointment = new Appointment(0, new Patient(patientId), new Doctor(doctorId), date, description);
                        boolean isScheduled = service.scheduleAppointment(newAppointment);
                        System.out.println(isScheduled ? "Appointment Scheduled Successfully!" : "Failed to Schedule Appointment.");
                    } catch (Exception e) {
                        System.out.println("Error while scheduling appointment: " + e.getMessage());
                    }
                    break;

                case 2:

                    try {
                        System.out.println("Enter appointment ID:");
                        int appointmentId = sc.nextInt();
                        Appointment appointment = service.getAppointmentById(appointmentId);
                        System.out.println(appointment != null ? appointment.toString() : "Appointment not found.");
                    } catch (Exception e) {
                        System.out.println("Error while retrieving appointment: " + e.getMessage());
                    }
                    break;

                case 3:

                    try {
                        System.out.println("Enter patient ID:");
                        int patientId = sc.nextInt();
                        List<Appointment> patientAppointments = service.getAppointmentsForPatient(patientId);

                        if (patientAppointments.isEmpty()) {
                            System.out.println("No appointments found for this patient.");
                        } else {
                            patientAppointments.forEach(System.out::println);
                        }
                    } catch (Exception e) {
                        System.out.println("Error while retrieving appointments: " + e.getMessage());
                    }
                    break;

                case 4:

                    try {
                        System.out.println("Enter doctor ID:");
                        int doctorId = sc.nextInt();
                        List<Appointment> doctorAppointments = service.getAppointmentsForDoctor(doctorId);

                        if (doctorAppointments.isEmpty()) {
                            System.out.println("No appointments found for this doctor.");
                        } else {
                            doctorAppointments.forEach(System.out::println);
                        }
                    } catch (Exception e) {
                        System.out.println("Error while retrieving appointments: " + e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        System.out.println("Enter appointment ID to update:");
                        int appointmentId = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter new patient ID:");
                        int newPatientId = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter new doctor ID:");
                        int newDoctorId = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter new appointment date (YYYY-MM-DD):");
                        String newDate = sc.nextLine();

                        System.out.println("Enter new description:");
                        String newDescription = sc.nextLine();
                        Appointment updatedAppointment = new Appointment(appointmentId, new Patient(newPatientId), new Doctor(newDoctorId), newDate, newDescription);
                        boolean isUpdated = service.updateAppointment(updatedAppointment);
                        System.out.println(isUpdated ? "Appointment Updated Successfully!" : "Failed to Update Appointment.");
                    } catch (Exception e) {
                        System.out.println("Error while updating appointment: " + e.getMessage());
                    }
                    break;

                case 6:
                    try {
                        System.out.println("Enter appointment ID to cancel:");
                        int appointmentId = sc.nextInt();
                        boolean isCancelled = service.cancelAppointment(appointmentId);
                        System.out.println(isCancelled ? "Appointment Cancelled Successfully!" : "Failed to Cancel Appointment.");
                    } catch (Exception e) {
                        System.out.println("Error while canceling appointment: " + e.getMessage());
                    }
                    break;

                case 7:
                    System.out.println("Exiting the system...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option != 7);
    }
        }


