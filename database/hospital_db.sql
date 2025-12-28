CREATE DATABASE IF NOT EXISTS hospital_db;
USE hospital_db;

CREATE TABLE IF NOT EXISTS patients (
    patient_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    address VARCHAR(255),
    illness VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS doctors (
    doctor_id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    age INT,
    address VARCHAR(255),
    specialization VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS appointments (
    appointment_id VARCHAR(20) PRIMARY KEY,
    patient_id VARCHAR(20),
    doctor_id VARCHAR(20),
    date VARCHAR(20),
    time VARCHAR(20),
    FOREIGN KEY (patient_id) REFERENCES patients(patient_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (doctor_id) REFERENCES doctors(doctor_id) ON DELETE CASCADE ON UPDATE CASCADE
);
