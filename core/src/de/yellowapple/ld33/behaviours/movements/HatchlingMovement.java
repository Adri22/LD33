package de.yellowapple.ld33.behaviours.movements;

import de.yellowapple.ld33.behaviours.MovementBehaviour;

public class HatchlingMovement implements MovementBehaviour{

	@Override
	public float moveForward(boolean flippedY) {
		float velocityX = 15.0f;
		if (flippedY) {
			velocityX = -(velocityX);
		}
		return velocityX;
	}

	@Override
	public float jump() {
		return 5;
	}

}
