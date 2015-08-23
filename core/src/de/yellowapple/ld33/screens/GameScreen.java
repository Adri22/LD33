package de.yellowapple.ld33.screens;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

import de.yellowapple.ld33.BufferedImageLoader;
import de.yellowapple.ld33.InputHandler;
import de.yellowapple.ld33.LD33Main;
import de.yellowapple.ld33.ObjectHandler;
import de.yellowapple.ld33.objects.Actor;
import de.yellowapple.ld33.objects.BasicGameObject;
import de.yellowapple.ld33.objects.Hound;
import de.yellowapple.ld33.objects.Knight;
import de.yellowapple.ld33.objects.Player;
import de.yellowapple.ld33.objects.levelbuilding.BasicBlock;
import de.yellowapple.ld33.objects.levelbuilding.LevelBuildingElement;

public class GameScreen implements Screen {

	private LD33Main game;
	private OrthographicCamera camera;
	private ObjectHandler objectHandler;
	private InputHandler input;
	private BufferedImage level = null;
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
		initGameWorld();
	}

	private void initGameWorld() {
		BufferedImageLoader imgLoader = new BufferedImageLoader();
		level = imgLoader.loadImage("/images/levels/level_1.png");
		loadImgLevel(level);
	}

	private void renderGame() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		ArrayList<BasicGameObject> playerObjects = objectHandler.getSpecificObjects(Player.class);
		for (int i = 0; i < playerObjects.size(); i++) {
			Vector3 posTemp = new Vector3(playerObjects.get(i).getPosX(), (LD33Main.resolutionHeight / 2), 0.0f);
			camera.position.set(posTemp.x, posTemp.y, 0.0f);
		}
		camera.update();

		game.spritebatch.setProjectionMatrix(camera.combined);
		game.spritebatch.begin();

		objectHandler.renderObjects();

		game.bitmapfont.draw(game.spritebatch,
				"FPS:" + (1 / Gdx.graphics.getDeltaTime()),
				(5 - (camera.viewportWidth / 2)) + camera.position.x,
				game.resolutionHeight - 5);

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

	private void loadImgLevel(BufferedImage img) {
		int w = img.getWidth();
		int h = img.getHeight();

		for (int stepX = 0; stepX < w; stepX++) {
			for (int stepY = 0; stepY < h; stepY++) {

				int pixel = img.getRGB(stepX, stepY);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;

				// black => basic-level-element
				if (red == 0 && green == 0 && blue == 0) {
					BasicGameObject element = new BasicBlock(stepX, stepY,
							game.spritebatch, game.shaperenderer);
					objectHandler.addObject(element);
				}

				// blue => player startposition
				if (red == 0 && green == 0 && blue == 255) {
					BasicGameObject player = new Player(stepX, stepY,
							game.spritebatch, game.shaperenderer,
							objectHandler);
					objectHandler.addObject(player);
					input.setControlledObject((Actor) player);
				}

				// green => knight startposition
				if (red == 0 && green == 255 && blue == 0) {
					objectHandler.addObject(
							new Knight(stepX, stepY, game.spritebatch,
									game.shaperenderer, objectHandler));
				}

				// red => hound startposition
				if (red == 255 && green == 0 && blue == 0) {
					objectHandler
							.addObject(new Hound(stepX, stepY, game.spritebatch,
									game.shaperenderer, objectHandler));
				}
			}
		}
	}
}
