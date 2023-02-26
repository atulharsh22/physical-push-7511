package com.usecases;

import java.util.Scanner;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exception.HodException;
import com.model.Hod;

public class HodLogin {

	public void hodLogin() {
		// TODO Auto-generated method stub
		System.out.println("HOD Login ...");
		System.out.println("==================");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter username");
		String username=sc.nextLine();
		System.out.println("Enter password");
		String password=sc.nextLine();
		HodDao dao=new HodDaoImpl();
		
		try {
			Hod hd=dao.loginHod(username, password);
			System.out.println("Welcome "+hd.getName());
		} catch (HodException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
