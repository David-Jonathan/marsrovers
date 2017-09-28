package com.au.covata.marsrovers.validation;

public interface Validator {

    /*
    validate method that checks if certain rules are met and exception thrown if not.

    @param
    @return
     */
    public void validate() throws Exception;
    
    final static String STANDARD_ERROR_REPORTING = "Please report the error to the application administrator (admin@marsrovers.com.au) with the error code/message";

}

