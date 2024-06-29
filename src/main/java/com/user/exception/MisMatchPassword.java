package com.user.exception;

public class MisMatchPassword extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MisMatchPassword(String message) {
		super(message);
	}

}
