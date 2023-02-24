package com.dao;

import com.exception.ComplaintException;
import com.exception.EmployeeException;
import com.model.Complaint;
import com.model.Employee;

public interface EmployeeDao {
	
	public String registerEmployee(String name,String username,String password) throws EmployeeException;
	
	public Employee loginEmployee(String username,String password) throws EmployeeException;
	
	public Complaint registerComplain(int empId,String type) throws ComplaintException;
}
