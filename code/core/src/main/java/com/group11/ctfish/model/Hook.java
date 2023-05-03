package com.group11.ctfish.model;

import com.badlogic.gdx.graphics.Texture;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.util.Object2D;

public class Hook implements Object2D {

    private float x;

    private float y;
    private Texture texture;

    private float width;

    private float height;

    public Hook() {
        x = CtFish.SCREEN_WIDTH - 515;
        y = CtFish.SCREEN_HEIGHT;
        width = 64;
        height = 64;
        texture = new Texture("hookImage.png");
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public int getWidth(){
        return (int) width;
    }

    public int getHeight(){
        return (int) height;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Texture getTexture() {
        return texture;
    }
}
