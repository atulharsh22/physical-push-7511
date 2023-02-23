package com.model;

public class Complaint {
	private int cId;
	private String status;
	private int empId;
	private int engId;
	private String type;
	
	public Complaint() {}

	public Complaint(int cId, String status, int empId, int engId, String type) {
		super();
		this.cId = cId;
		this.status = status;
		this.empId = empId;
		this.engId = engId;
		this.type = type;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Complaint [cId=" + cId + ", status=" + status + ", empId=" + empId + ", engId=" + engId + ", type="
				+ type + "]";
	}
	
	
}
