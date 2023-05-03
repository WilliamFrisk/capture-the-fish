package com.group11.ctfish.model.fish.sizes;

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
}
