package com.group11.ctfish.view;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.Json;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ScreenUtils;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.Fish;
import com.group11.ctfish.model.QuizData;

import java.io.File;
import java.util.logging.FileHandler;


public class QuestionScreen implements Screen {

    // Graphics

    private SpriteBatch batch;

    private ShapeRenderer shapeRenderer;

    FileHandle fileHandler = Gdx.files.internal("file.json");

    String jsonData = fileHandler.readString();

    Json json = new Json();

    QuizData quizData = json.fromJson(QuizData.class, jsonData);

    BitmapFont bitmapFont;

    final CtFish game;

    OrthographicCamera camera;


    public QuestionScreen(final CtFish game) {

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.game = game;

        batch = new SpriteBatch();
        bitmapFont = new BitmapFont();
        shapeRenderer = new ShapeRenderer();





    }

    @Override
    public void show() {



    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Color.SKY);
        game.shape.begin(ShapeRenderer.ShapeType.Filled);
        game.shape.setColor(Color.WHITE);;
        game.shape.rect(40,270,560,170);
        game.shape.rect(40,150,270,100);
        game.shape.rect(330,150,270,100);
        game.shape.rect(40,30,270,100);
        game.shape.rect(330,30,270,100);
        game.shape.end();





        batch.begin();
        bitmapFont.setColor(Color.BLACK);
        bitmapFont.draw(batch,quizData.question, 100, 350);
        bitmapFont.draw(batch, quizData.answers[0].answer, 150,200);
        batch.end();




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
