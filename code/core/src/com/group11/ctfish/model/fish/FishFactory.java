package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;

import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;

public class FishFactory {

    //TODO Implement createRandomFish
    public static Fish createFish(int x, int y, FishProperty property, FishSize size, String texture) {
        return new Fish(x, y, property, size, new Texture(texture));
    }

}

