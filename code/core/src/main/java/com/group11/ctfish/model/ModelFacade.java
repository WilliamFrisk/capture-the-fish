package com.group11.ctfish.model;

import com.group11.ctfish.model.fish.Fish;
import com.group11.ctfish.model.fish.FishFactory;
import com.group11.ctfish.model.fish.properties.Endangered;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;
import com.group11.ctfish.model.fish.sizes.Medium;
import com.group11.ctfish.model.util.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ModelFacade {
    private List<Fish> fishList;

    private static ModelFacade instance = new ModelFacade();
    Hook hook = new Hook();

    private static final int TOTAL_FISHES = 15;
    private static final int TIME_DIFFERENCE = 250;
    Random rand = new Random();

    private ModelFacade (){
        this.fishList = new ArrayList<>();

        int time = 1280;
        int rotation = 0;

        while (rotation <= TOTAL_FISHES) {
            rotation = rotation + 1;
            time = time + TIME_DIFFERENCE;
            createFish(time, rand.nextInt(281), new Endangered(), new Medium(), "tuna.png");

        }
    }


    public static ModelFacade getInstance(){
        return instance;
    }

    public void CollisionUpdate(){
        for(Fish i : getFishList()) {
            if (Utils.collides(i, hook)) {
                i.setTextureWhite();
            }
        }
    }



    private void createFish(int x, int y, FishProperty property, FishSize size, String texture) {
        fishList.add(FishFactory.createFish(x,y,property, size, texture));
    }

    public Hook getHookObject(){
        return hook;
    }

    public List<Fish> getFishList() {
        return fishList;
    }
}
