package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.Animator;
import de.yellowapple.ld33.behaviours.AttackBehaviour;
import de.yellowapple.ld33.behaviours.MovementBehaviour;

public class Hatchling extends Actor{

	private Texture walkSprite;
	private Texture cocoonSprite;
	private Animator walkAnimation;
	private Animator cocoonAnimation;
	
	public Hatchling(float x, float y, int width, int height,
			SpriteBatch spritebatch, ShapeRenderer shaperenderer,
			MovementBehaviour movement, AttackBehaviour attack) {
		super(x, y, width, height, spritebatch, shaperenderer, movement, attack);
		walkSprite = new Texture("sprites/small_spider_walking_sprite.png");
		cocoonSprite = new Texture("sprites/small_spider_cocoon_sprite.png");
		walkAnimation = new Animator(1, 2, walkSprite, 0.30f);
		cocoonAnimation = new Animator(1, 1, cocoonSprite, 0.00f);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		walkSprite.dispose();
		cocoonSprite.dispose();
	}
}
