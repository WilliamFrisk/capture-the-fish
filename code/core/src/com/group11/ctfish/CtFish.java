package com.group11.ctfish;

import com.badlogic.gdx.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.view.FishingScreen;

public class CtFish extends Game {
	SpriteBatch batch;
	Texture img;
	public ShapeRenderer shape;

	
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
}
