package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.exception.EngineerException;
import com.exception.HodException;
import com.model.Engineer;
import com.model.Hod;
import com.utility.DBUtil;

public class HodDaoImpl implements HodDao{

	@Override
	public Hod loginHod(String username, String password) throws HodException {
		// TODO Auto-generated method stub
		Hod hod= null;
		
		try (Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps=conn.prepareStatement("Select * from hod where username=? AND password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				hod = new Hod();
				
				hod.setName(rs.getString("name"));
				
			}
			else
			{
				throw new HodException("Invalid username or password");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new HodException(e.getMessage());
		}
		
		return hod;
	}

	@Override
	public String registerEngineer(Engineer eng) throws EngineerException {
		// TODO Auto-generated method stub
		String msg="Not inserted ...";
		
		try (Connection conn=DBUtil.provideConnection()){
			PreparedStatement ps=conn.prepareStatement("insert into Engineer(name,username,password,category) values(?,?,?,?)");
			ps.setString(1,eng.getName() );
			ps.setString(2, eng.getUsername());
			ps.setString(3, eng.getPassword());
			ps.setString(4, eng.getCategory());
			
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg="Engineer registered successfully...";
			}
			else
			{
				throw new EngineerException("Wrong entry details");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
			
		}
		
		
		return msg;
	}

	@Override
	public List<Engineer> getAllEngineerDetails() throws EngineerException {
		// TODO Auto-generated method stub
		List<Engineer> li=new ArrayList<>();
		try (Connection conn=DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("Select * from Engineer");
			ResultSet rs= ps.executeQuery();
			
			while(rs.next())
			{
				int engId=rs.getInt("Engid");
				String name=rs.getString("name");
				String username=rs.getString("username");
				String password=rs.getString("password");
				String category=rs.getString("category");
				
				Engineer eng=new Engineer(engId,name,username,password,category);
				li.add(eng);
						
			}
			
			if(li.isEmpty())
			{
				throw new EngineerException("No Engineer found");
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EngineerException();
		}
		
		
		
		
		return li;
	}

	@Override
	public String deleteEngineer(int engId) throws EngineerException {
		// TODO Auto-generated method stub
		String msg = "Not deleted";
		try (Connection conn = DBUtil.provideConnection()) {
			
			PreparedStatement ps = conn.prepareStatement("delete from Engineer where Engid=?");
			ps.setInt(1, engId);
			int x=ps.executeUpdate();
			
			if(x>0)
			{
				msg="Record deleted with Engineer Id "+engId;
			}
			else
			{
				throw new EngineerException("No record found with Engineer Id "+engId);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new EngineerException(e.getMessage());
		}
		
		return msg;
	}
	
}
