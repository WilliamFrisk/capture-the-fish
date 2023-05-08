package com.group11.ctfish.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.ModelFacade;

import java.io.IOException;


public class QuestionScreen implements Screen {

    private final CtFish game;
    private final Stage stage;
    private final Screen parent;

    private final ModelFacade facade = ModelFacade.getInstance();


    public QuestionScreen(final CtFish game, final Screen parent) throws IOException {

        this.game = game;
        this.stage = new Stage();
        this.parent = parent;



        // Create text field for question
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        TextArea questionArea = new TextArea(facade.getQuestion(), skin);
        questionArea.setWidth(200);
        questionArea.setHeight(150);
        questionArea.setPosition(Gdx.graphics.getWidth() / 2f - questionArea.getWidth() / 2, Gdx.graphics.getHeight() / 2f + questionArea.getHeight()/2);
        stage.addActor(questionArea);


        // Create buttons for answers


        TextButton A1Button = new TextButton(facade.getSpecificAnswer(1), skin, "default");
        A1Button.setWidth(200);
        A1Button.setHeight(100);
        A1Button.setPosition(Gdx.graphics.getWidth() / 2f - A1Button.getWidth() - 20, Gdx.graphics.getHeight() / 2f - 75);
        A1Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                facade.addLife(facade.getSpecificAnswer(1));
        }});

        TextButton A2Button = new TextButton(facade.getSpecificAnswer(2), skin, "default");
        A2Button.setWidth(200);
        A2Button.setHeight(100);
        A2Button.setPosition(Gdx.graphics.getWidth() / 2f + 20 , Gdx.graphics.getHeight() / 2f - 75);
        A2Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                facade.addLife(facade.getSpecificAnswer(2));
            }});

        TextButton A3Button = new TextButton(facade.getSpecificAnswer(3), skin, "default");
        A3Button.setWidth(200);
        A3Button.setHeight(100);
        A3Button.setPosition(Gdx.graphics.getWidth() / 2f - A3Button.getWidth() - 20, Gdx.graphics.getHeight() / 2f -200);
        A3Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                facade.addLife(facade.getSpecificAnswer(3));}});

        TextButton A4Button = new TextButton(facade.getSpecificAnswer(4), skin, "default");
        A4Button.setWidth(200);
        A4Button.setHeight(100);
        A4Button.setPosition(Gdx.graphics.getWidth() / 2f  + 20, Gdx.graphics.getHeight() / 2f - 200);
        A4Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                facade.addLife(facade.getSpecificAnswer(4));
            }});

        stage.addActor(A1Button);
        stage.addActor(A2Button);
        stage.addActor(A3Button);
        stage.addActor(A4Button);

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


        if(facade.getAnswerBoolean()){
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
