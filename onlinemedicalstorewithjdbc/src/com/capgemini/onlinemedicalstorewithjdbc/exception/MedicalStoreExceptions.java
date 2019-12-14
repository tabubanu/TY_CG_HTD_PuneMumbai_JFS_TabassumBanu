package com.capgemini.onlinemedicalstorewithjdbc.exception;

public class MedicalStoreExceptions extends Exception {

	
	private static final long serialVersionUID = 1L;

	public MedicalStoreExceptions(String s) {
		System.err.println(s);
	}
}
