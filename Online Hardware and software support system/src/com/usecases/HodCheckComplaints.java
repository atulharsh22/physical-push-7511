package com.usecases;

import java.util.ArrayList;
import java.util.List;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exception.ComplaintException;
import com.model.Complaint;

public class HodCheckComplaints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HodDao dao = new HodDaoImpl();
		
		try {
			List<Complaint> li = dao.getAllComplaints();
			
			li.forEach( c -> {
				System.out.println("Complaint Id is : "+c.getcId());
				System.out.println("Complaint status : "+c.getStatus());
				System.out.println("Complaint registered by Employee with Employee id : "+c.getEmpId());
				System.out.println("Complaint assigned to enginner with Engineer id : "+c.getEngId());
				System.out.println("Complaint type : "+c.getType());
				
				System.out.println("--------------------------------");
			});
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
	}

}
