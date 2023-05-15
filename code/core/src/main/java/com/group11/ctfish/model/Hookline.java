package com.group11.ctfish.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.CtFish;

public class Hookline {
    private final ShapeRenderer sr  = new ShapeRenderer();

    public void drawLine(float y) {
        sr.setColor(Color.BROWN);
        Gdx.gl.glLineWidth(3);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.line(
                CtFish.SCREEN_WIDTH - ((376f*CtFish.SCREEN_WIDTH)/1000),
                CtFish.SCREEN_HEIGHT-((47f*CtFish.SCREEN_HEIGHT)/1000),
                CtFish.SCREEN_WIDTH - ((374f*CtFish.SCREEN_WIDTH)/1000),
                y+((81f*CtFish.SCREEN_HEIGHT)/1000)
        );
        sr.end();
    }
}
