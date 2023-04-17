package com.group11.ctfish.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.fish.Fish;

import com.group11.ctfish.model.fish.FishFactory;
import com.group11.ctfish.model.fish.properties.Collectable;
import com.group11.ctfish.model.fish.properties.Endangered;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;
import com.group11.ctfish.model.fish.sizes.Large;
import com.group11.ctfish.model.fish.sizes.Medium;
import com.group11.ctfish.model.fish.sizes.Small;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FishingScreen implements Screen {

    // Graphics

    private Texture background;
    private SpriteBatch batch;

    // Timing

    private int backgroundOffset;

    final CtFish game;


    OrthographicCamera camera;
    FishProperty endangered = new Endangered();
    FishProperty collectable = new Collectable();
    FishSize large = new Large();
    FishSize medium = new Medium();
    FishSize small = new Small();


    List<Fish> fishes = new ArrayList<>();
    //Fish[] fishes = {fish1,fish2,fish3};

    private int totalFishes = 15;
    private int timeDiffrens = -250;
    private int rotation = 0;
    Random rand = new Random();






    public FishingScreen(final CtFish game) {
        produce(totalFishes,timeDiffrens);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.game = game;
        background = new Texture("backgroundfishing.jpg");
        backgroundOffset = 0;
        batch = new SpriteBatch();
    }


    public void produce(int totalFishes, int timeDiffrens){
        int time = 0;
        rotation = 0;
        while (rotation <= totalFishes){
            rotation = rotation + 1;
            time = time + timeDiffrens;
            Fish fish = FishFactory.createFish(time,rand.nextInt(280 - 0 + 1) + 0, endangered, medium, "tuna.png");
            fishes.add(fish);
        }
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
