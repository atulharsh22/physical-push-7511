package com.usecases;

import java.util.List;

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exception.EngineerException;
import com.model.Engineer;

public class HodCheckEngineer {

	public void hodCheckEngineer() {
		// TODO Auto-generated method stub
		HodDao dao = new HodDaoImpl();
		
		try {
			List<Engineer> li=dao.getAllEngineerDetails();
			
			li.forEach( e -> {
				System.out.println("Engineer Id : "+e.getEngId());
				System.out.println("Engineer's name is : "+e.getName());
				System.out.println("Engineer's username is : "+e.getUsername());
				System.out.println("Engineer's password is : "+e.getPassword());
				System.out.println("Engineer's category is : "+e.getCategory());
				
				System.out.println("--------------------------------");
			});
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	}

}
