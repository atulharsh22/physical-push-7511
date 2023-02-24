package com.dao;

import java.util.List;

import com.exception.ComplaintException;
import com.exception.EngineerException;
import com.model.Complaint;
import com.model.Engineer;

public interface EngineerDao {
	public Engineer loginEngineer(String username,String password) throws EngineerException;
	public List<Complaint> checkAssignedComplaints(int engid) throws ComplaintException;
	public String updateComplaintStatus(int cid,String status) throws ComplaintException;
	public List<Complaint> checkAttendedComplaints(int engid) throws ComplaintException;
	public String changeEngineerPassword(int engid,String password,String newPassword) throws EngineerException;
}
