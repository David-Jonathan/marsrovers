package com.au.covata.marsrovers.util;

public class MarsPlateau {

	private int topRightXCoordinate;
	private int topRightYCoordinate;
	
    public MarsPlateau(final int topRightXCoordinate, final int topRightYCoordinate) {
    	this.topRightXCoordinate = topRightXCoordinate;
    	this.topRightYCoordinate = topRightYCoordinate;
    }
    
    public boolean isValidPositionInPlateau(int newXPosition, int newYPosition) {
    	
    	boolean isValidPosition = false;
    	
    	if(newXPosition <= this.topRightXCoordinate && 
    			newYPosition <= this.topRightYCoordinate) {
    		isValidPosition = true;
    	}
    	
    	return isValidPosition;
    	
    }

}