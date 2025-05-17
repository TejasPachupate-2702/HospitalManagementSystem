package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Hospital {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hospital_id;
	private String hos_name;
	private String hos_add;

	@OneToMany
	private List<Branch> b;

	public int getHospital_id() {
		return hospital_id;
	}

	public void setHospital_id(int hospital_id) {
		this.hospital_id = hospital_id;
	}

	public String getHos_name() {
		return hos_name;
	}

	public void setHos_name(String hos_name) {
		this.hos_name = hos_name;
	}

	public String getHos_add() {
		return hos_add;
	}

	public void setHos_add(String hos_add) {
		this.hos_add = hos_add;
	}

	public List<Branch> getB() {
		return b;
	}

	public void setB(List<Branch> b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "Hospital [hospital_id=" + hospital_id + ", hos_name=" + hos_name + ", hos_add=" + hos_add + ", b=" + b
				+ "]";
	}

}