package com.au.covata.marsrovers.validation;

import com.au.covata.marsrovers.util.MarsPlateau;

public class MoveValidator implements Validator {

    private int xCoordinate;
    private int yCoordinate;
    private MarsPlateau plateau;
    /*
    The constructor is used for initialising the MoveValidator along with coordinates and plateau.

    @param  xCoordinate to be validated
    @param  yCoordinate to be validated
    @param plateau
    @return
    */
    public MoveValidator(int xCoordinate, int yCoordinate, MarsPlateau plateau) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.plateau = plateau;
    }

    /*
    Validation method that checks if the new coordinates fit into the defined
    Plateau and an Exception is thrown if the coordinates are beyond.

    @param
    @return
     */
    @Override
    public void validate() throws Exception {
        if(!plateau.isValidPositionInPlateau(xCoordinate, yCoordinate)) {
            throw new Exception("The current position violates the defined Plateau.");
        }
    }


}
