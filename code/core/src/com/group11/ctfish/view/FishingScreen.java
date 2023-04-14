package com.group11.ctfish.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.Fish;

import javax.swing.*;


public class FishingScreen implements Screen {

    // Graphics

    private Texture background;
    private SpriteBatch batch;

    // Timing

    private int backgroundOffset;

    final CtFish game;

    OrthographicCamera camera;
    Fish[] fishes = {new Fish(0, 10), new Fish(-400, 50), new Fish(-800, 100)};

    public FishingScreen(final CtFish game) {

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.game = game;

        background = new Texture("backgroundfishing.jpg");
        backgroundOffset = 0;

        batch = new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background,0,0, 720, 480);
        batch.end();
        for (Fish fish : fishes) {
            fish.move();
            game.shape.setProjectionMatrix(camera.combined);
            game.shape.begin(ShapeRenderer.ShapeType.Line);
            batch.begin();
            batch.draw(fish.getTexture(), fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());
            batch.end();
            game.shape.end();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
