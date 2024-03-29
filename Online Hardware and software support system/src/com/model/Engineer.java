package com.model;

public class Engineer {
	private int engId;
	private String name;
	private String username;
	private String password;
	private String category;
	
	public Engineer() {}

	public Engineer(int engId, String name, String username, String password, String category) {
		super();
		this.engId = engId;
		this.name = name;
		this.username = username;
		this.password = password;
		this.category = category;
	}

	public int getEngId() {
		return engId;
	}

	public void setEngId(int engId) {
		this.engId = engId;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Engineer [engId=" + engId + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", category=" + category + "]";
	}
	
	

}
