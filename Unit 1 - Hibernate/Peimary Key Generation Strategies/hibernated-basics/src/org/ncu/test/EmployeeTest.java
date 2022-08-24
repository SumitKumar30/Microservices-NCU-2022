package org.ncu.test;

import org.ncu.dao.EmployeeDao;

public class EmployeeTest {

	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDao();
		empDao.create();

	}

}
