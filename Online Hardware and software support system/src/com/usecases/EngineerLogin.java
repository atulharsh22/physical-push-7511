package com.usecases;

import java.util.Scanner;

import com.dao.EngineerDao;
import com.dao.EngineerDaoImpl;
import com.exception.EngineerException;
import com.model.Engineer;


public class EngineerLogin {

	public void engineerLogin() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		EngineerDao dao=new EngineerDaoImpl();
		
		try {
			Engineer eng=dao.loginEngineer(username, password);
			System.out.println("Welcome "+eng.getName());
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
