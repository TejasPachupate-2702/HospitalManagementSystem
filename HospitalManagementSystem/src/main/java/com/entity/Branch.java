package com.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Branch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "bid")
	@SequenceGenerator(name = "bid", initialValue = 101, allocationSize = 1)
	private int branch_id;
	private String b_location;
	private long phoneno;

	@OneToMany
	private List<Patient> p;

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getB_location() {
		return b_location;
	}

	public void setB_location(String b_location) {
		this.b_location = b_location;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public List<Patient> getP() {
		return p;
	}

	public void setP(List<Patient> p) {
		this.p = p;
	}

	@Override
	public String toString() {
		return "Branch [branch_id=" + branch_id + ", b_location=" + b_location + ", phoneno=" + phoneno + ", p=" + p
				+ "]";
	}

}
