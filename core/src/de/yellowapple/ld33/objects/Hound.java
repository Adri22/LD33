package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.behaviours.attacking.HoundAttack;
import de.yellowapple.ld33.behaviours.movements.HoundMovement;

public class Hound extends Enemy {

	public Hound(float x, float y, SpriteBatch spritebatch, ShapeRenderer shaperenderer, ObjectHandler objectHandler) {
		super(x, y, 30, 30, spritebatch, shaperenderer, objectHandler,
				new HoundMovement(), new HoundAttack());

		
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
