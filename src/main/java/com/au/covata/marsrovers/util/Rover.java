package com.au.covata.marsrovers.util;

import java.util.List;

public class Rover {

	private int xPos;
	private int yPos;
	private RoverDirection heading;
	
	private List<StandardRoverCommand> sequenceOfCommands;
	
	public Rover(int xPos, int yPos, RoverDirection heading) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.heading = heading;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public RoverDirection getHeading() {
		return heading;
	}

	public void setHeading(RoverDirection heading) {
		this.heading = heading;
	}
	
	public void setHeadingLeft() {
		heading = heading.left();
	}

	public void setHeadingRight() {
		heading = heading.right();
	}

	public List<StandardRoverCommand> getSequenceOfCommands() {
		return sequenceOfCommands;
	}

	public void setSequenceOfCommands(List<StandardRoverCommand> sequenceOfCommands) {
		this.sequenceOfCommands = sequenceOfCommands;
	}

	
}
