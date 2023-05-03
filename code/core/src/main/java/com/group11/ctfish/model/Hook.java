package com.group11.ctfish.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.util.Object2D;

public class Hook implements Object2D {

    private Rectangle hook;
    private String texture;

    public Hook() {
        hook = new Rectangle();
        hook.x = CtFish.SCREEN_WIDTH - 535;
        hook.y = CtFish.SCREEN_HEIGHT - 100;
        hook.width = 10;
        hook.height = 10;
        texture = "hookImage";

    }

    public Rectangle getHook(){
        return hook;
    }

    public void setHookY(float y) {
        this.hook.y = y;
    }

    public String getTexture() {
        return texture;
    }


    @Override
    public float getX() {
        return hook.x;
    }

    @Override
    public float getY() {
        return hook.y;
    }

    @Override
    public int getWidth() {
        return (int) hook.width;
    }

    @Override
    public int getHeight() {
        return (int) hook.width;
    }
}
