package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;
import com.group11.ctfish.model.fish.sizes.Sizes;

public class FishFactory {

    //TODO Implement createRandomFish

    public static Fish createFish(int x, int y, FishProperty property, Sizes size, Texture texture) {
        return new Fish(x, y, property, size, new TextureRegion(texture));
    }
}

