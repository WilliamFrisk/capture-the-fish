package com.group11.ctfish.model;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.math.Vector2;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.util.Object2D;

import java.util.TreeMap;

public class Hook implements Object2D {

    private final Texture texture;

    private Vector2 pos;

    private final float width;
    private final float height;

    private boolean fishOn = false;

    public Hook() {
        pos = new Vector2( CtFish.SCREEN_WIDTH - 515, CtFish.SCREEN_HEIGHT);
        width = 64;
        height = 64;
        texture = new Texture("hookImage.png");
    }

    Vector2 getVectorInstance() {
        return pos;
    }

    public void fishOn() {
        fishOn = true;
    }

    public boolean isFishOn() {
        return fishOn;
    }

    public float getX(){
        return pos.x;
    }

    public float getY() {
        return pos.y;
    }

    public int getWidth() {
        return (int) width;
    }

    public int getHeight() {
        return (int) height;
    }

    public void setY(float y) {
        pos.y = y;

        if (y >= 519)
            fishOn = false;
    }

    public Texture getTexture() {
        return texture;
    }


}