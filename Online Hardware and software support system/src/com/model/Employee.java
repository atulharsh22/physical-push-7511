package com.model;

public class Employee {
	private int empId;
	private String name;
	private String username;
	private String password;
	
	public Employee() {}

	public Employee(int empId, String name, String username, String password) {
		super();
		this.empId = empId;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
}
