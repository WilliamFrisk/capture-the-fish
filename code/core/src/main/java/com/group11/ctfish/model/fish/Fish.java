package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.fish.sizes.FishSize;
import com.group11.ctfish.model.fish.sizes.Sizes;

import java.util.List;

public class Fish{
    private int width;
    private int height;
    private FishProperty property;

    private FishSize size;
    private TextureRegion texture;
    private Direction direction;

    private Vector2 pos;
    private Vector2 vel = new Vector2(0, 0);
    private Vector2 acc = new Vector2(0, 0);


    private final Vector2 aim;

    public Fish(int x,
                int y,
                FishProperty property,
                FishSize size,
                TextureRegion texture,
                Direction direction) {
        this.pos = new Vector2(x, y);
        width = size.getWidth();
        height = size.getHeight();
        this.texture = texture;
        this.property = property;
        this.size = size;
        this.direction = direction;
        if (direction == Direction.LEFT) {
            aim = new Vector2(-100, CtFish.SCREEN_HEIGHT / 2 - 175);
        } else {
            aim = new Vector2(CtFish.SCREEN_WIDTH + 100, CtFish.SCREEN_HEIGHT / 2);
        }
    }

    public void onCaught() {
        property.applyProperty();
    }

    public void move() {
        Vector2 temp = new Vector2(pos);
        temp.sub(aim);
        temp.setLength(5);
        pos.sub(temp);
    }

    void avoid(List<Fish> others) {

    }

    public float getX() {
        return pos.x;
    }

    public float getY() {
        return pos.y;
    }

    public void setTexture(TextureRegion texture){
        this.texture = texture;
    }

    public TextureRegion getTexture(){
        return texture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
