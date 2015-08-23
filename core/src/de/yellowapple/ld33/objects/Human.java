package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.behaviours.AttackBehaviour;
import de.yellowapple.ld33.behaviours.movements.HumanMovement;

public abstract class Human extends Enemy {

	public Human(float x, float y, int width, int height,
			SpriteBatch spritebatch, ShapeRenderer shaperenderer, ObjectHandler objectHandler, AttackBehaviour attack) {
		super(x, y, width, height, spritebatch, shaperenderer, objectHandler,
				new HumanMovement(), attack);
	}
}
