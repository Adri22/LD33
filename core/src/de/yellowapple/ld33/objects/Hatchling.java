package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.Animator;
import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.behaviours.AttackBehaviour;
import de.yellowapple.ld33.behaviours.MovementBehaviour;
import de.yellowapple.ld33.behaviours.attacking.HatchlingAttack;
import de.yellowapple.ld33.behaviours.movements.HatchlingMovement;

public class Hatchling extends Actor{

	private Texture walkSprite;
	private Texture cocoonSprite;
	private Animator walkAnimation;
	private Animator cocoonAnimation;
	
	public Hatchling(float x, float y, SpriteBatch spritebatch, ShapeRenderer shaperenderer, ObjectHandler objectHandler) {
		super(x, y, 20, 20, spritebatch, shaperenderer, objectHandler, new HatchlingMovement(), new HatchlingAttack());
		walkSprite = new Texture("sprites/small_spider_walking_sprite.png");
		cocoonSprite = new Texture("sprites/small_spider_cocoon_sprite.png");
		walkAnimation = new Animator(1, 2, walkSprite, 0.30f);
		cocoonAnimation = new Animator(1, 1, cocoonSprite, 0.00f);
		currentAnimation = walkAnimation;
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void dispose() {
		walkSprite.dispose();
		cocoonSprite.dispose();
	}
}
