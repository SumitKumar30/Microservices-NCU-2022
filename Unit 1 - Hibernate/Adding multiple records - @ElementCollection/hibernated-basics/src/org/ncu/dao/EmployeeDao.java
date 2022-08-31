package org.ncu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ncu.embedable.EmployeeAddress;
import org.ncu.entity.Employee;

public class EmployeeDao {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	/* saving object state into the database */
	public void create() {
		Employee emp = new Employee("Nathan", 8750000, "nathan@ncu.com");
		/*
		 * EmployeeCandidates e = new EmployeeCandidates(new Date(), "regular", "HR");
		 * 
		 * emp.setEmpCandidate(e);
		 */
		
		/*
		 * EmployeeAddress empAddress = new EmployeeAddress("Gurugram", "Haryana",
		 * "India", 122001); emp.setOffice(empAddress);
		 * 
		 * EmployeeAddress empRes = new EmployeeAddress("New Delhi", "Delhi", "India",
		 * 110001); emp.setRes(empRes);
		 */
		
		List<EmployeeAddress> empAdd = new ArrayList<>();
		
		empAdd.add(new EmployeeAddress("Gurugram", "Haryana","India", 122001));
		empAdd.add(new EmployeeAddress("New Delhi", "Delhi","India", 110001));
		empAdd.add(new EmployeeAddress("Austin", "Texas","USA", 125647));
		
		emp.setEmpAddress(empAdd);
		
		
		// step 1: create a new session or open an existing session
		Session session = sessionFactory.openSession();
	
		// step 2: create a transaction boundary
		session.beginTransaction();
		
		// step 3: perform save/insert operation
		session.save(emp);
		
		// step 4: commit the transaction
		session.getTransaction().commit();
		
		// step 5: close the session
		session.close();
		System.out.println("Data saved succcessfully!!");
	}
	
	
	public void read() {
		
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}

}
