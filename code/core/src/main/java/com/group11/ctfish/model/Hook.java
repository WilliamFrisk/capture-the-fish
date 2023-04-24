package com.group11.ctfish.model;

import com.badlogic.gdx.math.Rectangle;

public class Hook {


    private Rectangle hook;

    public Hook() {
        hook = new Rectangle();
        hook.x = 750;
        hook.y = 475;
        hook.width = 32;
        hook.height = 32;
    }

    public Rectangle getHook(){
        return hook;
    }

}
