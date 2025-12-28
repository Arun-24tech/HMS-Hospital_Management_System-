package model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class HospitalDatabase {

    private final List<Patient> patients = Collections.synchronizedList(new ArrayList<>());
    private final List<Doctor> doctors = Collections.synchronizedList(new ArrayList<>());
    private final List<Appointment> appointments = Collections.synchronizedList(new ArrayList<>());

    private final AtomicInteger patientCounter = new AtomicInteger(1000);
    private final AtomicInteger doctorCounter = new AtomicInteger(500);
    private final AtomicInteger appointmentCounter = new AtomicInteger(2000);

    // Singleton (optional handy pattern)
    private static HospitalDatabase instance;
    private HospitalDatabase() {}
    public static synchronized HospitalDatabase getInstance() {
        if (instance == null) instance = new HospitalDatabase();
        return instance;
    }

    // Patient operations
    public synchronized String addPatient(Patient p) {
        if (p.getPatientId() == null || p.getPatientId().isBlank()) {
            p.setPatientId("P" + patientCounter.getAndIncrement());
        }
        patients.add(p);
        return p.getPatientId();
    }

    public synchronized boolean removePatient(String patientId) {
        boolean removed = patients.removeIf(p -> patientId.equals(p.getPatientId()));
        if (removed) {
            // also remove related appointments
            appointments.removeIf(a -> patientId.equals(a.getPatientId()));
        }
        return removed;
    }

    public List<Patient> getAllPatients() {
        synchronized(patients) {
            return new ArrayList<>(patients);
        }
    }

    public Patient findPatientById(String patientId) {
        synchronized(patients) {
            return patients.stream().filter(p -> patientId.equals(p.getPatientId())).findFirst().orElse(null);
        }
    }

    // Doctor operations
    public synchronized String addDoctor(Doctor d) {
        if (d.getDoctorId() == null || d.getDoctorId().isBlank()) {
            d.setDoctorId("D" + doctorCounter.getAndIncrement());
        }
        doctors.add(d);
        return d.getDoctorId();
    }

    public synchronized boolean removeDoctor(String doctorId) {
        boolean removed = doctors.removeIf(d -> doctorId.equals(d.getDoctorId()));
        if (removed) {
            appointments.removeIf(a -> doctorId.equals(a.getDoctorId()));
        }
        return removed;
    }

    public List<Doctor> getAllDoctors() {
        synchronized(doctors) {
            return new ArrayList<>(doctors);
        }
    }

    public Doctor findDoctorById(String doctorId) {
        synchronized(doctors) {
            return doctors.stream().filter(d -> doctorId.equals(d.getDoctorId())).findFirst().orElse(null);
        }
    }

    // Appointment operations
    public synchronized String addAppointment(Appointment a) {
        if (a.getAppointmentId() == null || a.getAppointmentId().isBlank()) {
            a.setAppointmentId("A" + appointmentCounter.getAndIncrement());
        }
        // simple conflict check: same doctor at same time
        boolean conflict = appointments.stream()
            .anyMatch(existing -> a.getDoctorId().equals(existing.getDoctorId()) && a.getDateTime().equals(existing.getDateTime()));
        if (conflict) {
            throw new IllegalArgumentException("Doctor already has an appointment at this time.");
        }
        appointments.add(a);
        return a.getAppointmentId();
    }

    public synchronized boolean removeAppointment(String appointmentId) {
        return appointments.removeIf(a -> appointmentId.equals(a.getAppointmentId()));
    }

    public List<Appointment> getAllAppointments() {
        synchronized(appointments) {
            return new ArrayList<>(appointments);
        }
    }

    public List<Appointment> findAppointmentsByPatient(String patientId) {
        synchronized(appointments) {
            return appointments.stream().filter(a -> patientId.equals(a.getPatientId())).collect(Collectors.toList());
        }
    }

    public List<Appointment> findAppointmentsByDoctor(String doctorId) {
        synchronized(appointments) {
            return appointments.stream().filter(a -> doctorId.equals(a.getDoctorId())).collect(Collectors.toList());
        }
    }
}
