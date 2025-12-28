package model;

import java.time.LocalDateTime;

public class Appointment {

    private String appointmentId;
    private String patientId;
    private String doctorId;
    private LocalDateTime dateTime;
    private String notes;

    public Appointment(String appointmentId, String patientId, String doctorId, LocalDateTime dateTime, String notes) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.notes = notes;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(String appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId +
               ", Patient ID: " + patientId +
               ", Doctor ID: " + doctorId +
               ", DateTime: " + dateTime +
               (notes != null && !notes.isEmpty() ? (", Notes: " + notes) : "");
    }
}
