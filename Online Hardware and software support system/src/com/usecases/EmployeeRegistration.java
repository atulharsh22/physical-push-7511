package com.usecases;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;

public class EmployeeRegistration {

	public void employeeRegistration() {
		// TODO Auto-generated method stub
		System.out.println("Employee Registration");
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter name of employee : ");
		String name = sc.nextLine();
		System.out.println("Enter username of employee :");
		String username = sc.next();
		System.out.println("Enter password :");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String msg = dao.registerEmployee(name, username, password);
			System.out.println(msg);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
