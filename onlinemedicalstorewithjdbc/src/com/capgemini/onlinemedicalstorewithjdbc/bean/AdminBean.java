package com.capgemini.onlinemedicalstorewithjdbc.bean;

public class AdminBean {
	private int admin_id;
	private String admin_name;
	private String email;
	private long mobile_number;
	private String password;
	
	//Getters and Setters
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
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
		return "AdminBean [admin_id=" + admin_id + ", admin_name=" + admin_name + ", email=" + email
				+ ", mobile_number=" + mobile_number + ", password=" + password + "]";
	}//End of toString()
}
