package dao;
import Entity.Appointment;
import Entity.Doctor;
import Entity.Patient;
import util.DBConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HospitalServiceImpl implements  IHospotalService{
    @Override
    public Appointment getAppointmentById(int appointmentId) {
        Appointment appointment = null;

        String query = "Select * from appointments where appointmentId = ?";
        try(
                Connection con = DBConnUtil.getConnection();
                PreparedStatement pstmt = con.prepareStatement(query)){

                    pstmt.setInt(1,appointmentId);
                    ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Assuming you have fields in your appointments table
                int id = rs.getInt("appointmentId");
                int patientId = rs.getInt("patientId");
                int doctorId = rs.getInt("doctorId");
                String appointmentDate = rs.getString("appointmentDate");
                String description = rs.getString("description");

                appointment = new Appointment(id, new Patient(patientId), new Doctor(doctorId), appointmentDate, description);

            }


    }
        catch (Exception e){
            e.printStackTrace();
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) {

        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE patientId = ?";

        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setInt(1, patientId);


            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int appointmentId = rs.getInt("appointmentId");
                int doctorId = rs.getInt("doctorId");
                String appointmentDate = rs.getString("appointmentDate");
                String description = rs.getString("description");


                Appointment appointment = new Appointment(appointmentId, new Patient(patientId), new Doctor(doctorId), appointmentDate, description);
                appointments.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) {

        List<Appointment> appointments = new ArrayList<>();
        String sql = "SELECT * FROM appointments WHERE doctorId = ?";

        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, doctorId);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int appointmentId = rs.getInt("appointmentId");
                int patientId = rs.getInt("patientId");
                String appointmentDate = rs.getString("appointmentDate");
                String description = rs.getString("description");

                // Create an Appointment object and add it to the list
                Appointment appointment = new Appointment(appointmentId, new Patient(patientId), new Doctor(doctorId), appointmentDate, description);
                appointments.add(appointment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return appointments;
    }

    @Override
    public boolean scheduleAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointments (patientId, doctorId, appointmentDate, description) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Set the parameters
            pstmt.setInt(1, appointment.getPatient().getPatientId());
            pstmt.setInt(2, appointment.getDoctor().getDoctorId());
            pstmt.setString(3, appointment.getAppointmentDate());
            pstmt.setString(4, appointment.getDescription());


            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    @Override
    public boolean updateAppointment(Appointment appointment) {

        String sql = "UPDATE appointments SET patientId = ?, doctorId = ?, appointmentDate = ?, description = ? WHERE appointmentId = ?";

        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setInt(1, appointment.getPatient().getPatientId());
            pstmt.setInt(2, appointment.getDoctor().getDoctorId());
            pstmt.setString(3, appointment.getAppointmentDate());
            pstmt.setString(4, appointment.getDescription());
            pstmt.setInt(5, appointment.getAppointmentId());


            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;  // Return true if the update was successful

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;


    }

    @Override
    public boolean cancelAppointment(int appointmentId) {

        String sql = "DELETE FROM appointments WHERE appointmentId = ?";

        try (Connection conn = DBConnUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

             pstmt.setInt(1, appointmentId);


            int rowsAffected = pstmt.executeUpdate();

            return rowsAffected > 0;  // Return true if the delete was successful

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }
}
