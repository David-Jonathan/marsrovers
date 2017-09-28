package com.au.covata.marsrovers.exception;

public class InvalidInputException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
    The constructor is used for initialising the InvalidInputException along with
    description parameter, which in turn calls constructor of Exception class.

    @param  description  description of the error scenario occurred
    @return
    */
    public InvalidInputException(String description) {
        super(description);
    }

}
