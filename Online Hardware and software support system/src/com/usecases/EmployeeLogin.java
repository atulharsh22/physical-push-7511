package com.usecases;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;
import com.model.Employee;

public class EmployeeLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Employee login");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username : ");
		String username = sc.next();
		System.out.println("Enter password : ");
		String password = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			Employee emp = dao.loginEmployee(username, password);
			System.out.println("Login successfull");
			System.out.println("Welcome "+emp.getName());
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
