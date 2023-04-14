package com.group11.ctfish.model;

import com.badlogic.gdx.graphics.Texture;

public class Fish {
    private int xPos;
    private int yPos;
    private final int width;
    private final int height;
    private Texture texture;

    public Fish(int x, int y) {
        xPos = x;
        yPos = y;
        width = 90;
        height = 60;
        texture = new Texture("tuna.png");

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

    public Texture getTexture(){return texture;}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
