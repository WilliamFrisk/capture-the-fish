package com.group11.ctfish;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("capture-the-fish");
		config.setWindowedMode(CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
		config.useVsync(true);
		new Lwjgl3Application(new CtFish(), config);
	}
}
