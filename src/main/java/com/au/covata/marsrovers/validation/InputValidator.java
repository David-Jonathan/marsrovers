package com.au.covata.marsrovers.validation;

import org.apache.log4j.Logger;

import com.au.covata.marsrovers.exception.InvalidInputException;

public class InputValidator implements Validator {

	final static Logger logger = Logger.getLogger(InputValidator.class);
    private String xCoordinate;
    private String yCoordinate;
    /*
    The constructor is used for initialising the InputValidator along with coordinates.

    @param  xCoordinate to be validated
    @param  yCoordinate to be validated
    @return
    */
    public InputValidator(String xCoordinate, String yCoordinate) {
    	
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /*
    Validation method that checks if plateau coordinates
    are valid and throws InvalidInputException if the inputs are invalid.

    @param
    @return
     */
    @Override
    public void validate() throws InvalidInputException {
    	  
    	if(!xCoordinate.matches("\\d+") || !yCoordinate.matches("\\d+")) {
    		logger.error(STANDARD_ERROR_REPORTING);
    		logger.error("The Plateau size input values must be valid positive integers.");
    		throw new InvalidInputException("The Plateau size input values must be greater than 0.");
    	} else { 
	        if(new Integer(xCoordinate).intValue() <= 0 || new Integer(yCoordinate).intValue() <= 0) {
	    		logger.error(STANDARD_ERROR_REPORTING);
	    		logger.error("The Plateau size input values must be greater than 0.");
	        	throw new InvalidInputException("The Plateau size input values must be greater than 0.");
	        }
    	}
    }


}
