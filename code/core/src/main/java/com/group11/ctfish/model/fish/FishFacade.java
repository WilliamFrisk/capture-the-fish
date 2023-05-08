package com.group11.ctfish.model.fish;

import com.group11.ctfish.CtFish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class FishFacade {

    private static final FishFacade INSTANCE = new FishFacade();

    private final List<Fish> fishes = new ArrayList<>();

    private static final int FISH_LIMIT = 10;
    private int deltaTime = 0;



    public static FishFacade getInstance() {
        return INSTANCE;
    }

    private FishFacade() {
    }

    public List<Fish> getFishes() {
        return fishes;
    }





    public void update() {
        updateFishes();

        Iterator<Fish> iterator = fishes.iterator();
        while (iterator.hasNext()) {
            Fish fish = iterator.next();

            if (fish.getX() < -200 || fish.getX() > CtFish.SCREEN_WIDTH || fish.collected()) {
                iterator.remove();
            } else {
                fish.update(fishes);
                fish.move();
            }
        }
    }

    private void updateFishes() {
        Random random = new Random();
        deltaTime++;

        if (fishes.size() >= FISH_LIMIT) {
            return;
        } else if (fishes.size() == 0) {
            fishes.add(FishFactory.createRandomFish());
        }

        if (random.nextInt(500) - deltaTime < 0) {
            deltaTime = 0;
            fishes.add(FishFactory.createRandomFish());
        }
    }
}
