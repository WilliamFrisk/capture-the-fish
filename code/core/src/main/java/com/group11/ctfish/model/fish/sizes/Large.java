package com.group11.ctfish.model.fish.sizes;

public class Large implements FishSize{

    private int width = 120;
    private int height = 120;

    @Override
    public int getWidth(){
        return width ;
    }
    @Override
    public int getHeight(){
        return height;
    }
}
