package com.group11.ctfish.model;

import com.group11.ctfish.CtFish;

public class Hook {

    private float x;

    private float y;
    private String texture;

    private float width;

    private float height;


    public Hook() {
        x = CtFish.SCREEN_WIDTH - 515;
        y = CtFish.SCREEN_HEIGHT;
        width = 64;
        height = 64;
        texture = "hookImage";
    }

    public Hook getHook(){
        return this;
    }

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getWidth(){
        return width;
    }

    public float getHeight(){
        return height;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getTexture() {
        return texture;
    }



}
