package com.group11.ctfish.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.controller.HookController;
import com.group11.ctfish.model.ModelFacade;


public class FishingScreen implements Screen {

    // Graphics

    private Texture background;

    private Texture hookImage;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private FishRender fishRender;

    final CtFish game;
    ModelFacade facade = ModelFacade.getInstance();

    OrthographicCamera camera;

    HookController hookController = new HookController(facade.getHookObject());



    public FishingScreen(final CtFish game) {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
        this.game = game;
        shapeRenderer = new ShapeRenderer();
        background = new Texture("background.jpg");
        batch = new SpriteBatch();
        fishRender = new FishRender(batch,shapeRenderer,camera);
    }




    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(background,0,0, CtFish.SCREEN_WIDTH, CtFish.SCREEN_HEIGHT);
        hookRender();
        fishRender.render(facade.getFishList());
        facade.CollisionUpdate();
        batch.end();

    }

    private void hookRender() {
        hookController.update();
        hookImage = new TextureRegion(new Texture(Gdx.files.internal(facade.getHookObject().getTexture()) + ".png")).getTexture();
        batch.draw(hookImage, facade.getHookObject().getHook().x, facade.getHookObject().getHook().y);
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
