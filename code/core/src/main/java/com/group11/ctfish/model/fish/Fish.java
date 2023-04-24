package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;

import java.util.Random;

public class Fish{
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private boolean direction;
    private FishProperty property;
    private FishSize size;
    private Texture texture;

    static Random rand = new Random();

    public Fish(int x, int y, boolean isRight, FishProperty property, FishSize size, Texture texture) {
        xPos = x;
        yPos = y;
        direction = isRight;
        width = size.getWidth();
        height = size.getHeight() ;
        this.texture = texture;
        this.property = property;
        this.size = size;
    }

    public void onCaught() {
        property.applyProperty();
    }

    public void moveLeft() {
        int deltaY = rand.nextInt(-1,1);
        xPos--; //TODO implement this in a reasonable way
//        yPos = yPos + deltaY; //to be corrected
    }

    public void moveRight(){xPos++;}
    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public boolean movesRight(){
        return direction;
    }

    public Texture getTexture(){
        return texture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
