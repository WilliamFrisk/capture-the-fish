package com.group11.ctfish;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.group11.ctfish.view.FrontScreen;

public class CtFish extends Game {

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;


	
	@Override
	public void create () {
		this.setScreen(new FrontScreen(this));
	}

	public Skin getSkin() {
		return new Skin(Gdx.files.internal("skin/button.json"));
	}

	@Override
	public void render () {
		super.render();
	}

	
	@Override
	public void dispose () {
	}

}
