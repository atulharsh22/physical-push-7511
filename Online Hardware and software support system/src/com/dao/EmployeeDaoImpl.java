package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.ComplaintException;
import com.exception.EmployeeException;
import com.model.Complaint;
import com.model.Employee;
import com.model.EngineerComplaintDTO;
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
				
				
				PreparedStatement ps2 = conn.prepareStatement("select cid from Complaints where empid=? AND type=? ");
				ps2.setInt(1, empId);
				ps2.setString(2, type);
				
				ResultSet rs = ps2.executeQuery();
				
				while(rs.next())
				{
					int cid = rs.getInt("cid");
					
					comp.setcId(cid);
				}
				
				
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
	


	@Override
	public EngineerComplaintDTO checkComplaintStatus(int cId) throws ComplaintException {
		// TODO Auto-generated method stub
		EngineerComplaintDTO dto =null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select e.engid,e.name,c.cid,c.status,c.empid,c.type from Engineer e INNER JOIN Complaints c ON e.engID = c.engID where cid=? ");
			
			ps.setInt(1,cId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				dto = new EngineerComplaintDTO();
				dto.setEngId(rs.getInt("engId"));
				dto.setEngName(rs.getString("name"));
				dto.setcId(rs.getInt("cid"));
				dto.setStatus(rs.getString("status"));
				dto.setEmpId(rs.getInt("empid"));
				dto.setType(rs.getString("type"));
				
			}
			else
			{
				throw new ComplaintException("Complaint not assigned");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ComplaintException(e.getMessage());
		}
		
		
		return dto;
	}



	@Override
	public List<Complaint> checkComplainHistory(int empID) throws ComplaintException {
		// TODO Auto-generated method stub
		List<Complaint> li = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from Complaints where empId=?");
			ps.setInt(1, empID);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				Complaint comp = new Complaint();
				comp.setcId(rs.getInt("cid"));
				comp.setEmpId(rs.getInt("empId"));
				comp.setEngId(rs.getInt("engId"));
				comp.setStatus(rs.getString("status"));
				comp.setType(rs.getString("type"));
				
				li.add(comp);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		return li;
	}


	@Override
	public String changePassword(int empId, String username, String password, String newPassword)
			throws EmployeeException {
		// TODO Auto-generated method stub
		String msg = "Password not updated";
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("Update Employee set password = ? where empId=? AND username=? And password=?");
			ps.setString(1, newPassword);
			ps.setInt(2, empId);
			ps.setString(3, username);
			ps.setString(4, password);
			
			int x = ps.executeUpdate();
			
			if(x>0)
			{
				msg="Password updated successfully";
			}
			else
			{
				throw new EmployeeException("Invalid credentials ");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		return msg;
	}
	
	
	
}

