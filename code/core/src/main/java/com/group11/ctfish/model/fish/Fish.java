package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.Sizes;

public class Fish{
    private int xPos;
    private int yPos;
    private int width;
    private int height;
    private FishProperty property;
    private Sizes size;
    private TextureRegion texture;

    public Fish(int x, int y, FishProperty property, Sizes size, TextureRegion texture) {
        xPos = x;
        yPos = y;
        height = (int) (texture.getRegionHeight() * 0.3);
        width = (int) (texture.getRegionWidth() * size.getScaleFactor());
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

    public int getX() {
        return xPos;
    }

    public int getY() {
        return yPos;
    }

    public void setTexture(TextureRegion texture){
        this.texture = texture;
    }

    public TextureRegion getTexture(){
        return texture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
