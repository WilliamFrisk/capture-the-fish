package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;


import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.group11.ctfish.model.fish.properties.Collectable;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;
import com.group11.ctfish.model.fish.sizes.Medium;

import java.util.Random;

public class FishFactory {
    private static Random random = new Random();

    //TODO Implement createRandomFish

    public static Fish createStandardLeftFish() {
        return new Fish(
                1280,
                random.nextInt(721),
                new Collectable(),
                new Medium(),
                new TextureRegion(new Texture("tuna.png")),
                Direction.LEFT
                );
    }

    public static Fish createStandardRightFish() {
        return new Fish(
                0,
                random.nextInt(721),
                new Collectable(),
                new Medium(),
                new TextureRegion(new Texture("tuna.png")),
                Direction.RIGHT
        );
    }

    public static Fish createFish(int x, int y, FishProperty property, FishSize size, String texture) {
        return new Fish(x, y, property, size, new TextureRegion(new Texture(texture)), Direction.LEFT);
    }
}

