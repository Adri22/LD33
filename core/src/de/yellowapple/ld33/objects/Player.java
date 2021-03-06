package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.Animator;
import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.behaviours.attacking.PlayerHatchlingAttack;
import de.yellowapple.ld33.behaviours.movements.PlayerMovement;
import de.yellowapple.ld33.screens.GameScreen;

public class Player extends Actor {

	private int hp;
	private Texture idleSprite;
	private Texture walkSprite;
	private Texture jumpSprite;
	// private Texture attackSprite;
	private Animator idleAnimation;
	private Animator walkAnimation;
	private Animator jumpAnimation;
	// private Animator attackAnimation;

	public Player(float x, float y, SpriteBatch spritebatch, ShapeRenderer shaperenderer, ObjectHandler objectHandler) {
		super(x, y, 100, 100, 
				spritebatch, 
				shaperenderer, 
				objectHandler, 
				new PlayerMovement(), 
				new PlayerHatchlingAttack(x, y, spritebatch, shaperenderer, objectHandler));
		idleSprite = new Texture("sprites/player_spider_idle_sprite.png");
		walkSprite = new Texture("sprites/player_spider_walking_sprite.png");
		jumpSprite = new Texture("sprites/player_spider_jumping_sprite.png");
		idleAnimation = new Animator(1, 3, idleSprite, 0.80f);
		walkAnimation = new Animator(1, 3, walkSprite, 0.80f);
		jumpAnimation = new Animator(1, 1, jumpSprite, 0.80f);
		currentAnimation = idleAnimation;
		hp = 100;
	}

	@Override
	public void update(){
		super.update();
		
		posX += velocityX;
		posY += velocityY;

		if(velocityX != 0.0f){
			currentAnimation = walkAnimation;
		} else {
			currentAnimation = idleAnimation;
		}
		
		if (isJumping) {
			currentAnimation = jumpAnimation;
			velocityY -= GameScreen.WORLD_GRAVITY;
		}
		
		if(collision){
			currentAnimation = idleAnimation;
		}
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	@Override
	public void dispose() {
		idleSprite.dispose();
		walkSprite.dispose();
		jumpSprite.dispose();
		// dispose attack-sprite
	}
}
