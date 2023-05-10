package com.group11.ctfish.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.controller.HookController;
import com.group11.ctfish.model.Hook;
import com.group11.ctfish.model.Hookline;
import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.user.LifeObserver;
import com.group11.ctfish.model.user.ScoreObserver;

import java.io.IOException;


public class FishingScreen implements Screen, LifeObserver, ScoreObserver {

    // Graphics
    private final Texture background;
    private final SpriteBatch batch;
    private final UserRender scoreBoard;

    private final FishRender fishRenderer;
    private final UserRender lifeRenderer;

    final CtFish game;

    private final Stage stage;
    private final ModelFacade facade = ModelFacade.getInstance();

    private int hearts;

    OrthographicCamera camera;

    private final HookController hookController = new HookController(facade.getHookObject());

    private final String username;
    private int score;

    Music music;
    BitmapFont font = new BitmapFont();

    boolean underSurface = false;

    Hookline hookline;


    public FishingScreen(final CtFish game, Stage stage, String username) {
        this.stage = stage;
        music = Gdx.audio.newMusic(Gdx.files.internal("soundtrack.mp3"));

        // start the playback of the background music immediately
        music.setLooping(true);
        music.play();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);

        this.game = game;
        background = new Texture("background2.png");

        batch = new SpriteBatch();

        fishRenderer = new FishRender(batch);
        lifeRenderer = new UserRender();
        scoreBoard = new UserRender();
        this.username = username;

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();

        // setup background
        batch.draw(background,0,0, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);

        int posX = 50;
        for (int i = 1; i<=hearts; i++) {
            batch.draw(new Texture("heart.png"), posX,630,  lifeRenderer.getWidth(),lifeRenderer.getHeight());
            posX += 70;
        }

        // setup scoreboard
        font.setColor(Color.BLACK);

        font.draw(batch, username, 1100,680);
        font.draw(batch, "Score: "+ score, 1100,650);



        hookRender();
        facade.update();
        fishRenderer.render(facade.getFishes());
        batch.end();
        hookline = new Hookline(facade.getHookObject().getY());
        splashSoundGenerator();


        //PLACEHOLDER-KOD FÖR ATT BYTA TILL QUIZSCREEN

        if (facade.getFishBoolean()){
            try{
                facade.moveToNextQuestion();
                game.setScreen(new QuestionScreen(game, this));
            } catch (IOException e){
                e.printStackTrace();
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.L)) {
            facade.getUser().removeLife();
            System.out.println(hearts);
            }

        if (Gdx.input.isKeyPressed(Input.Keys.M)) {
            facade.getUser().updateScore(100);
            System.out.println(facade.getUser().getScore());
        }
    }

    private void splashSoundGenerator() {
        Sound splash = Gdx.audio.newSound(Gdx.files.internal("tinysplash.mp3"));
        if (facade.getHookObject().getY() < 490 && !underSurface){
            splash.play();
            underSurface = true;
        }
        if (facade.getHookObject().getY() > 490 && underSurface){
            underSurface = false;
        }
    }

    private void hookRender() {
        hookController.update();
        Hook hook = facade.getHookObject();
        batch.draw(hook.getTexture(), hook.getX(), hook.getY(), hook.getWidth(), hook.getHeight());
    }

    public void switchScreen() throws IOException {
        FishingScreen fishingScreenInstance = this;
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                try {
                    game.setScreen(new QuestionScreen(game, fishingScreenInstance));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }, 1f);


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
        music.dispose();
        stage.dispose();


    }

    @Override
    public void update(int lives) {
        hearts = lives;
        if (hearts == 0) {
            try {
                switchScreen();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void updateScore(int score) {
        this.score = score;

    }
}
