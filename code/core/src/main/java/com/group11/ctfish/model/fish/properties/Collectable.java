package com.group11.ctfish.model.fish.properties;

import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.user.User;

public class Collectable implements FishProperty{

    private final int score;
    private static User player = ModelFacade.getInstance().getPlayer();

    public Collectable(int points){
        score = points;
    }

    @Override
    public void applyProperty() {
        player.updateScore(this.score);
    }
}
