package com.usecases;

import java.util.List;
import java.util.Scanner;

import com.dao.EngineerDao;
import com.dao.EngineerDaoImpl;
import com.exception.ComplaintException;
import com.model.Complaint;

public class EngineerCheckAttendedComplaints {

	public void engineerCheckAttendedComplaints() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Engineer id of engineer :");
		int engid=sc.nextInt();
		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			List<Complaint> li =dao.checkAttendedComplaints(engid);
			
			if(li.isEmpty())
			{
				System.out.println("No complaint found for the engineer");
			}
			else
			{
				li.forEach( c -> {
					
					System.out.println("Complaint id : "+c.getcId());
					System.out.println("Complaint status : "+c.getStatus());
					System.out.println("Complaint filed by employee with Employee id : "+c.getEmpId());
					System.out.println("Complaint assigned to engineer with Engineer id : "+c.getEngId());
					System.out.println("Complaint type : "+c.getType());
					
					System.out.println("===============================================");
				});
			}
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
