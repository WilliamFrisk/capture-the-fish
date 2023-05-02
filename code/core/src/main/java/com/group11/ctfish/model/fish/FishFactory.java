package com.group11.ctfish.model.fish;
import java.util.Random;

import com.badlogic.gdx.graphics.Texture;
import com.group11.ctfish.model.fish.properties.*;
import com.group11.ctfish.model.fish.sizes.*;



public class FishFactory {
    static Random rand = new Random();

    //TODO Implement createRandomFish
    public static Fish createFish(int x, int y, boolean isRight, FishProperty property, FishSize size, String texture) {
        return new Fish(x, y, isRight, property, size, new Texture(texture));
    }

    public static Fish createRandomFish(int x, int y, boolean direction){
        int random = rand.nextInt(3);
        if(random==1){
            return createRedFish(x,y,direction);
        } else if (random == 2) {
            return createSwordFish(x,y,direction);
        } else {
            return createUglyFish(x,y,direction);
        }
    }

    public static Fish createRedFish(int x, int y, boolean direction){
        String texture;
        if(direction){
            texture = "fish/red-fish/red-fish-right.png";
        }else{
            texture = "fish/red-fish/red-fish-left.png";
        }
        return new Fish(x, y, direction,new Collectable(), new Medium(), new Texture(texture));
    }

    public static Fish createSwordFish(int x, int y, boolean direction){
        String texture;
        if(direction){
            texture = "fish/sword-fish/sword-fish-right.png";
        }else{
            texture = "fish/sword-fish/sword-fish-left.png";
        }
        return new Fish(x, y, direction,new Endangered(), new Large(), new Texture(texture));

    }

    public static Fish createUglyFish(int x, int y, boolean direction){
        String texture;
        if(direction){
            texture = "fish/ugly-fish/ugly-fish-right.png";
        }else{
            texture = "fish/ugly-fish/ugly-fish-left.png";
        }
        return new Fish(x, y, direction,new Collectable(), new Small(), new Texture(texture));

    }

}

