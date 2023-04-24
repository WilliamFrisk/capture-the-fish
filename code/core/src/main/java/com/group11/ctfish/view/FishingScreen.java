package com.group11.ctfish.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.fish.Fish;

import com.group11.ctfish.model.fish.FishFactory;
import com.group11.ctfish.model.fish.properties.Endangered;
import com.group11.ctfish.model.fish.sizes.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FishingScreen implements Screen {

    // Graphics

    private Texture background;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private FishRender fishRender;

    final CtFish game;

    OrthographicCamera camera;

    List<Fish> fishes = new ArrayList<>();

    private static final int TOTAL_FISHES = 15;
    private static final int TIME_DIFFERENCE = 250;
    Random rand = new Random();


    public FishingScreen(final CtFish game) {
        produce(TOTAL_FISHES);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        background = new Texture("background.jpg");
        batch = new SpriteBatch();
        fishRender = new FishRender(batch,shapeRenderer,camera);
    }

    //TODO fix this mess
    public void produce(int totalFishes){
        int time = 1280;
        int rotation = 0;

        while (rotation <= totalFishes) {
            rotation = rotation + 1;
            time = time + TIME_DIFFERENCE;
            Fish fish = FishFactory.createFish(
                    time,
                    rand.nextInt(281),
                    new Endangered(),
                    new Medium(),
                    "tuna.png");
            fishes.add(fish);
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background,0,0, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
        batch.end();
        fishRender.render(fishes);

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
