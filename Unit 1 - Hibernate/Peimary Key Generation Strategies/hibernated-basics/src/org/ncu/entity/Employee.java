package org.ncu.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.ncu.embedable.EmployeeCandidates;

@Entity
@Table(name="emp_table")
public class Employee {
	//@Id
	/*
	 * @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	 * "cutomized-generator")
	 * 
	 * @GenericGenerator(name = "cutomized-generator",strategy =
	 * "org.hibernate.id.enhanced.SequenceStyleGenerator" , parameters = {
	 * 
	 * @Parameter(name = "sequence_name", value = "emp_sequence"),
	 * 
	 * @Parameter(name = "initial_value", value = "110"),
	 * 
	 * @Parameter(name = "increment_size", value = "5") })
	 */
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_no")
	private int empNo;
	@Column(name="emp_name", length = 30, nullable = false, unique = true )
	private String empName;
	@Column(name="address", length = 50)
	private String address;
	@Column(name="salary")
	private int salary;
	@Column(name="email", length = 20)
	private String email;
	
	/* composite key */
	@EmbeddedId
	private EmployeeCandidates empCandidate;
	
	
	public Employee(String empName, String address, int salary, String email) {
		super();
		this.empName = empName;
		this.address = address;
		this.salary = salary;
		this.email = email;
	}
	
	public EmployeeCandidates getEmpCandidate() {
		return empCandidate;
	}

	public void setEmpCandidate(EmployeeCandidates empCandidate) {
		this.empCandidate = empCandidate;
	}

	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", address=" + address + ", salary=" + salary
				+ ", email=" + email + "]";
	}
	
}
