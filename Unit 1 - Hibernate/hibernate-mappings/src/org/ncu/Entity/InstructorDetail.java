package org.ncu.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int instructorId;
	private String insProfile;
	private String address;
	
	
	public InstructorDetail( String insProfile, String address) {
		super();
		//this.instructorId = instructorId;
		this.insProfile = insProfile;
		this.address = address;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public String getInsProfile() {
		return insProfile;
	}
	public void setInsProfile(String insProfile) {
		this.insProfile = insProfile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "InstructorDetail [instructorId=" + instructorId + ", insProfile=" + insProfile + ", address=" + address
				+ "]";
	}
	
}
