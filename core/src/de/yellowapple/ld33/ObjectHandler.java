package de.yellowapple.ld33;

import java.util.ArrayList;
import de.yellowapple.ld33.objects.BasicGameObject;

public class ObjectHandler {

	private ArrayList<BasicGameObject> gameObjects;

	public ObjectHandler() {
		gameObjects = new ArrayList<BasicGameObject>();
	}

	public void addObject(BasicGameObject o) {
		gameObjects.add(o);
	}

	public void deleteObject(BasicGameObject o) {
		o.dispose();
		gameObjects.remove(gameObjects.indexOf(o));
	}

	public void updateObjects() {
		for (BasicGameObject o : gameObjects) {
			o.update();
		}
	}

	public void renderObjects() {
		for (BasicGameObject o : gameObjects) {
			o.render();
		}
	}

	public ArrayList<BasicGameObject> getObjects() {
		return gameObjects;
	}

	public ArrayList<BasicGameObject> getSpecificObjects(Class<?> c) {
		ArrayList<BasicGameObject> objects = new ArrayList<BasicGameObject>();
		for (int i = 0; i < gameObjects.size(); i++) {
			if (gameObjects.get(i).getClass().equals(c)) {
				objects.add(gameObjects.get(i));
			}
		}
		if (objects.isEmpty()) {
			objects = null;
		}
		return objects;
	}
}
