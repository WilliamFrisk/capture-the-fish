package com.group11.ctfish.model.fish;
import java.util.*;

import com.badlogic.gdx.graphics.Texture;
import com.group11.ctfish.model.fish.properties.*;


import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.fish.properties.Collectable;
import com.group11.ctfish.model.fish.sizes.Size;
import org.apache.commons.lang3.tuple.Pair;

public class FishFactory {
    private static Random random = new Random();

    private static final List<Pair<String, Class<? extends FishProperty>>> TEXTURE_PROPERTY_LIST = new ArrayList<>();

    static {
        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/red-fish/red-fish-right.png", Collectable.class));

    }

    public static Fish createStandardLeftFish() {
        return new Fish(
                1280,
                //CtFish.SCREEN_HEIGHT / 2,
                random.nextInt((CtFish.SCREEN_HEIGHT - 300 ) + 1),
                new Collectable(1),
                Size.MEDIUM,
                new Texture("tuna.png"),
                Direction.LEFT
                );
    }

    public static Fish createStandardRightFish() {
        return new Fish(
                0,
                //CtFish.SCREEN_HEIGHT / 2,
                random.nextInt((CtFish.SCREEN_HEIGHT - 300) + 1),
                new Collectable(1),
                Size.MEDIUM,
                new Texture("tuna.png"),
                Direction.RIGHT
        );
    }

    public static Fish createRandomFish() {
        int direction = random.nextInt(2);
        int type = random.nextInt(TEXTURE_PROPERTY_LIST.size());
        if (direction == 1) {
            return new Fish(
                  0,
                    random.nextInt((CtFish.SCREEN_HEIGHT - 300) + 1),
                    Size.MEDIUM,

            );
        }
    }

    public static Fish createRandomFish(int x, int y, Direction direction){
        int nextInt = random.nextInt(3);
        if(nextInt==1){
            return createRedFish(x,y,direction);
        } else if (nextInt == 2) {
            return createSwordFish(x,y,direction);
        } else {
            return createUglyFish(x,y,direction);
        }
    }

    public static Fish createRedFish(int x, int y, Direction direction){
        return new Fish(x, y,
                new Collectable(3),
                Size.MEDIUM,
                new Texture("fish/red-fish/red-fish-right.png"),
                direction);
    }

    public static Fish createSwordFish(int x, int y, Direction direction){
        return new Fish(x, y, new Endangered(), Size.LARGE,
                new Texture("fish/sword-fish/sword-fish-right.png"),
                direction);
    }

    public static Fish createUglyFish(int x, int y, Direction direction){
        return new Fish(x, y,
                new Collectable(4), Size.SMALL,
                new Texture("fish/ugly-fish/ugly-fish-left.png"),
                direction);
    }
}

