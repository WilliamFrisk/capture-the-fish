package com.group11.ctfish;

public class Fish {
    private int xPos;
    private int yPos;
    private final int width;
    private final int height;

    public Fish(int x, int y) {
        xPos = x;
        yPos = y;
        width = 40;
        height = 20;
    }

    public void move() {
        xPos++;
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
