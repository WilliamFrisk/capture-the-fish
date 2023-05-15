package com.group11.ctfish.model;

import com.badlogic.gdx.graphics.Texture;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.util.Object2D;

public class Hook implements Object2D {

    private final Sprite texture;

    private Vector2 pos;

    private final float width;
    private final float height;

    private boolean fishOn = false;

    public Hook() {
        pos = new Vector2( CtFish.SCREEN_WIDTH - 515, CtFish.SCREEN_HEIGHT);
        width = 32;
        height = 64;
        texture = new Sprite(new Texture("hookImage.png"));
        texture.setSize(64, 64);
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

    public Sprite getSprite() {
        return texture;
    }


}