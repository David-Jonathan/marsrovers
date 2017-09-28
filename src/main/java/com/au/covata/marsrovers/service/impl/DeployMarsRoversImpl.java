package com.au.covata.marsrovers.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.au.covata.marsrovers.exception.InvalidInputException;
import com.au.covata.marsrovers.exception.MarsRoverApplicationException;
import com.au.covata.marsrovers.service.IDeployMarsRovers;
import com.au.covata.marsrovers.util.MarsPlateau;
import com.au.covata.marsrovers.util.Rover;
import com.au.covata.marsrovers.util.RoverDirection;
import com.au.covata.marsrovers.util.StandardRoverCommand;

public class DeployMarsRoversImpl implements IDeployMarsRovers{

	private MarsPlateau marsPlateau;
	public MarsPlateau initMarsPlateau(int topRightX, int topRightY) throws InvalidInputException {
		
		this.marsPlateau = new MarsPlateau(topRightX, topRightY);
		
		return marsPlateau;
	}
	
    public List<Rover> initMarsRovers(String[] inputLines) throws MarsRoverApplicationException {

		List<Rover> rovers = new ArrayList<Rover>();

    	try {
    	
			for (int i = 1; i < inputLines.length; i+=2) {
				String[] inputTokens = inputLines[i].split(" ");
				Rover rover = new Rover(
						Integer.valueOf(inputTokens[0]),
						Integer.valueOf(inputTokens[1]),
						RoverDirection.valueOf(inputTokens[2].trim()));
				
				inputTokens = inputLines[i + 1].split("");
				
				
				List<StandardRoverCommand> commands = new ArrayList<StandardRoverCommand>(
						inputTokens.length);
				for (String inputToken : inputTokens) {
					if (inputToken.length() != 0) {
						if(inputToken.trim().length() > 0)
							commands.add(StandardRoverCommand.valueOf(inputToken.trim()));
					}
					rover.setSequenceOfCommands(commands);
				}
				rovers.add(rover);
			}

    	} catch(Exception e) {
    		throw new MarsRoverApplicationException("Following exception occurred : " + e.getMessage());
    	}
		return rovers;
    }
    
    public List<String> moveRovers(List<Rover> rovers)  throws MarsRoverApplicationException {
    	List<String> finalPositions = new ArrayList<String>(rovers.size());
    	
    	String finalPosition;
    	for(Rover rover : rovers) {
    		
    		for(StandardRoverCommand command : rover.getSequenceOfCommands()) {
    			command.execute(rover);
    		}
    		
    		finalPosition=new Integer(rover.getxPos()).toString() + " "
    				+new Integer(rover.getyPos()).toString() + " "
    					+rover.getHeading().name();
    		
    		finalPositions.add(finalPosition);
    		
    	}
    	return finalPositions;
    }
 
}