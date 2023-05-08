package com.group11.ctfish.model.fish.properties;

import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.fish.Fish;
import com.group11.ctfish.model.user.User;

public class Endangered implements FishProperty {


    private static final User player = ModelFacade.getInstance().getUser();
    @Override
    public void applyProperty() {
        removeLife();

    }

    public void removeLife(){
        player.removeLife();
    }
}
