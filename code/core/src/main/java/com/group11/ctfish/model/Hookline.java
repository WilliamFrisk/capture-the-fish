package com.group11.ctfish.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.CtFish;

public class Hookline {

    public Hookline(float y) {
        drawLine(y);
    }

    public void drawLine(float y) {
        ShapeRenderer sr = new ShapeRenderer();
        sr.setColor(Color.BROWN);
        Gdx.gl.glLineWidth(3);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.line(CtFish.SCREEN_WIDTH - ((376*CtFish.SCREEN_WIDTH)/1000), CtFish.SCREEN_HEIGHT-((47*CtFish.SCREEN_HEIGHT)/1000), CtFish.SCREEN_WIDTH - ((374*CtFish.SCREEN_WIDTH)/1000), y+((81*CtFish.SCREEN_HEIGHT)/1000));
        sr.end();
    }
}
