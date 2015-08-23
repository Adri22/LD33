package de.yellowapple.ld33;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {
	private Animation animation;
	private Texture sheet;
	private TextureRegion[] frames;
	private TextureRegion currentRegion;
	private float stateTime;
	private int rows;
	private int cols;

	public Animator(int frameRows, int frameCols, Texture t,
			float animationSpeed) {
		rows = frameRows;
		cols = frameCols;
		sheet = t;
		TextureRegion[][] tmp = TextureRegion.split(sheet,
				sheet.getWidth() / cols, sheet.getHeight() / rows);
		frames = new TextureRegion[rows * cols];
		int index = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				frames[index++] = tmp[i][j];
			}
		}
		animation = new Animation(animationSpeed, frames);
		stateTime = 0f;
	}

	public TextureRegion getTextureRegion() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		currentRegion = animation.getKeyFrame(stateTime, true);
		return currentRegion;
	}

	public void setAnimationSpeed(float speed) {
		animation.setFrameDuration(speed);
	}

	public int getRows() {
		return rows;
	}

	public int getCols() {
		return cols;
	}
}
