package com.group11.ctfish.view;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.controller.HookController;
import com.group11.ctfish.model.Hook;
import com.group11.ctfish.model.fish.Fish;

import com.group11.ctfish.model.fish.FishFactory;

import com.group11.ctfish.model.fish.properties.Endangered;
import com.group11.ctfish.model.fish.sizes.Medium;
import com.group11.ctfish.view.QuestionScreen;

import com.group11.ctfish.model.fish.properties.Collectable;
import com.group11.ctfish.model.fish.sizes.Sizes;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FishingScreen implements Screen {

    // Graphics

    private Texture background;

    private Texture texture1 = new Texture("fish/redoctopus/redoctopus4.png");
    private Texture hookImage;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private FishRender fishRender;

    final CtFish game;


    OrthographicCamera camera;

    List<Fish> fishes = new ArrayList<>();

    private static final int TOTAL_FISHES = 15;
    private static final int TIME_DIFFERENCE = 250;
    Random rand = new Random();
    Hook hook = new Hook();
    HookController hookController = new HookController(hook);



    public FishingScreen(final CtFish game) {
        produce(TOTAL_FISHES);
        Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3"));

        // start the playback of the background music immediately
        rainMusic.setLooping(true);
        rainMusic.play();

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
                    new Collectable(),
                    Sizes.LARGE, texture1);
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
        hookRender();
        batch.end();
        fishRender.render(fishes);
    }


        //PLACEHOLDER-KOD FÖR ATT BYTA TILL QUIZSCREEN
        if(Gdx.input.isKeyPressed(Input.Keys.Q)){
            try {
                game.setScreen(new QuestionScreen(game, this));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    private void hookRender() {
        hookController.update();
        hookImage = new Texture(Gdx.files.internal(hook.getTexture()) + ".png");
        batch.draw(hookImage, hook.getHook().x, hook.getHook().y);
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
