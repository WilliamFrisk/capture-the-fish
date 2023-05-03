package com.group11.ctfish.view;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.model.fish.Fish;


import java.util.List;

public class FishRender {
    private int x = 0;
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
            fish.moveRight();


            if (fish.getX() < -225) {
                continue;
            }
            batch.draw(fish.getTexture(), fish.getX(), fish.getY(), fish.getWidth(), fish.getHeight());
            shapeRenderer.end();
        }
    }
}
