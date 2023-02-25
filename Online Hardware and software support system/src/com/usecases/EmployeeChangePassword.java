package com.usecases;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.EmployeeException;

public class EmployeeChangePassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id : ");
		int empId = sc.nextInt();
		System.out.println("Enter username of employee : ");
		String username = sc.next();
		System.out.println("Enter current password : ");
		String password = sc.next();
		System.out.println("Enter new password : ");
		String newPassword = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			String msg = dao.changePassword(empId, username, password, newPassword);
			System.out.println(msg);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
