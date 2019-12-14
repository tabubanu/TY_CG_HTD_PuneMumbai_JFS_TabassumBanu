package com.capgemini.onlinemedicalstoreusingjpahibernate.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MedicalStoreValidationImpl implements MedicalStoreValidations {

	@Override
	public Integer validateNumber(String id) {
		Pattern pat = Pattern.compile("\\d+");
		Matcher mat = pat.matcher(id);
		if(mat.matches()) {
			return Integer.parseInt(id);
		} else {
		return null;
	}
	}

	@Override
	public String emailValidate(String email) {
		Pattern pat = Pattern.compile("\\D+\\@\\D+\\.\\D+");
		Matcher mat = pat.matcher(email);
		if(mat.matches()) {
			return email;
		} else {
		return null;
	}
	}

	@Override
	public Double doubleValidate(String number) {
		Pattern pat = Pattern.compile("\\d+.\\d\\d");
		Matcher mat = pat.matcher(number);
		if(mat.matches()) {
			return Double.parseDouble(number);
		} else {
		return null;
	}
	}

	@Override
	public Long contactValidate(String contact) {
		Pattern pat = Pattern.compile("\\d{10}");
		Matcher mat = pat.matcher(contact);
		if(mat.matches()) {
			return Long.parseLong(contact);
		} else {
		return null;
	}
	}

	@Override
	public String passwordValidate(String password) {
		Pattern pat = Pattern.compile(".{8,}");
		Matcher mat = pat.matcher(password);
		if(mat.matches()) {
			return password;
		} else {
		return null;
	}
	}

	@Override
	public String nameValidate(String name) {

		Pattern pat = Pattern.compile("\\D+");
		Matcher mat = pat.matcher(name);
		if(mat.matches()) {
			return name;
		} else {
			return null;
		}
		
	}

}
