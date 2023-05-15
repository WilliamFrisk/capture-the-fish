package com.group11.ctfish.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
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

    private Screen backScreen;
    private Stage stage;
    private Texture background;
    private BitmapFont font = new BitmapFont();
    private ModelFacade facade = ModelFacade.getInstance();

    private int score;

    public LosingScreen(final CtFish game, int score, Screen screen) {
        this.game = game;
        this.stage = new Stage();
        this.score = score;
        this.backScreen = screen;

        // set background
        this.background = new Texture("endPage.png");
        Image image = new Image(background);
        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage.addActor(image);
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        // set result text
        Label output = new Label("Your score: "+ score , skin);
        output.setPosition(Gdx.graphics.getWidth() / 2 - output.getWidth()/2, Gdx.graphics.getHeight() / 2+25);
        output.setColor(Color.BLACK);
        stage.addActor(output);



        // Create quiz button
        TextButton.TextButtonStyle answerQuiz = new TextButton.TextButtonStyle();
        answerQuiz.font = skin.getFont("default-font");
        answerQuiz.fontColor = Color.WHITE;
        answerQuiz.up = skin.getDrawable("default-round");
        answerQuiz.over = skin.getDrawable("default-round-down");
        answerQuiz.down = skin.getDrawable("default-round-down");
        answerQuiz.checked = skin.getDrawable("default-round");

        answerQuiz.overFontColor = Color.GREEN;
        answerQuiz.checkedFontColor = Color.GREEN;
        answerQuiz.downFontColor = Color.GREEN;

        answerQuiz.up.setMinWidth(200f); // set minimum width for button
        answerQuiz.up.setMinHeight(50f); // set minimum height for button
        answerQuiz.up.setTopHeight(10f); // set padding on top of the button
        answerQuiz.up.setBottomHeight(10f); // set padding at the bottom of the button

        TextButton quizButton = new TextButton("Play Again", answerQuiz);
        quizButton.setColor(Color.BLUE);
        quizButton.setPosition(Gdx.graphics.getWidth() / 2 - quizButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 50);

        quizButton.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(backScreen);
                facade.getUser().resetGame();
                dispose();
                }
        });

        stage.addActor(quizButton);

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
        background.dispose();
        background.dispose();
        font.dispose();

    }
}
