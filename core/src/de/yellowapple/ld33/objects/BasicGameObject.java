package de.yellowapple.ld33.objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.objects.levelbuilding.LevelBuildingElement;

public abstract class BasicGameObject {

	protected SpriteBatch spritebatch;
	protected ShapeRenderer shaperenderer;
	protected float posX;
	protected float posY;
	protected float width;
	protected float height;

	public BasicGameObject(float x, float y, int width, int height,
			SpriteBatch spritebatch, ShapeRenderer shaperenderer) {
		this.posX = x * LevelBuildingElement.levelElementWidth;
		this.posY = y * LevelBuildingElement.levelElementHeight;
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

	public Vector3 getPos() {
		return new Vector3(posX, posY, 0.0f);
	}

	public Rectangle getBounds() {
		return new Rectangle((int) posX, (int) posY, (int) width, (int) height);
	}

	public abstract void update();

	public abstract void render();

	public abstract void dispose();
}
