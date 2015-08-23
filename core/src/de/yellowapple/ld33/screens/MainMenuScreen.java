package de.yellowapple.ld33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import de.yellowapple.ld33.LD33Main;

public class MainMenuScreen implements Screen {

	private LD33Main game;
	private OrthographicCamera camera;

	public MainMenuScreen(LD33Main g) {
		game = g;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, game.resolutionWidth, game.resolutionHeight);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		game.spritebatch.setProjectionMatrix(camera.combined);
		game.spritebatch.begin();

		// render here

		game.spritebatch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen(game));
			dispose();
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		// dispose stuff here
	}
}
