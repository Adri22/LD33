package de.yellowapple.ld33.objects.levelbuilding;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.objects.BasicGameObject;

public class LevelBuildingElement extends BasicGameObject{

	public static float levelElementWidth;
	public static float levelElementHeight;
	Texture tex;
	
	public LevelBuildingElement(float x, float y, SpriteBatch spritebatch, ShapeRenderer shaperenderer, Texture tex) {
		super(x, y, 50, 50, spritebatch, shaperenderer);
		this.tex = tex;
		levelElementWidth = width;
		levelElementHeight = height;
	}

	@Override
	public void update() {
	}

	@Override
	public void render() {
		spritebatch.draw(tex, posX, posY, width, height);
	}

	@Override
	public void dispose() {
		tex.dispose();
	}
}
