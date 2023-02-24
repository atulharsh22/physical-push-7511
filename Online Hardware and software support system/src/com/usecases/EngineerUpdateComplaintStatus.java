package com.usecases;

import java.util.Scanner;

import com.dao.EngineerDao;
import com.dao.EngineerDaoImpl;
import com.exception.ComplaintException;

public class EngineerUpdateComplaintStatus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter complaint id to be updated");
		int cid=sc.nextInt();
		System.out.println("Enter updated status");
		String status = sc.next();
		EngineerDao dao = new EngineerDaoImpl();
		try {
			String msg = dao.updateComplaintStatus(cid, status);
			System.out.println(msg);
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.getMessage();
		}
	}

}
