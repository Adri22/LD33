package de.yellowapple.ld33.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import de.yellowapple.ld33.LD33Main;

public class DesktopLauncher {
	public static void main(String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "LD33";
		config.width = LD33Main.resolutionWidth;
		config.height = LD33Main.resolutionHeight;
		config.resizable = false;

		new LwjglApplication(new LD33Main(), config);
	}
}
