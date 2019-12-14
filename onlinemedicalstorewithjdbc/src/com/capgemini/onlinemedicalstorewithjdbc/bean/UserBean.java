package com.capgemini.onlinemedicalstorewithjdbc.bean;

public class UserBean {
	private int user_id;
	private String user_name;
	private String email;
	private long mobile_number;
	private String password;
	
	//Getters and Setters
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(long mobile_number) {
		this.mobile_number = mobile_number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserBean [user_id=" + user_id + ", user_name=" + user_name + ", email=" + email + ", mobile_number="
				+ mobile_number + ", password=" + password + "]";
	}//End of toString()
}//End of class
