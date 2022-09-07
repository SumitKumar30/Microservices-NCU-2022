package org.ncu.test;

import org.ncu.dao.CourseDao;
import org.ncu.dao.InstructorDao;

public class InstructorTest {

	public static void main(String[] args) {
		 InstructorDao insDao = new InstructorDao(); 
		/* CourseDao dao = new CourseDao(); */
		insDao.create();

	}

}
