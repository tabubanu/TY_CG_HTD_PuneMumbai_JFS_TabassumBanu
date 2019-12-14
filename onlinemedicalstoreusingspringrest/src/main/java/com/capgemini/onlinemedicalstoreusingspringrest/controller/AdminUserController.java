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

import com.capgemini.onlinemedicalstoreusingspringrest.beans.AdminUserBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.MedicalResponse;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.ProductBean;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.UserBean;
import com.capgemini.onlinemedicalstoreusingspringrest.services.AdminUserService;



@RestController  
@CrossOrigin(origins="*" ,allowedHeaders = "*", allowCredentials = "true")  
 
public class AdminUserController {
	@Autowired
	private AdminUserService adminUserService;

	
	@GetMapping(path = "/adminUserLogin")
	public MedicalResponse adminUserLogin(@RequestParam String email, @RequestParam String password,
			@RequestParam String type) {
		AdminUserBean adminUserLogin = adminUserService.adminUserLogin(email, password, type);
		MedicalResponse response = new MedicalResponse();
		if (adminUserLogin != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Log In Scussessfully!!!");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Please Enter Valid Credentials");
		}
		return response;
	}// End of adminLogin()

	@PutMapping(path = "/userRegister", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse userRegister(@RequestBody AdminUserBean adminUserBean) {
		boolean registerUser = adminUserService.userRegister(adminUserBean);
		MedicalResponse response = new MedicalResponse();
		if (registerUser) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("You Registered Scussessfully!!");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Failed To Register...");
		}
		return response;
	}// End of userRegister()

	@GetMapping(path = "/displayAllMedicine", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public MedicalResponse displayAllMedicine() {
		List<ProductBean> productList = adminUserService.getAllMedicines();
		MedicalResponse response = new MedicalResponse();
		if (productList != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("This is Medicine List");
			response.setProductList(productList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("MedicineList Is Not found!!!");
		}
		return response;
	} // End of displayAllMedicine()

	@GetMapping(path = "/getAllUsers", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public MedicalResponse getAllUsers() {
		List<AdminUserBean> userList = adminUserService.getAllUsers();
		MedicalResponse response = new MedicalResponse();
		if (userList != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("This Are All User");
			response.setUserList(userList);
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Information is not found");
		}
		return response;
	}// End of getAllUsers()

	@DeleteMapping(path = "/deleteUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponse deleteUser(@RequestParam int id) {
		boolean userDelete = adminUserService.deleteUser(id);
		MedicalResponse response = new MedicalResponse();
		if (userDelete) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Deleted successfully.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable To Delete User........");
		}
		return response;
	} // End of deleteUser()

	@DeleteMapping(path = "/userLogout")
	public MedicalResponse userLogout(@RequestParam int userid) {
		boolean userLogout = adminUserService.userLogout(userid);
		MedicalResponse response = new MedicalResponse();
		if (userLogout) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("Log Out Scussessfully!!!");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("Unable To Logout!!");
		}
		return response;
	}// End of adminLogin()
}
