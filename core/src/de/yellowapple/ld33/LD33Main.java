package de.yellowapple.ld33;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import de.yellowapple.ld33.screens.MainMenuScreen;

public class LD33Main extends Game {

	public static int resolutionWidth = 1024;
	public static int resolutionHeight = 768;
	public static float version = 1.0f;
	public SpriteBatch spritebatch;
	public BitmapFont bitmapfont;
	public ShapeRenderer shaperenderer;

	@Override
	public void create() {
		spritebatch = new SpriteBatch();
		bitmapfont = new BitmapFont();
		shaperenderer = new ShapeRenderer();
		this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void dispose() {
		spritebatch.dispose();
		bitmapfont.dispose();
		shaperenderer.dispose();
	}
}
