package de.yellowapple.ld33.behaviours.attacking;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.behaviours.AttackBehaviour;
import de.yellowapple.ld33.objects.Hatchling;

public class PlayerHatchlingAttack implements AttackBehaviour {

	SpriteBatch spritebatch;
	ShapeRenderer shaperenderer;
	ObjectHandler objectHandler;
	float x;
	float y;
	
	public PlayerHatchlingAttack(float x, float y, 
			SpriteBatch spritebatch, ShapeRenderer shaperenderer, 
			ObjectHandler objectHandler) {
		this.spritebatch = spritebatch;
		this.shaperenderer = shaperenderer;
		this.objectHandler = objectHandler;
		this.x = x;
		this.y = y;
	}

	@Override
	public void attack() {
		objectHandler.addObject(new Hatchling(x, y, spritebatch, shaperenderer, objectHandler));
	}
}
