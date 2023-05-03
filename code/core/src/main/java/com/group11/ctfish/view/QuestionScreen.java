package com.group11.ctfish.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.ModelFacade;
import java.io.IOException;


public class QuestionScreen implements Screen {

    // Graphics

    private final CtFish game;
    private Stage stage;
    private TextArea questionArea;

    final Screen parent;

    ModelFacade facade = ModelFacade.getInstance();



    public QuestionScreen(final CtFish game, final Screen parent) throws IOException {

        this.game = game;
        this.stage = new Stage();
        this.parent = parent;



        // Create text field for question
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
        questionArea = new TextArea(facade.getQuestion(), skin);
        questionArea.setWidth(200);
        questionArea.setHeight(150);
        questionArea.setPosition(Gdx.graphics.getWidth() / 2 - questionArea.getWidth() / 2, Gdx.graphics.getHeight() / 2 + questionArea.getHeight()/2);
        stage.addActor(questionArea);

        // Create buttons for answers
        Label A1label = new Label(facade.getSpecificAnswer(1), skin, "default");
        A1label.setWrap(true);
        TextButton A1Button = new TextButton("", skin, "default");
        A1Button.setWidth(200);
        A1Button.setHeight(100);
        A1Button.setPosition(Gdx.graphics.getWidth() / 2 - A1Button.getWidth() - 20, Gdx.graphics.getHeight() / 2 - 75);
        A1Button.add(A1label).expand().fill();
        A1Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if (facade.getRightAnswer() == facade.getSpecificAnswer(1)){
                    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
                    questionArea = new TextArea("THAT IS RIGHT!!!!", skin);
                    questionArea.setWidth(200);
                    questionArea.setHeight(150);
                    questionArea.setPosition(Gdx.graphics.getWidth() / 2 - questionArea.getWidth() / 2, Gdx.graphics.getHeight() / 2 + questionArea.getHeight()/2);
                    stage.addActor(questionArea);
        }}});

        TextButton A2Button = new TextButton(facade.getSpecificAnswer(2), skin, "default");
        A2Button.setWidth(200);
        A2Button.setHeight(100);
        A2Button.setPosition(Gdx.graphics.getWidth() / 2 + 20 , Gdx.graphics.getHeight() / 2 - 75);
        A2Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if (facade.getRightAnswer() == facade.getSpecificAnswer(2)){
                    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
                    questionArea = new TextArea("THAT IS RIGHT!!!!", skin);
                    questionArea.setWidth(200);
                    questionArea.setHeight(150);
                    questionArea.setPosition(Gdx.graphics.getWidth() / 2 - questionArea.getWidth() / 2, Gdx.graphics.getHeight() / 2 + questionArea.getHeight()/2);
                    stage.addActor(questionArea);
                }}});

        TextButton A3Button = new TextButton(facade.getSpecificAnswer(3), skin, "default");
        A3Button.setWidth(200);
        A3Button.setHeight(100);
        A3Button.setPosition(Gdx.graphics.getWidth() / 2 - A3Button.getWidth() - 20, Gdx.graphics.getHeight() / 2 -200);
        A3Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if (facade.getRightAnswer() == facade.getSpecificAnswer(3)){
                    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
                    questionArea = new TextArea("THAT IS RIGHT!!!!", skin);
                    questionArea.setWidth(200);
                    questionArea.setHeight(150);
                    questionArea.setPosition(Gdx.graphics.getWidth() / 2 - questionArea.getWidth() / 2, Gdx.graphics.getHeight() / 2 + questionArea.getHeight()/2);
                    stage.addActor(questionArea);
                }}});

        TextButton A4Button = new TextButton(facade.getSpecificAnswer(4), skin, "default");
        A4Button.setWidth(200);
        A4Button.setHeight(100);
        A4Button.setPosition(Gdx.graphics.getWidth() / 2  + 20, Gdx.graphics.getHeight() / 2 - 200);
        A4Button.addListener( new ClickListener(){
            public void clicked(InputEvent event, float x, float y){
                if (facade.getRightAnswer() == facade.getSpecificAnswer(4)){
                    //HÄR SKA MAN LÄGGA IN VAD SOM HÄNDER NÄR DETTA ALTENATIV
                    Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
                    questionArea = new TextArea("THAT IS RIGHT!!!!", skin);
                    questionArea.setWidth(200);
                    questionArea.setHeight(150);
                    questionArea.setPosition(Gdx.graphics.getWidth() / 2 - questionArea.getWidth() / 2, Gdx.graphics.getHeight() / 2 + questionArea.getHeight()/2);
                    stage.addActor(questionArea);
                }}});

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
