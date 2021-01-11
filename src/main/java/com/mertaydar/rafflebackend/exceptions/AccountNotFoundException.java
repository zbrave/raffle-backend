package com.mertaydar.rafflebackend.exceptions;

public class AccountNotFoundException extends RuntimeException {

	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String id) {
	    super("Could not find account " + id);
	  }
}
