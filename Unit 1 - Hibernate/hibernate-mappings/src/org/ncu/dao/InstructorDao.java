package org.ncu.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ncu.Entity.Course;
import org.ncu.Entity.Instructor;
import org.ncu.Entity.InstructorDetail;


public class InstructorDao {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	/* saving object state into the database */
	public void create() {
		
		Instructor ins = new Instructor("Harry", "Reese", "john@ncu.edu");
		
		InstructorDetail ins_detail = new InstructorDetail("www.johnreese.com", "Delhi");
		
		ins.setInstructorDetail(ins_detail);
		
		Course c1 = new Course("Enterprise Web Apps", 50);
		Course c2 = new Course("Microservices", 40);
		Course c3 = new Course("Web Frameworks", 35);
		
		ins.addCourses(c1);
		ins.addCourses(c2);
		ins.addCourses(c3);
		
		List<Course> course = new ArrayList<Course>();
		course.add(new Course("Enterprise Web Apps", 50));
		course.add(new Course("Microservices", 40));
		course.add(new Course("Web Frameworks", 35));
		
		//ins.setCourses(course);
		
		
		// step 1: create a new session or open an existing session
		Session session = sessionFactory.openSession();
	
		// step 2: create a transaction boundary
		session.beginTransaction();
		
		// step 3: perform save/insert operation
		session.save(ins);
		
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
