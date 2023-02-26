package com.usecases;

import java.util.List;
import java.util.Scanner;

import com.dao.EmployeeDao;
import com.dao.EmployeeDaoImpl;
import com.exception.ComplaintException;
import com.model.Complaint;

public class EmployeeCheckComplaintHistory {

	public void employeeCheckComplaintHistory() {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the employee id : ");
		int empId = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			List<Complaint> li = dao.checkComplainHistory(empId);
			li.forEach( c -> {
				System.out.println("Complaint id : "+c.getcId());
				System.out.println("Complaint status : "+c.getStatus());
				System.out.println("Complaint registered by Employee id : "+c.getEmpId());
				System.out.println("Complained assigned to Engineer id : "+c.getEngId());
				System.out.println("Complaint of type : "+c.getType());
				
				System.out.println("=====================================");
			});
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
