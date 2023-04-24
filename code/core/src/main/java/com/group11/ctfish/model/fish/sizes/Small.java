package com.group11.ctfish.model.fish.sizes;

public class Small implements FishSize{
    private int width = 80;
    private int height = 40;


    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }
}
