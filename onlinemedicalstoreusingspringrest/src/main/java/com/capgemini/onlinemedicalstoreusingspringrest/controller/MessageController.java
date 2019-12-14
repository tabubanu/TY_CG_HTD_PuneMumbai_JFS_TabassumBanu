package com.capgemini.onlinemedicalstoreusingspringrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinemedicalstoreusingspringrest.beans.MedicalResponses;
import com.capgemini.onlinemedicalstoreusingspringrest.beans.MessageBean;
import com.capgemini.onlinemedicalstoreusingspringrest.services.MessageServices;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
public class MessageController {
	@Autowired
	private MessageServices messageService;
	
	@GetMapping(path = "/showAdminMessage",produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponses showAdminMessage() {
		List<MessageBean> messageBean = messageService.getMessage();
		MedicalResponses response = new MedicalResponses();
		if (messageBean != null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setMessageList(messageBean);
			response.setDescription("User Queries acquired.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Queries Not Acquired........");
		}
		return response;
	}//End of getAdminMessage()
	
	@GetMapping(path = "/showUserMessage", produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponses showUserMessage(@RequestParam int userId) {
		List<MessageBean> messageBeans= messageService.getResponse(userId);
		MedicalResponses response=new MedicalResponses();
		if (messageBeans!=null) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setMessageList(messageBeans);
			response.setDescription("User Queries acquired.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Queries Not Acquired........");
		}
		return response;
	}//End of getUserMessage()
	
	@PutMapping(path = "/adminResponse",produces = MediaType.APPLICATION_JSON_VALUE)
	public MedicalResponses adminResponse(@RequestParam int userId, @RequestParam String message, @RequestParam String messageType) {
		boolean isSent = messageService.sendMessage(userId, message, messageType);
		MedicalResponses response=new MedicalResponses();
		if (isSent) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Queries Replied.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Queries Not Replied........");
		}
		return response;
	}//End of adminResponse()
	
	@PutMapping(path = "/userResponse")
	public MedicalResponses userResponse(@RequestParam int userId,@RequestParam String message,@RequestParam String messageType) {
		boolean isSent = messageService.sendMessage(userId, message, messageType);
		MedicalResponses response=new MedicalResponses();
		if (isSent) {
			response.setStatusCode(201);
			response.setMessage("Success");
			response.setDescription("User Queries Sent.......");
		} else {
			response.setStatusCode(401);
			response.setMessage("Failed");
			response.setDescription("User Queries Not Sent........");
		}
		return response;
	}//End of userResponse()
}//End of Controller Class
