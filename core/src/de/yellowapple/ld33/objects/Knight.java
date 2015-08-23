package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.behaviours.attacking.KnightAttack;

public class Knight extends Human {

	public Knight(float x, float y, SpriteBatch spritebatch, ShapeRenderer shaperenderer, ObjectHandler objectHandler) {
		super(x, y, 50, 50, 
				spritebatch, 
				shaperenderer, 
				objectHandler, 
				new KnightAttack());
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void dispose() {
	}
}
