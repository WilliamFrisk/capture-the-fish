package com.group11.ctfish.model;

public class Hook {

    private int xPos;

    private int yPos;

    private final int width;

    private final int height;

    public Hook(int x, int y) {
        xPos = x;
        yPos = y;
        width = 40;
        height = 20;
    }

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
