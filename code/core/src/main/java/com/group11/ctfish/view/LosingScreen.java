package com.group11.ctfish.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.group11.ctfish.CtFish;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.group11.ctfish.model.ModelFacade;

import java.io.IOException;

public class LosingScreen implements Screen {
    private final CtFish game;
    private Stage stage;
    private Texture background;
    private BitmapFont font = new BitmapFont();
    private ModelFacade facade = ModelFacade.getInstance();

    private int score;

    private String username;

    public LosingScreen(final CtFish game, int score, String username) {
        this.game = game;
        this.stage = new Stage();
        this.score = score;

        // set background
        this.background = new Texture("endPage.png");
        Image image = new Image(background);
        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage.addActor(image);
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        // set result text
        Label output = new Label("Your score: "+ score, skin);
        output.setPosition(Gdx.graphics.getWidth() / 2 - output.getWidth()/2, Gdx.graphics.getHeight() / 2+30);
        output.setColor(Color.BLACK);
        stage.addActor(output);

        // Create quiz button
        TextButton.TextButtonStyle playAgain = new TextButton.TextButtonStyle();
        playAgain.font = skin.getFont("default-font");
        playAgain.fontColor = Color.WHITE;
        playAgain.up = skin.getDrawable("default-round");
        playAgain.over = skin.getDrawable("default-round-down");
        playAgain.down = skin.getDrawable("default-round-down");
        playAgain.checked = skin.getDrawable("default-round");

        playAgain.overFontColor = Color.GREEN;
        playAgain.checkedFontColor = Color.GREEN;
        playAgain.downFontColor = Color.GREEN;

        playAgain.up.setMinWidth(200f); // set minimum width for button
        playAgain.up.setMinHeight(50f); // set minimum height for button
        playAgain.up.setTopHeight(10f); // set padding on top of the button
        playAgain.up.setBottomHeight(10f); // set padding at the bottom of the button

        TextButton playButton = new TextButton("Play again!", playAgain);
        playButton.setColor(Color.BLUE);
        playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 50);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                facade.createUser(username);
                FishingScreen fishingScreen = new FishingScreen(game, username);
                facade.subscribeToLives(fishingScreen);
                facade.subscribeToScores(fishingScreen);
                game.setScreen(fishingScreen);

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
        Gdx.gl.glClearColor(0, 0, 0, 1);
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
