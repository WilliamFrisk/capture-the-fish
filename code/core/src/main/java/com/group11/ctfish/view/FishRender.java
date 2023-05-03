package com.group11.ctfish.view;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.group11.ctfish.model.fish.Fish;

import java.util.List;

public class FishRender {

    private SpriteBatch batch;

    public FishRender(SpriteBatch batch) {
        this.batch = batch;
    }

    public void render(List<Fish> fishes){

        for (Fish fish : fishes) {
            fish.getSprite().draw(batch);
        }
    }
}
