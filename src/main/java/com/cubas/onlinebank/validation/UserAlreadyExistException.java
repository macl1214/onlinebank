package com.cubas.onlinebank.validation;

public class UserAlreadyExistException extends Exception {

	public UserAlreadyExistException(String errorMessage) {
		super(errorMessage);
	}
}
