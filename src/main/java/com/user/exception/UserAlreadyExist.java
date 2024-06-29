package com.user.exception;

public class UserAlreadyExist extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExist(String message) {
		super(message);

	}

}
