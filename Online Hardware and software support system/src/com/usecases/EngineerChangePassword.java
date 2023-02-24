package com.usecases;

import java.util.Scanner;

import com.dao.EngineerDao;
import com.dao.EngineerDaoImpl;
import com.exception.EngineerException;

public class EngineerChangePassword {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Engineer id of engineer : ");
		int engid = sc.nextInt();
		System.out.println("Enter password : ");
		String password = sc.next();
		System.out.println("Enter your new password");
		String newPassword = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			String msg = dao.changeEngineerPassword(engid, password, newPassword);
			System.out.println(msg);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	}

}
