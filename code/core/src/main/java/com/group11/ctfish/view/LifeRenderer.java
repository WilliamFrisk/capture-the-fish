package com.group11.ctfish.view;

public class LifeRenderer {

    private int posX;

    private int posY;

    private int width;

    private int height;

    public LifeRenderer(int x, int y){
        this.posX = x;
        this.posY = y;
        this.width = 50;
        this.height = 50;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
