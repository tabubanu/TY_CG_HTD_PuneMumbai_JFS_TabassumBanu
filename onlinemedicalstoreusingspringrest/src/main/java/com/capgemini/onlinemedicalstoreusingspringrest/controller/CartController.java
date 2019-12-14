package com.capgemini.onlinemedicalstoreusingspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.CartBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.MedicalResponses;
import com.capgemini.onlinemedicalstoreusingspringrest.services.CartServices;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")

public class CartController {

	
		@Autowired
		private CartServices cartServices;

		@PutMapping(path = "/addProductinCart" )
		public MedicalResponses cartProduct(@RequestBody CartBean cartBean) {
			boolean isAdded = cartServices.addIntoCart(cartBean.getUserId(), cartBean.getProductId());
			MedicalResponses response = new MedicalResponses();
			if (isAdded) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Product Added to cart.......");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setDescription("Unable To Add Product........");
			}
			return response;
		}// End of cartProduct()

		@DeleteMapping(path = "/removeProductinCart", produces = MediaType.APPLICATION_JSON_VALUE)
		public MedicalResponses removeCartProduct(@RequestParam int userId, @RequestParam int cartId) {
			boolean isDeleted = cartServices.removeFromCart(userId, cartId);
			MedicalResponses response = new MedicalResponses();
			if (isDeleted) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Product deleted from cart.......");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setDescription("Unable To Delete Product From Cart........");
			}
			return response;
		}// End of cartDelete()

		@GetMapping(path = "/showCartProducts", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public MedicalResponses showCart(@RequestParam int userId) {
			List<CartBean> cartList = cartServices.showAllProducts(userId);
			MedicalResponses response = new MedicalResponses();
			if (cartList != null) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("All Cart Products Data Found........");
				response.setCartList(cartList);
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setDescription("Unable To Found Cart Products........");
			}
			return response;
		}// End of getAllUsers()

		@GetMapping(path = "/userTotalBill", produces = MediaType.APPLICATION_JSON_VALUE)
		public MedicalResponses totalBill(@RequestParam int userId) {
			double bill = cartServices.totalBill(userId);

			MedicalResponses response = new MedicalResponses();
			if (bill > 0.0) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setPrice(bill);
				response.setDescription("Payment Done.......");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setPrice(bill);
				response.setDescription("payment Failed........");
			}
			return response;
		}// End of totalBill()

		@DeleteMapping(path = "/deleteUserCart", produces = MediaType.APPLICATION_JSON_VALUE)
		public MedicalResponses deleteCart(@RequestParam int userId) {
			boolean isDeleted = cartServices.deleteCart(userId);
			MedicalResponses response = new MedicalResponses();
			if (isDeleted) {
				response.setStatusCode(201);
				response.setMessage("Success");
				response.setDescription("Cart deleted Successfully.......");
			} else {
				response.setStatusCode(401);
				response.setMessage("Failed");
				response.setDescription("Unable To Delete Cart........");
			}
			return response;
		}// End of deleteCart()

	}// End of Controller Class


