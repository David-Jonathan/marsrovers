package com.au.covata.marsrovers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;

import com.au.covata.marsrovers.exception.InvalidInputException;
import com.au.covata.marsrovers.service.impl.DeployMarsRoversImpl;
import com.au.covata.marsrovers.util.Rover;
import com.au.covata.marsrovers.validation.InputValidator;
import com.au.covata.marsrovers.validation.Validator;

public class MarsRoversApplication {
	
	final static Logger logger = Logger.getLogger(MarsRoversApplication.class);
	public static void main(String args[]) {
		
		try {
			String content = new String(Files.readAllBytes(Paths.get("input.txt")));
			
			DeployMarsRoversImpl rovers = new DeployMarsRoversImpl();
			String[] inputLines = content.split("\n");
			
			String[] inputTokens = inputLines[0].split(" ");

			validate(inputTokens[0].trim(), inputTokens[1].trim());
			
				List<Rover> listRovers;
					listRovers = rovers.initMarsRovers(inputLines);
				
				List<String> positions = rovers.moveRovers(listRovers);
	
	
				for(String str : positions) {
					logger.info("Final Positions of the Rovers : " + str);
				}

		} catch (Exception e) {
			logger.error(Validator.STANDARD_ERROR_REPORTING);
			logger.error(e.getMessage());
		}		
	}

    /*
    Validation method that checks if plateau coordinates
    are valid and throws InvalidInputException if the inputs are invalid.

    @param
    @return
    */
    public static boolean validate(String strTopRightX, String strTopRightY) throws InvalidInputException {
    	
    	boolean isValid = false;
    	InputValidator inputValidator = new InputValidator(strTopRightX, strTopRightY);
        try {
            inputValidator.validate();
            isValid = true;
        } catch (InvalidInputException exception) {
        	logger.error(exception.getMessage());
        	throw exception;
        }
        
        return isValid;
    }

}
