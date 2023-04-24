package com.group11.ctfish;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.view.QuestionScreen;
import com.group11.ctfish.view.FishingScreen;
import com.group11.ctfish.view.FrontScreen;


import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class CtFish extends Game {

	SpriteBatch batch;
	Texture img;
	public ShapeRenderer shape;

	public static final int SCREEN_WIDTH = 1280;
	public static final int SCREEN_HEIGHT = 720;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		this.setScreen(new FishingScreen(this));
		shape = new ShapeRenderer();
	}

	@Override
	public void render () {
		super.render();
	}

	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	public Skin getSkin() {
		return new Skin(Gdx.files.internal("skin/button.json"));
	}
}
