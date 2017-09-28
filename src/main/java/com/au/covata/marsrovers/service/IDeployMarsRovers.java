package com.au.covata.marsrovers.service;

import java.util.List;

import com.au.covata.marsrovers.exception.InvalidInputException;
import com.au.covata.marsrovers.exception.MarsRoverApplicationException;
import com.au.covata.marsrovers.util.MarsPlateau;
import com.au.covata.marsrovers.util.Rover;

public interface IDeployMarsRovers {
	
	public MarsPlateau initMarsPlateau(int topRightX, int topRightY) throws InvalidInputException;
	public List<Rover> initMarsRovers(String[] inputLines)  throws MarsRoverApplicationException ;
	public List<String> moveRovers(List<Rover> rovers)  throws MarsRoverApplicationException;
	

}
