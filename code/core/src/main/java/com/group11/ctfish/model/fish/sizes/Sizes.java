package com.group11.ctfish.model.fish.sizes;

public enum Sizes {
    SMALL(0.1),
    MEDIUM(0.15),
    LARGE(0.2);

    private final double scaleFactor;

    Sizes(double scaleFactor) {
       this.scaleFactor = scaleFactor;
    }

    public double getScaleFactor() {
        return scaleFactor;
    }
}
