package de.yellowapple.ld33;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector3;
import de.yellowapple.ld33.objects.Actor;
import de.yellowapple.ld33.objects.BasicGameObject;

public class InputHandler implements InputProcessor {

	private Vector3 mousePosition;
	private Actor controlledObject;

	public InputHandler() {
		mousePosition = new Vector3();
	}

	public BasicGameObject getControlledObject() {
		return controlledObject;
	}

	public void setControlledObject(Actor controlledObject) {
		this.controlledObject = controlledObject;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
			case 29 :
				controlledObject.setFlippedY(true);
				controlledObject.moveForward();
				break;
			case 32 :
				controlledObject.setFlippedY(false);
				controlledObject.moveForward();
				break;
			case 62 :
				controlledObject.jump();
				break;
			case 33:
				controlledObject.attack();
				break;
			default :
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if(!controlledObject.isJumping()){
			controlledObject.setVelocityX(0);
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		mousePosition.set(x, y, 0);
		// System.out.println("mouse down pos x: " + mousePosition.x + " - y: " + mousePosition.y);
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		mousePosition.set(x, y, 0);
		// System.out.println("mouse pos x: " + mousePosition.x + " - y: " + mousePosition.y);
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		mousePosition.set(x, y, 0);
		// System.out.println("mouse down pos x: " + mousePosition.x + " - y: " + mousePosition.y);
		return false;
	}

	@Override
	public boolean mouseMoved(int x, int y) {
		mousePosition.set(x, y, 0);
		// System.out.println("mouse pos x: " + mousePosition.x + " - y: " + mousePosition.y);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}