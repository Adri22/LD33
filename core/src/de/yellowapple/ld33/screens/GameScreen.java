package de.yellowapple.ld33.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import de.yellowapple.ld33.InputHandler;
import de.yellowapple.ld33.LD33Main;
import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.objects.Actor;
import de.yellowapple.ld33.objects.BasicGameObject;
import de.yellowapple.ld33.objects.Player;

public class GameScreen implements Screen {

	private LD33Main game;
	private OrthographicCamera camera;
	private ObjectHandler objectHandler;
	private InputHandler input;
	private float timer;
	public static final float WORLD_GRAVITY = 0.3f;

	public GameScreen(LD33Main g) {
		game = g;
		camera = new OrthographicCamera();
		camera.setToOrtho(false, game.resolutionWidth, game.resolutionHeight);
		objectHandler = new ObjectHandler();
		input = new InputHandler();
		Gdx.input.setInputProcessor(input);
		timer = 0;
		initGameObjects();
	}

	private void initGameObjects() {
		BasicGameObject player = new Player(0, 0, 100, 100, game.spritebatch,
				game.shaperenderer);
		objectHandler.addObject(player);
		input.setControlledObject((Actor) player);
	}

	private void renderGame() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		game.spritebatch.setProjectionMatrix(camera.combined);
		game.spritebatch.begin();

		game.bitmapfont.draw(game.spritebatch,
				"FPS:" + (1 / Gdx.graphics.getDeltaTime()), 5,
				game.resolutionHeight - 5);

		objectHandler.renderObjects();

		game.spritebatch.end();
	}

	private void updateGame() {
		timer += Gdx.graphics.getDeltaTime();
		objectHandler.updateObjects();
	}

	@Override
	public void render(float delta) {
		updateGame();
		renderGame();
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
