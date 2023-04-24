package com.group11.ctfish.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ScreenUtils;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.quiz.DatabaseConnection;
import com.group11.ctfish.model.quiz.Question;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;


public class QuestionScreen implements Screen {

    // Graphics

    DatabaseConnection db = new DatabaseConnection("questions.json");

    private final CtFish game;
    private Stage stage;
    private TextField questionField;


    ModelFacade facade = ModelFacade.getInstance();

    final Screen parent;

    OrthographicCamera camera;
    Question[] questions;



    public QuestionScreen(final CtFish game, final Screen parent) throws IOException {
        this.game = game;
        this.stage = new Stage();
        this.parent = parent;
        questions = db.readQuestions();

        // Create username input field
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        questionField = new TextField("", skin);
        questionField.setMessageText(getQuestion());
        questionField.setPosition(Gdx.graphics.getWidth() / 2 - questionField.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        stage.addActor(questionField);

        // Create play button
        TextButton playButton = new TextButton("Play", skin, "default");
        playButton.setPosition(Gdx.graphics.getWidth() / 2 - playButton.getWidth() / 2, Gdx.graphics.getHeight() / 2 - 50);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String username = questionField.getText();
                facade.createUser(username);
                game.setScreen(parent);
            }
        });
        stage.addActor(playButton);

        Gdx.input.setInputProcessor(stage);


    }

    public String getQuestion(){
        return questions[1].getQuestion();
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

        //PLACEHOLDER-KOD FÖR ATT BYTA TILLBAKA TILL FISHINGSCREEN
        if(Gdx.input.isKeyPressed(Input.Keys.G)){
            game.setScreen(parent);
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
