package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.behaviours.attacking.KnightAttack;

public class Knight extends Human {

	public Knight(float x, float y, int width, int height,
			SpriteBatch spritebatch, ShapeRenderer shaperenderer) {
		super(x, y, width, height, spritebatch, shaperenderer, new KnightAttack());
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
