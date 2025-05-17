package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "pid")
	@SequenceGenerator(name = "pid", initialValue = 201, allocationSize = 1)
	private int patientid;
	private String name;
	private String dob;
	private String medicalhistory;

	public int getPatientid() {
		return patientid;
	}

	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMedicalhistory() {
		return medicalhistory;
	}

	public void setMedicalhistory(String medicalhistory) {
		this.medicalhistory = medicalhistory;
	}

	@Override
	public String toString() {
		return "Patient [patientid=" + patientid + ", name=" + name + ", dob=" + dob + ", medicalhistory="
				+ medicalhistory + "]";
	}

}