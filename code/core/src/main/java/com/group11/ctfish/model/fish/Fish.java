package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;
import com.group11.ctfish.model.util.Object2D;
import com.group11.ctfish.model.fish.sizes.Sizes;

import java.util.Random;


public class Fish implements Object2D {
    private int xPos;
    private int yPos;
    private int width;
    private int height;

    private boolean direction;
    private FishProperty property;
    private FishSize size;
    private Texture texture;
    static Random rand = new Random();

    public Fish(int x, int y, boolean isRight, FishProperty property, FishSize size, Texture texture) {
        xPos = x;
        yPos = y;
        direction = isRight;
        width = size.getWidth();
        height = size.getHeight() ;
        this.texture = texture;
        this.property = property;
        this.size = size;

    }

    public void onCaught() {
        property.applyProperty();
    }

    public void moveLeft() { // TODO: Fix moving pattern so that fish moves in both x and y direction
//        int deltaY = rand.nextInt(2)-1;
//        if(this.getY()+deltaY > 0 && this.getY()+deltaY < 281){
//            yPos = yPos + deltaY;
//        }else if (this.getY() == 0){
//            yPos++;
//        }else yPos--;
        xPos--;
    }

    public float getX() {

    public void moveRight(){xPos++;}
    public int getX() {
        return xPos;
    }

    public float getY() {
        return yPos;
    }

    public boolean movesRight(){
        return direction;
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
