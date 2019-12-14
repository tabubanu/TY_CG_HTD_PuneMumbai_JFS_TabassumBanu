package com.capgemini.onlinemedicalstoreusingspringrest.beans;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicalResponse {

	private int statusCode;
	private String message;
	private String description;
	//private AdminUserBean adminUserBean;

	private List<ProductBean> productList;

	private List<AdminUserBean> userList;

	public double bill;

	public List<MessageBean> messageList;

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}


	// getter & setter
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
//	public AdminUserBean getAdminUserBean() {
//		return adminUserBean;
//	}
//
//	public void setAdminUserBean(AdminUserBean adminUserBean) {
//		this.adminUserBean = adminUserBean;
//	}


	public List<ProductBean> getProductList() {
		return productList;
	}

	public void setProductList(List<ProductBean> productList) {
		this.productList = productList;
	}
	
	public List<MessageBean> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<MessageBean> messageList) {
		this.messageList = messageList;
	}
	public List<AdminUserBean> getUserList() {
		return userList;
	}

	public void setUserList(List<AdminUserBean> userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "MedicalResponse [statusCode=" + statusCode + ", message=" + message + ", description=" + description
				+ ", productList=" + productList + ", userList=" + userList + ", bill=" + bill + ", messageList="
				+ messageList + "]";
	}

	
	

	

}
