package com.capgemini.onlinemedicalstoreusingjpahibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_history")
public class OrderHistory {
	@Id
	@Column(name = "orderid")
	private int orderid;
	@Column(name = "product_id")
	private int medicineid;
	@Column
	private String name;
	@Column
	private double price;
	@Column
	private String category;
	@Column
	private String availibility;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getAvailibility() {
		return availibility;
	}

	public void setAvailibility(String availibility) {
		this.availibility = availibility;
	}

	public int getMedicineid() {
		return medicineid;
	}

	public void setMedicineid(int medicineid) {
		this.medicineid = medicineid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
