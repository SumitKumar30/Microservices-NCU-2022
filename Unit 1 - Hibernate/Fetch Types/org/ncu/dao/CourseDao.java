package org.ncu.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.ncu.Entity.Course;
import org.ncu.Entity.Instructor;
import org.ncu.Entity.InstructorDetail;

public class CourseDao {
SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	/* saving object state into the database */
	public void create() {
		
		Course c1 = new Course("Java Programming", 40);
		Course c2 = new Course("FOCP2", 30);
		
		Instructor ins = new Instructor("Harry", "Simpson", "harry@ncuindia.edu");
		
		c1.setInstructor(ins);
		c2.setInstructor(ins);
		
		// step 1: create a new session or open an existing session
		Session session = sessionFactory.openSession();
	
		// step 2: create a transaction boundary
		session.beginTransaction();
		
		// step 3: perform save/insert operation
		session.save(c1);
		session.save(c2);
		
		// step 4: commit the transaction
		session.getTransaction().commit();
		
		// step 5: close the session
		session.close();
		System.out.println("Data saved succcessfully!!");
	}
}
