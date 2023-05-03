package com.group11.ctfish.model;

import com.badlogic.gdx.math.Rectangle;
import com.group11.ctfish.CtFish;

public class Hook {


    private Rectangle hook;

    private String texture;



    public Hook() {
        hook = new Rectangle();
        hook.x = CtFish.SCREEN_WIDTH - 535;
        hook.y = CtFish.SCREEN_HEIGHT - 100;
        hook.width = 32;
        hook.height = 32;
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


}