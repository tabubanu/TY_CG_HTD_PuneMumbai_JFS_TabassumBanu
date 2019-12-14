package com.capgemini.onlinemedicalstoreusingjpahibernate.exception;

import com.capgemini.onlinemedicalstoreusingjpahibernate.validation.MedicalStoreValidationImpl;
import com.capgemini.onlinemedicalstoreusingjpahibernate.validation.MedicalStoreValidations;

public class ExceptionMethods {

	static MedicalStoreValidations valid = new MedicalStoreValidationImpl();
	
	public static Integer numberValidation(String num) throws MedicalStoreExceptions {
		Integer number = valid.validateNumber(num);
		if(number != null) {
			return number;
		} else {
		throw new MedicalStoreExceptions("wrong Input used !!! \n Kindly enter number");
		}
	}
	
	public static String emailValidator(String email) throws MedicalStoreExceptions {
		String emailId = valid.emailValidate(email);
		if(emailId != null) {
			return emailId;
		} else {
		throw new MedicalStoreExceptions("wrong Input used !!! \n Kindly enter valid emailId");
		}
	}

	public Long contactValidator(String mobileNumber) throws MedicalStoreExceptions {
		Long mobile = valid.contactValidate(mobileNumber);
		if(mobile != null) {
			return mobile;
		} else {
		throw new MedicalStoreExceptions("Enter valid number in Use!!!");
		}
	}
	public Double doubleValidator(String number) throws MedicalStoreExceptions {
		Double number1 = valid.doubleValidate(number);
		if(number1 != null) {
			return number1;
		} else {
			throw new MedicalStoreExceptions("Enter valid price");
		}
	}
	public static String passwordValidator(String password) throws MedicalStoreExceptions {
		String password1 = valid.passwordValidate(password);
		if(password1 != null) {
			return password1;
		} else {
			throw new MedicalStoreExceptions("Enter password with minimum of 8 digits");
		}
	}
	
	public static String nameValidator(String name) throws MedicalStoreExceptions {
		String name1 = valid.nameValidate(name);
		if(name1 != null) {
			return name1;
		} else {
			throw new MedicalStoreExceptions("Enter valid name type data");
		}
	}
	
}
