package de.yellowapple.ld33.behaviours.movements;

import de.yellowapple.ld33.behaviours.MovementBehaviour;

public class HoundMovement implements MovementBehaviour {

	@Override
	public float moveForward(boolean flippedY) {
		float velocityX = 6.0f;
		if (flippedY) {
			velocityX = -(velocityX);
		}
		return velocityX;
	}

	@Override
	public float jump() {
		return 2;
	}
}
