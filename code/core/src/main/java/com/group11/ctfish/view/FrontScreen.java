package com.group11.ctfish.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.ModelFacade;

public class FrontScreen implements Screen {

    private final Texture background;
    private final Stage stage;
    private final TextField usernameField;

    private final ModelFacade facade = ModelFacade.getInstance();

    public FrontScreen(final CtFish game) {

        this.stage = new Stage();

        //setup background
        this.background = new Texture("frontPage2.png");
        Image image = new Image(background);
        image.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        stage.addActor(image);

        // setup usernamefield
        Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));

        // Create username input field
        usernameField = new TextField("", skin);
        usernameField.setMessageText("Enter your username");
        usernameField.setWidth(200f); // set minimum width for usernameField;
        usernameField.setHeight(50f); // set minimum height for usernameField;
        usernameField.setPosition(Gdx.graphics.getWidth() / 2f - usernameField.getWidth() / 2, Gdx.graphics.getHeight() / 2f);

        stage.addActor(usernameField);

        // Setup play button
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

        playButtonStyle.up.setMinWidth(200f); // set minimum width for button
        playButtonStyle.up.setMinHeight(50f); // set minimum height for button
        playButtonStyle.up.setTopHeight(10f); // set padding on top of the button
        playButtonStyle.up.setBottomHeight(10f); // set padding at the bottom of the button


        TextButton playButton = new TextButton("Play", playButtonStyle);
        playButton.setColor(Color.GREEN);
        playButton.setPosition(Gdx.graphics.getWidth() / 2f - playButton.getWidth() / 2, Gdx.graphics.getHeight() / 2f - 50);

        //add listener
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                String username = usernameField.getText();
                facade.createUser(username);

                FishingScreen fishingScreen = new FishingScreen(game, username);
                facade.subscribeToLives(fishingScreen);
                facade.subscribeToScores(fishingScreen);
                
                game.setScreen(fishingScreen);
                dispose();
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

        // setup background
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
        background.dispose();
        stage.dispose();
    }
}
