package com.group11.ctfish.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.Timer;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.fish.properties.QuestionFish;
import com.group11.ctfish.model.user.LifeObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class QuestionScreen implements Screen, LifeObserver {

    // Graphics

    private final CtFish game;
    private Stage stage;
    private TextArea questionArea;

    final Screen parent;

    private int hearts;

    ModelFacade facade = ModelFacade.getInstance();




    public QuestionScreen(final CtFish game, Screen parent) throws IOException {

        this.game = game;
        this.stage = new Stage();
        this.parent = parent;
        facade.moveToNextQuestion();



        // Create text field for question
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        questionArea = new TextArea(facade.getQuestion(), skin);
        questionArea.setDisabled(true);
        questionArea.setWidth(200);
        questionArea.setHeight(150);
        questionArea.setPosition(Gdx.graphics.getWidth() / 2 - questionArea.getWidth() / 2, Gdx.graphics.getHeight() / 2 + questionArea.getHeight()/2);
        stage.addActor(questionArea);


        // Create buttons for answers




        TextButton A1Button = new TextButton("", skin, "default");
        Label label =  new Label(facade.getSpecificAnswer(1), skin);
        label.setWrap(true);
        label.setAlignment(Align.center);
        label.setWidth(150);

        A1Button.setWidth(200);
        A1Button.setHeight(100);
        A1Button.addActor(label);
        label.setPosition((A1Button.getWidth() - label.getWidth()) / 2f, (A1Button.getHeight() - label.getHeight()) / 2f);
        A1Button.setPosition(Gdx.graphics.getWidth() / 2 - A1Button.getWidth() - 20, Gdx.graphics.getHeight() / 2 - 75);
        A1Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if (facade.getSpecificAnswer(1).equalsIgnoreCase(facade.getCorrectAnswer())){
                    System.out.println("NU DÅ");
                    A1Button.setColor(Color.GREEN);
                    facade.addLife(facade.getSpecificAnswer(1));
                }
                else {
                    if (hearts == 0) {
                        System.out.println("game over");
                        

                    }
                }

        }});

        TextButton A2Button = new TextButton("", skin, "default");
        Label label2 =  new Label(facade.getSpecificAnswer(2), skin);
        label2.setWrap(true);
        label2.setAlignment(Align.center);

        label2.setWidth(150);

        A2Button.setWidth(200);
        A2Button.setHeight(100);
        A2Button.addActor(label2);
        label2.setPosition((A2Button.getWidth() - label2.getWidth()) / 2f, (A2Button.getHeight() - label2.getHeight()) / 2f);
        A2Button.setPosition(Gdx.graphics.getWidth() / 2 + 20 , Gdx.graphics.getHeight() / 2 - 75);
        A2Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if (facade.getSpecificAnswer(2).equalsIgnoreCase(facade.getCorrectAnswer())){
                    System.out.println("NU DÅ");
                    A2Button.setColor(Color.GREEN);
                    facade.addLife(facade.getSpecificAnswer(2));
                }
//                else if(hearts == 0){
//                    System.out.println("game over");
//                    game.setScreen(new FrontScreen(game));
//
//                }


            }});

        TextButton A3Button = new TextButton("", skin, "default");
        Label label3 = new Label(facade.getSpecificAnswer(3), skin);
        label3.setWrap(true);
        label3.setAlignment(Align.center);

        label3.setWidth(150);

        A3Button.setWidth(200);
        A3Button.setHeight(100);
        A3Button.addActor(label3);
        label3.setPosition((A3Button.getWidth() - label3.getWidth()) / 2f, (A3Button.getHeight() - label3.getHeight()) / 2f);
        A3Button.setPosition(Gdx.graphics.getWidth() / 2 - A3Button.getWidth() - 20, Gdx.graphics.getHeight() / 2 -200);
        A3Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if (facade.getSpecificAnswer(3).equalsIgnoreCase(facade.getCorrectAnswer())){
                    System.out.println("NU DÅ");
                    A3Button.setColor(Color.GREEN);
                    facade.addLife(facade.getSpecificAnswer(3));
//                }else if(hearts == 0){
//                    System.out.println("game over");
//                    game.setScreen(new FrontScreen(game));
//
                }


            }});

        TextButton A4Button = new TextButton("", skin, "default");
        Label label4 = new Label(facade.getSpecificAnswer(4), skin);
        label4.setWrap(true);
        label4.setAlignment(Align.center);

        label4.setWidth(150);


        A4Button.setWidth(200);
        A4Button.setHeight(100);
        A4Button.addActor(label4);
        label4.setPosition((A4Button.getWidth() - label4.getWidth()) / 2f, (A4Button.getHeight() - label4.getHeight()) / 2f);
        A4Button.setPosition(Gdx.graphics.getWidth() / 2  + 20, Gdx.graphics.getHeight() / 2 - 200);
        A4Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if (facade.getSpecificAnswer(4).equalsIgnoreCase(facade.getCorrectAnswer())){
                    A4Button.setColor(Color.GREEN);
                    facade.addLife(facade.getSpecificAnswer(4));
//                }else if(hearts == 0){
//                    System.out.println("game over");
//                    game.setScreen(new FrontScreen(game));
//
                }

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
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    game.setScreen(parent);

                }
            }, 1f);
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
    @Override
    public void update(int lives) {
        hearts = lives;
    }
}
