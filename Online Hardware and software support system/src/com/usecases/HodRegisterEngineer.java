package com.usecases;

import java.util.Scanner; 

import com.dao.HodDao;
import com.dao.HodDaoImpl;
import com.exception.EngineerException;
import com.model.Engineer;

public class HodRegisterEngineer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Engineer name");
		String name=sc.nextLine();
		System.out.println("Enter Engineer username");
		String username=sc.nextLine();
		System.out.println("Enter Engineer password");
		String password=sc.nextLine();
		System.out.println("Enter Engineer category(Hardware/Software)");
		String category=sc.nextLine();
			
		Engineer eng=new Engineer();
		eng.setName(name);
		eng.setUsername(username);
		eng.setPassword(password);
		eng.setCategory(category);
		
		HodDao dao=new HodDaoImpl();
		String result="";
		try {
			result = dao.registerEngineer(eng);
		} catch (EngineerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
	}

}
