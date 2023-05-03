package com.group11.ctfish.model.fish.properties;

public class Collectable implements FishProperty{

    private final int score;

    public Collectable(int points){
        score = points;
    }

    public int getScore(){
        return score;
    }

    @Override
    public void applyProperty() {

    }
}
