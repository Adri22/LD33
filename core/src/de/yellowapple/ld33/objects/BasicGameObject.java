package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class BasicGameObject {

	protected SpriteBatch spritebatch;
	protected ShapeRenderer shaperenderer;
	protected float posX;
	protected float posY;
	protected float width;
	protected float height;

	public BasicGameObject(float x, float y, int width, int height,
			SpriteBatch spritebatch, ShapeRenderer shaperenderer) {
		this.posX = x;
		this.posY = y;
		this.width = width;
		this.height = height;
		this.spritebatch = spritebatch;
		this.shaperenderer = shaperenderer;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getPosX() {
		return posX;
	}

	public void setPosX(float posX) {
		this.posX = posX;
	}

	public float getPosY() {
		return posY;
	}

	public void setPosY(float posY) {
		this.posY = posY;
	}

	public abstract void update();

	public abstract void render();

	public abstract void dispose();
}
