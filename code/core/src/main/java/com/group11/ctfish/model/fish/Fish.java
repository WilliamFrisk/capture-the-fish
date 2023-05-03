package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;
import com.group11.ctfish.model.util.Object2D;


public class Fish implements Object2D {
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private FishProperty property;
    private FishSize size;
    private Texture texture;

    public Fish(int x, int y, FishProperty property, FishSize size, Texture texture) {
        xPos = x;
        yPos = y;
        width = size.getWidth();
        height = size.getHeight() ;
        this.texture = texture;
        this.property = property;
        this.size = size;
    }

    public void onCaught() {
        property.applyProperty();
    }

    public void move() {
        xPos--; //TODO implement this in a reasonable way
    }

    public float getX() {
        return xPos;
    }

    public float getY() {
        return yPos;
    }

    public Texture getTexture(){
        return texture;
    }

    public void setTextureWhite(){this.texture = new Texture("fish/red-fish/red-fish-left.png");}

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
