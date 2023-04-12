package com.group11.ctfish.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.Fish;

public class FishingScreen implements Screen {
    final CtFish game;

    OrthographicCamera camera;
    Fish[] fishes = {new Fish(0, 10), new Fish(5, 50), new Fish(-3, 100)};

    public FishingScreen(final CtFish game) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.BLACK);
        for (Fish fish : fishes) {
            fish.move();
            game.shape.setProjectionMatrix(camera.combined);
            game.shape.begin(ShapeRenderer.ShapeType.Line);
            game.shape.setColor(Color.BLUE);
            game.shape.rect(fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());
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
