package com.group11.ctfish.model;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.group11.ctfish.CtFish;

public class Line {

    public Line(int y) {
        drawLine(y);
    }

    public void drawLine(float y) {
        ShapeRenderer sr = new ShapeRenderer();
        sr.setColor(Color.BROWN);
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.line(CtFish.SCREEN_WIDTH - 535, CtFish.SCREEN_HEIGHT - 100, CtFish.SCREEN_WIDTH - 535, y);
        sr.end();
    }
}
