package main.java.com.group11.ctfish.view;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.fish.Fish;

import com.group11.ctfish.model.fish.FishFactory;
import com.group11.ctfish.model.fish.properties.Endangered;
import com.group11.ctfish.model.fish.sizes.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FishingScreen implements Screen {

    // Graphics

    private Texture background;
    private SpriteBatch batch;

    final CtFish game;

    OrthographicCamera camera;

    List<Fish> fishes = new ArrayList<>();

    private static final int TOTAL_FISHES = 15;
    private static final int TIME_DIFFERENCE = 250;
    Random rand = new Random();


    public FishingScreen(final CtFish game) {
        produce(TOTAL_FISHES);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
        this.game = game;
        background = new Texture("background.jpg");
        batch = new SpriteBatch();
    }

    //TODO fix this mess
    public void produce(int totalFishes){
        int time = 0;
        int count = 0;

        while (count <= totalFishes) {
            boolean direction = rand.nextBoolean();
            if(direction){
                time = 10 - count*TIME_DIFFERENCE;
            }else {
                time = 1280 + count*TIME_DIFFERENCE;
            }

            Fish fish = FishFactory.createRandomFish(
                    time,
                    rand.nextInt(281),
                    direction);
            fishes.add(fish);
            count++;
        }
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background,0,0, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
        batch.end();

        //TODO move this to a new class for rendering fish
        for (Fish fish : fishes) {
            if(fish.movesRight()){
                fish.moveRight();
            }else {
                fish.moveLeft();
            }

            if (fish.getX() < 0) {
                continue;
            }

            game.shape.setProjectionMatrix(camera.combined);
            game.shape.begin(ShapeRenderer.ShapeType.Line);
            batch.begin();
            batch.draw(fish.getTexture(), fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());
            batch.end();
            game.shape.end();
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
