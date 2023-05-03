package com.group11.ctfish.model.fish;

import java.util.Random;

public enum Size {
    SMALL(0.5f),
    MEDIUM(1f),
    LARGE(1.5f);

    private final float scaleFactor;

    Size(float scaleFactor) {
       this.scaleFactor = scaleFactor;
    }

    public float getScaleFactor() {
        return scaleFactor;
    }

    public static Size getRandomSize() {
        Random random = new Random();
        Size[] values = Size.values();
        int index = random.nextInt(values.length);
        return values[index];
    }
}
