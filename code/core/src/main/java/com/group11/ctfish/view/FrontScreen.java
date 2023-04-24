package com.group11.ctfish.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.group11.ctfish.CtFish;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.group11.ctfish.model.ModelFacade;

public class FrontScreen implements Screen {
    private final CtFish game;
    private Stage stage;
    private TextField usernameField;


    ModelFacade facade = ModelFacade.getInstance();


    public FrontScreen(final CtFish game) {
        this.game = game;
        this.stage = new Stage();

        // Create username input field
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        usernameField = new TextField("", skin);
        usernameField.setMessageText("Enter your username");
        usernameField.setPosition(Gdx.graphics.getWidth() / 2 - usernameField.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        stage.addActor(usernameField);

        // Create play button
        TextButton playButton = new TextButton("Play", skin, "default");
        playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 50);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String username = usernameField.getText();
                facade.createUser(username);
                game.setScreen(new FishingScreen(game));
            }
        });
        stage.addActor(playButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
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
        stage.dispose();
    }
}
