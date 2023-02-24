package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.ComplaintException;
import com.exception.EngineerException;
import com.model.Complaint;
import com.model.Engineer;

import com.utility.DBUtil;

public class EngineerDaoImpl implements EngineerDao{

	@Override
	public Engineer loginEngineer(String username, String password) throws EngineerException {
		// TODO Auto-generated method stub
		Engineer eng=null;
		
		try (Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("Select * from Engineer where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				eng = new Engineer();
				
				eng.setEngId(rs.getInt("engid"));
				eng.setName(rs.getString("name"));
				eng.setUsername(rs.getString("username"));
				eng.setPassword(rs.getString("password"));
				eng.setCategory(rs.getString("category"));
				
				
			}
			else
			{
				throw new EngineerException("Invalid username or password");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return eng;
	}

	@Override
	public List<Complaint> checkAssignedComplaints(int engid) throws ComplaintException {
		// TODO Auto-generated method stub
		List<Complaint> li = new ArrayList<>();
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Complaints where engid=? AND status='Assigned'");
			ps.setInt(1, engid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int cid=rs.getInt("cid");
				String status = rs.getString("status");
				int empid = rs.getInt("empid");
				
				String type = rs.getString("type");
				
				Complaint c = new Complaint(cid,status,empid,engid,type);
				
				li.add(c);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return li;
	}

	@Override
	public String updateComplaintStatus(int cid,String status) throws ComplaintException {
		// TODO Auto-generated method stub
		String msg = "Complaint not updated, check your complaint id";
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("update complaints set status=? where cid=?");
			ps.setInt(1,cid);
			ps.setString(2,status);
			int x = ps.executeUpdate();
			
			if(x>0)
			{
				msg="Status of the complaint with complaint id "+cid+" updated to "+status;
			}
			else
			{
				throw new ComplaintException("Complaint with given complaint id not found");
				
			}
		} catch (SQLException e) {
			// TODO: handle exception
			throw new ComplaintException(e.getMessage());
		}
		
		return msg;
	}
	

	@Override
	public List<Complaint> checkAttendedComplaints(int engid) throws ComplaintException {
		// TODO Auto-generated method stub
		List<Complaint> li = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			PreparedStatement ps = conn.prepareStatement("select * from Complaints where engid=?");
			ps.setInt(1, engid);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				int cid=rs.getInt("cid");
				String status = rs.getString("status");
				int empid = rs.getInt("empid");
				
				String type = rs.getString("type");
				
				Complaint c = new Complaint(cid,status,empid,engid,type);
				
				li.add(c);
				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return li;
	}
	

	@Override
	public String changeEngineerPassword(int engid,String password, String newPassword)
			throws EngineerException {
		// TODO Auto-generated method stub
		String msg = "Password not changed";
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update Engineer set password = ? where engid=? AND password=?");
			ps.setInt(2,engid);
			ps.setString(1, newPassword);
			ps.setString(3, password);
			
			int x = ps.executeUpdate();
			
			if(x>0) 
			{
				msg="Password changed successfully";
			}
			else
			{
				msg="Wrong Engineer id or password";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return msg;
		
	}

}


