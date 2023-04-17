package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;

public class Fish{
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private FishProperty property;
    private FishSize size;
    private Texture texture;

    public Fish(int x, int y, FishProperty property, FishSize size, Texture texture) {
        xPos = x;
        yPos = y;
        width = size.getWidth();
        height = size.getHeight() ;
        this.texture = texture;
        this.property = property;
        this.size = size;
    }

    public void onCaught() {
        property.applyProperty();
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
