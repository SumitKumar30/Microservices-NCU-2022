package org.ncu.embedable;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class EmployeeCandidates implements Serializable{
	private Date doj;
	private String emp_type;
	private String emp_role;
	
	
	public EmployeeCandidates(Date doj, String emp_type, String emp_role) {
		super();
		this.doj = doj;
		this.emp_type = emp_type;
		this.emp_role = emp_role;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public String getEmp_type() {
		return emp_type;
	}
	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}
	public String getEmp_role() {
		return emp_role;
	}
	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}
	@Override
	public String toString() {
		return "EmployeeCandidates [doj=" + doj + ", emp_type=" + emp_type + ", emp_role=" + emp_role + "]";
	}
	
}
