package com.app.ExpenseManagerLast.Exception;

public class UserNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7285165435995929419L;

	public UserNotFoundException(String message) {
		// TODO Auto-generated constructor stub
		super();
	}

	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
