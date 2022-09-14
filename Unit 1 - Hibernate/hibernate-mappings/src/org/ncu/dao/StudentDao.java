package org.ncu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ncu.Entity.Course;
import org.ncu.Entity.Instructor;
import org.ncu.Entity.Student;

public class StudentDao {
SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	/* saving object state into the database */
	public void create() {
		
		/* Many to Many direction --> A course can have many students */
		
		Student tempStudent1 = new Student("Arjun", "Singh", "arjun@ncuindia.edu", "Gurugram");
		Student tempStudent2 = new Student("Pankaj", "Rathor", "pankaj@ncuindia.edu", "Noida");
		
		Course tempCourse = new Course("Intro to AI", 45);
		
		// adding an instructor to the course
		Instructor ins = new Instructor("Kelly", "Jr", "kelly@ncuindia.edu");
		tempCourse.setInstructor(ins);
		
		// step 1: create a new session or open an existing session
		Session session = sessionFactory.openSession();
	
		// step 2: create a transaction boundary
		session.beginTransaction();
		
		// saving the course
		session.save(tempCourse);
		
		// adding students to the course
		tempCourse.addStudent(tempStudent1);
		tempCourse.addStudent(tempStudent2);
		
		
		// save the students
		System.out.println("saving students...");
		
		// step 3: perform save/insert operation
		session.save(tempStudent1);
		session.save(tempStudent2);
		
		// step 4: commit the transaction
		session.getTransaction().commit();
		
		// step 5: close the session
		session.close();
		System.out.println("Data saved succcessfully!!");
	}
}
