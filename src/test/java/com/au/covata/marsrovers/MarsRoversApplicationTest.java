package com.au.covata.marsrovers;

import com.au.covata.marsrovers.exception.InvalidInputException;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class MarsRoversApplicationTest 
    extends TestCase
{
	public void testMoveRoversApplication() {
		MarsRoversApplication.main(null);
	}
	
	public void testValidateMethod() throws InvalidInputException {
		MarsRoversApplication.validate("5","5");
	}
}
