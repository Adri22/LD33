package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.behaviours.AttackBehaviour;
import de.yellowapple.ld33.behaviours.MovementBehaviour;

public abstract class Enemy extends Actor {

	public Enemy(float x, float y, int width, int height,
			SpriteBatch spritebatch, ShapeRenderer shaperenderer,
			MovementBehaviour movement, AttackBehaviour attack) {
		super(x, y, width, height, spritebatch, shaperenderer, movement, attack);
	}
}
