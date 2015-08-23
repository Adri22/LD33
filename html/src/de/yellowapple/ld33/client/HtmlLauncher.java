package de.yellowapple.ld33.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import de.yellowapple.ld33.LD33Main;

public class HtmlLauncher extends GwtApplication {

	int width = LD33Main.resolutionWidth;
	int height = LD33Main.resolutionHeight;

	@Override
	public GwtApplicationConfiguration getConfig() {
		return new GwtApplicationConfiguration(width, height);
	}

	@Override
	public ApplicationListener getApplicationListener() {
		return new LD33Main();
	}
}