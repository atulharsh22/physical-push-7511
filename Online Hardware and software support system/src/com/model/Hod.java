package com.model;

public class Hod {
	private int hodId;
	private String name;
	private String username;
	private String password;
	
	public Hod() {}

	public Hod(int hodId, String name, String username, String password) {
		super();
		this.hodId = hodId;
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public int getHodId() {
		return hodId;
	}

	public void setHodId(int hodId) {
		this.hodId = hodId;
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
		return "Hod [hodId=" + hodId + ", name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
