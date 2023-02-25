package com.model;

public class EngineerComplaintDTO {
	
	//Engineer table
	private int engId;
	private String engName;
	private String username;
	private String password;
	
	//Complaint table
	private int cId;
	private String status;
	private int empId;
	private String type;
	
	public EngineerComplaintDTO() {}

	public EngineerComplaintDTO(int engId, String engName, String username, String password, int cId, String status,
			int empId, String type) {
		super();
		this.engId = engId;
		this.engName = engName;
		this.username = username;
		this.password = password;
		this.cId = cId;
		this.status = status;
		this.empId = empId;
		this.type = type;
	}

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
	}

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "EngineerComplaintDTO [engId=" + engId + ", engName=" + engName + ", username=" + username
				+ ", password=" + password + ", cId=" + cId + ", status=" + status + ", empId=" + empId + ", type="
				+ type + "]";
	}
	
	
}
