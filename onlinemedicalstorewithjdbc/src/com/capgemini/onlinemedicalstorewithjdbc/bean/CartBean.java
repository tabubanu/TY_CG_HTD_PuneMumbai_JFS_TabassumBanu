package com.capgemini.onlinemedicalstorewithjdbc.bean;

public class CartBean {

		private int productId;
		private String productName;
		private String productBrand;
		private String category;
		private double price;
		private String details;
		private String available;
		
		//Getters and Setters
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductBrand() {
			return productBrand;
		}
		public void setProductBrand(String productBrand) {
			this.productBrand = productBrand;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public String getDetails() {
			return details;
		}
		public void setDetails(String details) {
			this.details = details;
		}
		public String getAvailable() {
			return available;
		}
		public void setAvailable(String available) {
			this.available = available;
		}
		@Override
		public String toString() {
			return "CartBean [available=" + available + ", category=" + category + ", details=" + details + ", price="
					+ price + ", productBrand=" + productBrand + ", productId=" + productId + ", productName=" + productName
					+ "]";
		}//End of toString()
	}//End of Class

