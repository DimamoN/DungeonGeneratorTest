package com.dimamon.playingground.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.dimamon.playingground.Application;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Application.WIDTH;
		config.height = Application.HEIGHT;
		config.title = Application.TITLE + " " + Application.VERSION;
		new LwjglApplication(new Application(), config);
	}
}
