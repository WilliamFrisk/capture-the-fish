package com.group11.ctfish.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.group11.ctfish.CtFish;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.group11.ctfish.model.ModelFacade;

public class FrontScreen implements Screen {
    private final CtFish game;
    private Stage stage;
    private TextField usernameField;
    private Texture background;


    ModelFacade facade = ModelFacade.getInstance();


    public FrontScreen(final CtFish game) {
        this.game = game;
        this.stage = new Stage();

        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        /*
        //Started with creating a title, but not finished
        Label title = new Label("Fish", skin);
        title.setFontScale(3);
        title.setPosition(Gdx.graphics.getWidth() / 2 - title.getWidth() / 2, Gdx.graphics.getHeight() - 50);
        stage.addActor(title);
        */

        // Create username input field

        usernameField = new TextField("", skin);
        usernameField.setMessageText("Enter your username");
        usernameField.setWidth(200f); // set minimum width for usernameField;
        usernameField.setHeight(50f); // set minimum height for usernameField;
        usernameField.setPosition(Gdx.graphics.getWidth() / 2 - usernameField.getWidth() / 2, Gdx.graphics.getHeight() / 2);

        stage.addActor(usernameField);


        // Create play button
        TextButton.TextButtonStyle playButtonStyle = new TextButton.TextButtonStyle();
        playButtonStyle.font = skin.getFont("default-font");
        playButtonStyle.fontColor = Color.WHITE;
        playButtonStyle.up = skin.getDrawable("default-round");
        playButtonStyle.over = skin.getDrawable("default-round-down");
        playButtonStyle.down = skin.getDrawable("default-round-down");
        playButtonStyle.checked = skin.getDrawable("default-round");

        playButtonStyle.overFontColor = Color.GREEN;
        playButtonStyle.checkedFontColor = Color.GREEN;
        playButtonStyle.downFontColor = Color.GREEN;
        //playButtonStyle.checkedFontColor = Color.GREEN;

        playButtonStyle.up.setMinWidth(200f); // set minimum width for button
        playButtonStyle.up.setMinHeight(50f); // set minimum height for button
        playButtonStyle.up.setTopHeight(10f); // set padding on top of the button
        playButtonStyle.up.setBottomHeight(10f); // set padding at the bottom of the button


        TextButton playButton = new TextButton("Play", playButtonStyle);
        playButton.setColor(Color.GREEN);
        playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 50);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String username = usernameField.getText();
                facade.createUser(username);
                FishingScreen fishingScreen = new FishingScreen(game, username);
                facade.subscribeToScores(fishingScreen);
                game.setScreen(new FishingScreen(game, username));
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
        Gdx.gl.glClearColor(135/255f, 206/255f, 235/255f, 1);
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
