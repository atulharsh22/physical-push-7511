package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.exception.ComplaintException;
import com.exception.EmployeeException;
import com.model.Complaint;
import com.model.Employee;
import com.utility.DBUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	@Override
	public String registerEmployee(String name, String username, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		String msg="Employee not registered";
		
		try (Connection conn = DBUtil.provideConnection()) {
			PreparedStatement ps = conn.prepareStatement("insert into Employee(name,username,password) values(?,?,?)");
			
			ps.setString(1, name);
			ps.setString(2, username);
			ps.setString(3, password);
			
			int x=ps.executeUpdate();
			if(x>0)
			{
				msg="Record inserted successfully";
			}
			else
			{
				throw new EmployeeException("Registration failed");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		
		return msg;
	}
	

	@Override
	public Employee loginEmployee(String username, String password) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee emp = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Employee where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				emp=new Employee();
				
				emp.setEmpId(rs.getInt("empid"));
				emp.setName(rs.getString("name"));
				emp.setUsername(rs.getString("username"));
				emp.setPassword(rs.getString("password"));
			}
			else
			{
				throw new EmployeeException("Invalid login credentials");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		return emp;
	}
	


	@Override
	public Complaint registerComplain(int empId, String type) throws ComplaintException {
		// TODO Auto-generated method stub
		Complaint comp=new Complaint();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into Complaints(status,empid,type) values (?,?,?)");
			ps.setString(1, "raised");
			ps.setInt(2, empId);
			ps.setString(3, type);
			
			int x = ps.executeUpdate();
			if(x>0)
			{
				System.out.println("Complaint raised successfully ");
				
				comp.setStatus("raised");
				comp.setEmpId(empId);
				comp.setType(type);
			}
			else
			{
				System.out.println("Complaint can't be raised");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ComplaintException(e.getMessage());
		}
		
		return comp;
	}

}

