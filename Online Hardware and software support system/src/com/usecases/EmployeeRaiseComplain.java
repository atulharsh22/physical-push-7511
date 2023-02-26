package com.usecases;

import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.ComplaintException;
import com.model.Complaint;

public class EmployeeRaiseComplain {

	public void employeeRaiseComplain() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee id : ");
		int empid = sc.nextInt();
		System.out.println("Enter type of complain as (hardware/software)");
		String type = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			Complaint comp = dao.registerComplain(empid, type);

			System.out.println("Complaint registered with Complaint id : "+comp.getcId());
			
			System.out.println("Complain registered with status as : "+comp.getStatus());
			System.out.println("Complain registered by employee with Employee id : "+comp.getEmpId());
			System.out.println("Complain type : "+comp.getType());
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
