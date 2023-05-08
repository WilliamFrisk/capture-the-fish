package com.group11.ctfish.model.fish;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.group11.ctfish.model.Hook;
import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.fish.properties.FishProperty;
import com.group11.ctfish.model.util.Object2D;

import java.util.List;



public class Fish implements Object2D {
    private final ModelFacade modelFacade = ModelFacade.getInstance();
    private final Hook hook = modelFacade.getHookObject();

    private FishProperty property;

    private final Size size;
    private final Sprite sprite;
    private final Direction direction;

    private Vector2 pos;
    private final Vector2 vel = new Vector2();
    private final Vector2 acc = new Vector2();

    private final int maxSpeed = 5;
    private final float maxForce = .4f;

    private boolean onHook = false;
    private boolean caught = false;

    public Fish(int x,
                int y,
                FishProperty property,
                Size size,
                Texture texture,
                Direction direction) {

        this.pos = new Vector2(x, y);
        this.property = property;
        this.size = size;

        this.sprite = new Sprite(texture);
        sprite.setSize(
                texture.getWidth() * size.getScaleFactor() * 0.2f,
                texture.getHeight() * size.getScaleFactor() * 0.2f
        );
        sprite.setOriginCenter();

        this.direction = direction;
        if (direction == Direction.LEFT) {
            sprite.flip(true, true);
        } else if (direction == Direction.RIGHT) {
            sprite.flip(true, false);
        }
    }

    public void onCaught() {
        property.applyProperty();
    }

    public boolean collected(){
        return caught;
    }

    public void update(List<Fish> others) {
        if (!onHook) {
            acc.add(moveTowardsEdge());
            acc.add(avoidTopAndBottom());
            acc.add(avoid(others));
        }
    }

    public void move() {
        if (!onHook) {
            pos.add(vel);
            vel.add(acc);
            vel.limit(maxSpeed);
            sprite.setRotation(vel.angleDeg());
            acc.scl(0);
        } else if (pos.y >= 519) {
            onCaught();
            caught = true;
        }

        sprite.setPosition(pos.x, pos.y);
    }

    private Vector2 moveTowardsEdge() {
        return direction == Direction.LEFT ?
                new Vector2(-maxForce, 0) :
                new Vector2(maxForce, 0);
    }

    private Vector2 avoidTopAndBottom() {
        Vector2 posCopy = new Vector2(pos);

        double dToBottom = posCopy.y;
        double dToTop = 500 - posCopy.y;

        if (dToBottom < 100) {
            Vector2 diff = new Vector2(0, 100);
            diff.scl((float) (1 / (dToBottom*dToBottom)));
            diff.limit(maxForce);
            return diff;
        } else if (dToTop < 100) {
            Vector2 diff = new Vector2(0, -100);
            diff.scl((float) (1 / (dToTop*dToTop)));
            diff.limit(maxForce);
            return diff;
        }

        return new Vector2();
    }

    private Vector2 avoid(List<Fish> others) {
        int perceptionRadius = 150;
        Vector2 steering = new Vector2();
        int total = 0;

        for(Fish other : others) {

            Vector2 thisCopy = new Vector2(this.pos);
            Vector2 otherCopy = new Vector2(other.pos);
            double d = thisCopy.dst2(otherCopy);

            if (!other.equals(this) && d < perceptionRadius * perceptionRadius) {
                Vector2 diff = thisCopy.sub(otherCopy);
                diff.scl((float) (1 / (d*d)));
                steering.add(diff);
                total++;
            }
        }

        if (total > 0) {
            steering.scl(1f / total);
            steering.setLength(this.maxSpeed);
            steering.sub(vel);
            steering.limit(maxForce);
        }
        return steering;
    }

    public void hooked(){
        this.setVector(hook.getX(), hook.getY());
    }

    public void followVector(Vector2 vector) {
        onHook = true;
        pos = vector;
    }

    public void setVector(float x, float y){
        this.pos = new Vector2(x,y);
    }

    public float getX() {
        return pos.x;
    }

    public float getY() {
        return pos.y;
    }

    public Vector2 getPos() {
        return new Vector2(pos);
    }

    public int getScore(){
        return this.getScore();
    }

    public Sprite getSprite(){
        return sprite;
    }

    public void setTextureWhite(){
        this.sprite.setTexture(new Texture("fish/red-fish/red-fish-left.png"));
    }

    public int getWidth() {
        return (int) sprite.getWidth();
    }

    public int getHeight() {
        return (int) sprite.getHeight();
    }

}
