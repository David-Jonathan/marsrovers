package com.au.covata.marsrovers.service.implementation;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.au.covata.marsrovers.exception.InvalidInputException;
import com.au.covata.marsrovers.exception.MarsRoverApplicationException;
import com.au.covata.marsrovers.service.impl.DeployMarsRoversImpl;
import com.au.covata.marsrovers.util.MarsPlateau;
import com.au.covata.marsrovers.util.Rover;
import com.au.covata.marsrovers.util.RoverDirection;
import com.au.covata.marsrovers.util.StandardRoverCommand;

public class DeployMarsRoversImplTest {
	
	private List<Rover> roversList;
	private List<String> finalPositions;

	@Test
	public void testCreatePlateau() throws InvalidInputException {
		DeployMarsRoversImpl mockDeployMarsRovers= mock(DeployMarsRoversImpl.class);
		DeployMarsRoversImpl deployMarsRoversImpl = new DeployMarsRoversImpl();
		MarsPlateau plateau = deployMarsRoversImpl.initMarsPlateau(5, 5);
		
		Assert.assertTrue(plateau.isValidPositionInPlateau(3, 3));
		
		when(mockDeployMarsRovers.initMarsPlateau(0, 5)).thenThrow(new InvalidInputException("Wrong Input"));
	}

	@Test
	public void testInitRovers() throws InvalidInputException, MarsRoverApplicationException, IOException {
		DeployMarsRoversImpl deployMarsRoversImpl = new DeployMarsRoversImpl();
		String content = new String(Files.readAllBytes(Paths.get("input.txt")));
		String[] inputLines = content.split("\n");
		roversList = deployMarsRoversImpl.initMarsRovers(inputLines);
		
		finalPositions = deployMarsRoversImpl.moveRovers(roversList);
		
		Assert.assertEquals("1 3 N", finalPositions.get(0));
		Assert.assertEquals("5 1 E", finalPositions.get(1));
		
		
	}
	
	@Test
	public void testMoveRovers() throws InvalidInputException, MarsRoverApplicationException, IOException {
		DeployMarsRoversImpl deployMarsRoversImpl = new DeployMarsRoversImpl();
		
		Rover marsRover = new Rover(4,4,RoverDirection.E);
		StandardRoverCommand command =  StandardRoverCommand.L;
		List<StandardRoverCommand> commands = new ArrayList<StandardRoverCommand>();
		commands.add(command);
		marsRover.setSequenceOfCommands(commands);
		List<Rover> roversList = new ArrayList<Rover>();
		roversList.add(marsRover);
		finalPositions = deployMarsRoversImpl.moveRovers(roversList);
	}

}
