package com.group11.ctfish.model.fish.properties;

import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.fish.Fish;
import com.group11.ctfish.model.user.User;

public class Collectable implements FishProperty{

    private final int score;
    private static final User player = ModelFacade.getInstance().getUser();
    private final ModelFacade modelFacade = ModelFacade.getInstance();


    public Collectable(int points){
        score = points;
    }

    @Override
    public void applyProperty(Fish fish) {
        fish.hooked();
        if (fish.collected()){
            applyScore();
        }
    }

    public void applyScore(){
        player.updateScore(this.score);

    }
}
