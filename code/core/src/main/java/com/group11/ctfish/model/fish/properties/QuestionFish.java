package com.group11.ctfish.model.fish.properties;

import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.fish.Fish;

public class QuestionFish implements FishProperty{

    ModelFacade MF = ModelFacade.getInstance();

    @Override
    public void applyProperty() {
        MF.questionFishCaught();

    }


}

