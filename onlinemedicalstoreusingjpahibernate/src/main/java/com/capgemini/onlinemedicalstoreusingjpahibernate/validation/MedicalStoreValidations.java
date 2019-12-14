package com.capgemini.onlinemedicalstoreusingjpahibernate.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface MedicalStoreValidations {

	public Integer validateNumber(String id);
	public String emailValidate(String email);
	public Double doubleValidate(String number);
	public Long contactValidate(String contact);
	public String passwordValidate(String password);
	public String nameValidate(String name);
	}

