package com.group11.ctfish.model.fish.properties;

import com.group11.ctfish.model.fish.Fish;

public class Question implements FishProperty{


    @Override
    public void applyProperty(Fish fish) {
        fish.hooked();
        if (fish.collected()) {
            System.out.println("FÅNGAD");
        }
    }


}
