package com.group11.ctfish.view;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.controller.HookController;

import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.Hook;
import com.group11.ctfish.model.fish.Fish;

import com.group11.ctfish.model.fish.FishFactory;


import com.group11.ctfish.model.fish.properties.Collectable;
import com.group11.ctfish.model.fish.sizes.Sizes;


import com.group11.ctfish.model.fish.properties.Endangered;
import com.group11.ctfish.model.fish.sizes.Medium;
import com.group11.ctfish.model.user.User;
import com.group11.ctfish.view.QuestionScreen;


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

    private UserRender lifeRenderer;

    final CtFish game;
    ModelFacade facade = ModelFacade.getInstance();


    OrthographicCamera camera;

    HookController hookController = new HookController(facade.getHookObject());

    User user = new User("");



    public FishingScreen(final CtFish game) {
        Music rainMusic = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3"));

        // start the playback of the background music immediately
        rainMusic.setLooping(true);
        //rainMusic.play();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        background = new Texture("background.jpg");
        batch = new SpriteBatch();
        fishRender = new FishRender(batch,shapeRenderer,camera);
        lifeRenderer = new UserRender();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();

        batch.draw(background,0,0, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
        int posX = 50;
        for (int i = 0; i <= user.getLives(); i++){
            batch.draw(new Texture("heart.png"), posX,630,lifeRenderer.getWidth(),lifeRenderer.getHeight());
            posX+=70;
        }
        hookRender();
        fishRender.render(facade.getFishList());
        facade.CollisionUpdate();

        batch.end();

        //PLACEHOLDER-KOD FÖR ATT BYTA TILL QUIZSCREEN
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            try {
                game.setScreen(new QuestionScreen(game, this));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    private void hookRender() {
        hookController.update();
        hookImage = new TextureRegion(new Texture(Gdx.files.internal(facade.getHookObject().getTexture()) + ".png")).getTexture();
        batch.draw(hookImage, facade.getHookObject().getHook().x, facade.getHookObject().getHook().y);
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
