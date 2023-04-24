package com.group11.ctfish.model;

import com.group11.ctfish.model.fish.Fish;
import com.group11.ctfish.model.fish.FishFactory;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;
import com.group11.ctfish.model.user.User;

import java.util.List;

public final class ModelFacade {
    private List<Fish> fishList;

    private static ModelFacade instance = new ModelFacade();
    private FishFactory fishFactory = new FishFactory();
    private ModelFacade (){}


    public static ModelFacade getInstance(){
        return instance;
    }

    public List<Fish> getFishList() {
        return fishList;
    }

    public void createUser(String username){
        User user = new User(username);
        System.out.print(user.getUsername() + "is created!");
    }


    private void createFish(int x, int y, FishProperty property, FishSize size, String texture) {
        fishList.add(FishFactory.createFish(x,y,property, size, texture));
    }
}
