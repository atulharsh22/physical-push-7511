package com.dao;

import java.util.List;

import com.exception.ComplaintException;
import com.exception.EmployeeException;
import com.model.Complaint;
import com.model.Employee;
import com.model.EngineerComplaintDTO;

public interface EmployeeDao {
	
	public String registerEmployee(String name,String username,String password) throws EmployeeException;
	
	public Employee loginEmployee(String username,String password) throws EmployeeException;
	
	public Complaint registerComplain(int empId,String type) throws ComplaintException;
	
	public EngineerComplaintDTO checkComplaintStatus(int cId) throws ComplaintException;
	
	public List<Complaint> checkComplainHistory(int empID) throws ComplaintException;
	
	public String changePassword(int empId,String username,String password,String newPassword) throws EmployeeException;
}
