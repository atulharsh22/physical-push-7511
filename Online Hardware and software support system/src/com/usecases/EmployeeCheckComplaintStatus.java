package com.usecases;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.ComplaintException;
import com.model.EngineerComplaintDTO;

public class EmployeeCheckComplaintStatus {

	public void employeeCheckComplaintStatus() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Complaint id : ");
		int cid = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			EngineerComplaintDTO dto = dao.checkComplaintStatus(cid);
			System.out.println("Complaint id : "+dto.getcId());
			System.out.println("Staus of complain : "+dto.getStatus());
			System.out.println("Type of complain : "+dto.getType());
			System.out.println("Assigned engineer id : "+dto.getEngId());
			System.out.println("Assigned engineer name : "+dto.getEngName());
			
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

}
