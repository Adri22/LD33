package de.yellowapple.ld33.objects.levelbuilding;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class BasicBlock extends LevelBuildingElement{

	public BasicBlock(float x, float y, SpriteBatch spritebatch, ShapeRenderer shaperenderer) {
		super(x, y, spritebatch, shaperenderer, new Texture("sprites/basicblock_texture.png"));
	}

	@Override
	public void update() {
	}
}
