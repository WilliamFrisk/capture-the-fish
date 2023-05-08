package com.group11.ctfish.model;

import com.badlogic.gdx.graphics.Texture;

import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.util.Object2D;

import java.util.TreeMap;

public class Hook implements Object2D {

    private final Texture texture;

    private final float x;
    private float y;

    private final float width;
    private final float height;

    private boolean catched;

    public Hook() {
        x = CtFish.SCREEN_WIDTH - 515;
        y = CtFish.SCREEN_HEIGHT;
        width = 64;
        height = 64;
        texture = new Texture("hookImage.png");
        catched = true;
    }



    public void setCatchedTrue(){
        this.catched = true;
    }



    public float getX(){
        return x;
    }

    public float getY() {
        return y;
    }

    public int getWidth() {
        return (int) width;
    }

    public int getHeight() {
        return (int) height;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Texture getTexture() {
        return texture;
    }


}