package com.group11.ctfish.model.fish.sizes;

public class Medium implements FishSize{


    private int width = 90;
    private int height = 90;


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
