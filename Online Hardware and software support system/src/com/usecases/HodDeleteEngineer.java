package com.usecases;

import java.util.Scanner;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exception.EngineerException;

public class HodDeleteEngineer {

	public void hodDeleteEngineer() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter engineer id of Engineer to be deleted");
		int engId=sc.nextInt();
		
		HodDao dao = new HodDaoImpl();
		
		try {
			String msg = dao.deleteEngineer(engId);
			System.out.println(msg);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
