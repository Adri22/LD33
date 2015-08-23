package de.yellowapple.ld33.objects;

import java.util.ArrayList;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.Animator;
import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.behaviours.AttackBehaviour;
import de.yellowapple.ld33.behaviours.MovementBehaviour;
import de.yellowapple.ld33.objects.levelbuilding.BasicBlock;

public abstract class Actor extends BasicGameObject {

	protected ObjectHandler objectHandler;
	protected float velocityX;
	protected float velocityY;
	protected boolean isJumping;
	protected boolean collision;
	protected boolean flippedY;
	protected Animator currentAnimation;
	protected MovementBehaviour movements;
	protected AttackBehaviour attack;

	public Actor(float x, float y, int width, int height,
			SpriteBatch spritebatch, 
			ShapeRenderer shaperenderer,
			ObjectHandler objectHandler, 
			MovementBehaviour movement,
			AttackBehaviour attack) {
		super(x, y, width, height, spritebatch, shaperenderer);
		this.objectHandler = objectHandler;
		velocityX = 0;
		velocityY = 0;
		isJumping = false;
		collision = false;
		flippedY = false;
		this.movements = movement;
		this.attack = attack;
		currentAnimation = null;
	}

	public void update() {
		collision();
	}

	public void render() {
		if (currentAnimation != null) {
			spritebatch.draw(currentAnimation.getTextureRegion().getTexture(),
					posX, posY, width, height,
					currentAnimation.getTextureRegion().getRegionX(),
					currentAnimation.getTextureRegion().getRegionY(),
					currentAnimation.getTextureRegion().getRegionWidth(),
					currentAnimation.getTextureRegion().getRegionHeight(),
					flippedY, false);
		}
	}

	public float getVelocityX() {
		return velocityX;
	}

	public void setVelocityX(float velocityX) {
		this.velocityX = velocityX;
	}

	public float getVelocityY() {
		return velocityY;
	}

	public void setVelocityY(float velocityY) {
		this.velocityY = velocityY;
	}

	public boolean isJumping() {
		return isJumping;
	}

	public void moveForward() {
		velocityX = movements.moveForward(flippedY);
	}

	public void jump() {
		if (!isJumping) {
			velocityY = movements.jump();
			isJumping = true;
		}
	}

	public void attack() {
		attack.attack();
	}

	public boolean isFlippedY() {
		return flippedY;
	}

	public void setFlippedY(boolean flippedY) {
		this.flippedY = flippedY;
	}

	private void collision() {
		ArrayList<BasicGameObject> objects = objectHandler.getSpecificObjects(BasicBlock.class);
		for (int i = 0; i < objects.size(); i++) {

			if (getBoundsTop().overlaps(objects.get(i).getBounds())) {
				posY = objects.get(i).getPosY() + objects.get(i).getHeight();
				velocityY = 0;
				collision = true;
			} else {
				collision = false;
			}

			if (getBounds().overlaps(objects.get(i).getBounds())) {
				posY = objects.get(i).getPosY() - height;
				velocityY = 0;
				isJumping = false;
				collision = true;
			} else {
				isJumping = true;
				collision = false;
			}

			if (getBoundsLeft().overlaps(objects.get(i).getBounds())) {
				posX = objects.get(i).getPosX() + objects.get(i).getWidth();
				collision = true;
			} else {
				collision = false;
			}

			if (getBoundsRight().overlaps(objects.get(i).getBounds())) {
				posX = objects.get(i).getPosX() - width;
				collision = true;
			} else {
				collision = false;
			}
		}
	}
}
