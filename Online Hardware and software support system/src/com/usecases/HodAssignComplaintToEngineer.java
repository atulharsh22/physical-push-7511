package com.usecases;

import java.util.Scanner;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exception.EngineerException;

public class HodAssignComplaintToEngineer {

	public void hodAssignComplaintToEngineer() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Complaint id to be assigned");
		int cid=sc.nextInt();
		System.out.println("Enter Engineer id to whom complaint will be assigned");
		int engid=sc.nextInt();
		
		HodDao dao = new HodDaoImpl();
		
		try {
			String msg = dao.assignComplaintToEngineer(cid, engid);
			System.out.println(msg);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
	}

}
