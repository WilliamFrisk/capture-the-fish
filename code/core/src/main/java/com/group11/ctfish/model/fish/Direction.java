package com.group11.ctfish.model.fish;

import java.util.Random;

public enum Direction {
    LEFT,
    RIGHT;

    public static Direction getRandomDirection() {
        Random random = new Random();
        Direction[] values = Direction.values();
        int index = random.nextInt(values.length);
        return values[index];
    }
}
