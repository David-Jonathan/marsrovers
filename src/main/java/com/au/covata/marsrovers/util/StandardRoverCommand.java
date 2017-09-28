package com.au.covata.marsrovers.util;

public enum StandardRoverCommand {

	L,
	R,
	M;

	public void execute(Rover rover) {
		switch (this) {
		case L:
			rover.setHeadingLeft();
			break;
		case R:
			rover.setHeadingRight();
			break;
		case M:
			switch (rover.getHeading()) {
			case N:
				rover.setyPos(rover.getyPos() + 1);
				break;
			case E:
				rover.setxPos(rover.getxPos() + 1);
				break;
			case W:
				rover.setxPos(rover.getxPos() - 1);
				break;
			case S:
				rover.setyPos(rover.getyPos() - 1);
				break;
			}
			break;
		}
	}
}