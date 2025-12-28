package model;

public class Patient extends Person {

    private String patientId;
    private String illness;

    public Patient(String name, int age, String address, String patientId, String illness) {
        super(name, age, address);
        this.patientId = patientId;
        this.illness = illness;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    @Override
    public String toString() {
        return "Patient ID: " + patientId +
               ", Name: " + getName() +
               ", Age: " + getAge() +
               ", Illness: " + illness;
    }
}
