package com.dao;

import java.util.List;

import com.exception.ComplaintException;
import com.exception.EngineerException;
import com.exception.HodException;
import com.model.Complaint;
import com.model.Engineer;
import com.model.Hod;

public interface HodDao {
	public Hod loginHod(String username,String password) throws HodException;
	public String registerEngineer(Engineer eng) throws EngineerException;
	public List<Engineer> getAllEngineerDetails() throws EngineerException;
	public String deleteEngineer(int engId) throws EngineerException;
	public List<Complaint> getAllComplaints() throws ComplaintException;
	public String assignComplaintToEngineer(int cid,int engid) throws EngineerException;
}
