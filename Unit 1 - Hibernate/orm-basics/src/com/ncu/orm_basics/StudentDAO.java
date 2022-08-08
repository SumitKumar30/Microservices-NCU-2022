package com.ncu.orm_basics;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDAO {
	
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void save() {
		Student student = new Student(11, "Joss", "Carter", "joss@poi.com");
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(student);
		trans.commit();
		session.close();
		System.out.println("Data saved successfully!");
	}
	
	public void remove(int id) {
		Session session = sessionFactory.openSession();
		Student std = read(id);
		if(std == null) {
			System.out.println("Id doesn't exist!");
			return;
		}
		Transaction trans = session.beginTransaction();
		session.delete(std);
		trans.commit();
		session.close();
		System.out.println("Record Deleted Successfully!");
	}
	
	public void update(int id) {
		Session session = sessionFactory.openSession();
		Student std = read(id);
		if(std == null) {
			System.out.println("Id doesn't exist!");
			return;
		}
		std.setEmail("carter@lapd.com");
		Transaction trans = session.beginTransaction();
		session.update(std);
		trans.commit();
		session.close();
		System.out.println("Record Updated!");
	}
	
	public Student read(int id) {
			Session session = sessionFactory.openSession();
			Student stu = session.get(Student.class, 11);
			System.out.println("Student Data is: "+stu);
			session.close();
			return stu;
	}
}
