package model;

public class Doctor extends Person {
    private String doctorId;
    private String specialization;

    public Doctor(String name, int age, String address, String doctorId, String specialization) {
        super(name, age, address);
        this.doctorId = doctorId;
        this.specialization = specialization;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + doctorId +
               ", Name: " + getName() +
               ", Age: " + getAge() +
               ", Specialization: " + specialization;
    }
}
