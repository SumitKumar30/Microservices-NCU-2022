package org.ncu.test;

import org.ncu.dao.CourseDao;
import org.ncu.dao.InstructorDao;
import org.ncu.dao.StudentDao;

public class AppTest {

	public static void main(String[] args) {
		 InstructorDao insDao = new InstructorDao(); 
			/*
			 * CourseDao dao = new CourseDao(); dao.create();
			 */
			/*
			 * StudentDao stuDao = new StudentDao(); stuDao.create();
			 */
		//insDao.create();
		insDao.read();

	}

}
