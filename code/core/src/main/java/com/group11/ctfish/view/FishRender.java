package com.group11.ctfish.view;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.model.fish.Fish;

import java.util.List;

public class FishRender {


        private SpriteBatch batch;
        private ShapeRenderer shapeRenderer;
        private Camera camera;

    public FishRender(SpriteBatch batch, ShapeRenderer shapeRenderer, Camera camera) {
        this.batch = batch;
        this.shapeRenderer = shapeRenderer;
        this.camera = camera;
    }

    public void render(List<Fish> fishes){
        for (Fish fish : fishes) {
            fish.move();
            if (fish.getX() < 0) {
                continue;
            }
            shapeRenderer.setProjectionMatrix(camera.combined);
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            batch.begin();
            batch.draw(fish.getTexture(), fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());
            batch.end();
            shapeRenderer.end();
        }
    }
}