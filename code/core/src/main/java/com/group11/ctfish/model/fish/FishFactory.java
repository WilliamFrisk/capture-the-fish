package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.fish.properties.Collectable;
import com.group11.ctfish.model.fish.properties.Endangered;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.properties.QuestionFish;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class FishFactory {
    private static final Random random = new Random();

    private static final List<Pair<String, Supplier<FishProperty>>> TEXTURE_PROPERTY_LIST = new ArrayList<>();

    static {

        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/red_fish.png",  () -> new Collectable(2) ));
        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/blue_fish.png",  () -> new Collectable(2) ));
        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/blue_fish.png",  () -> new Collectable(2) ));
        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/red_fish.png",  () -> new Collectable(2) ));
        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/sword_fish.png", QuestionFish::new));
        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/ugly_fish.png", Endangered::new));
        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/ugly_fish.png", Endangered::new));
        TEXTURE_PROPERTY_LIST.add(Pair.of("fish/ugly_fish.png", Endangered::new));

    }

    static Fish createStandardLeftFish() {
        return new Fish(
                1280,
                random.nextInt((CtFish.SCREEN_HEIGHT - 300 ) + 1),
                new Collectable(1),
                Size.MEDIUM,
                new Texture("tuna.png"),
                Direction.LEFT
                );
    }

    static Fish createStandardRightFish() {
        return new Fish(
                0,
                random.nextInt((CtFish.SCREEN_HEIGHT - 300) + 1),
                new Collectable(1),
                Size.MEDIUM,
                new Texture("tuna.png"),
                Direction.RIGHT
        );
    }

    public static Fish createRandomFish() {

        int type = random.nextInt(TEXTURE_PROPERTY_LIST.size());
        Direction dir = Direction.getRandomDirection();
        return new Fish(
                dir == Direction.RIGHT ? -200 : 1280,
                random.nextInt((CtFish.SCREEN_HEIGHT - 300) + 1),
                TEXTURE_PROPERTY_LIST.get(type).getRight().get(),
                Size.getRandomSize(),
                new Texture(TEXTURE_PROPERTY_LIST.get(type).getLeft()),
                dir
        );

    }
}

