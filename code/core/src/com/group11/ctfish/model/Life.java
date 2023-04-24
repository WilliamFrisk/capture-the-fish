package com.group11.ctfish.model;

import com.badlogic.gdx.graphics.Texture;

public class Life {

    private Texture texture;

    private int posX;

    private int posY;

    private final int width;

    private final int height;

    public Life(int X, int Y){
        texture = new Texture("heart.png");
        posX = X;
        posY = Y;

        width = 30;
        height = 30;

    }

    public Texture getTexture(){
        return this.texture;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
