package com.group11.ctfish.model.fish;

import java.util.ArrayList;
import java.util.List;

public class FishFacade {

    private static final FishFacade INSTANCE = new FishFacade();

    private final List<Fish> fishes = new ArrayList<>();

    public static FishFacade getInstance() {
        return INSTANCE;
    }

    public void update() {
        for (Fish fish : fishes) {
            fish.move();
        }
    }

    public List<Fish> getFishes() {
        return fishes;
    }

}
