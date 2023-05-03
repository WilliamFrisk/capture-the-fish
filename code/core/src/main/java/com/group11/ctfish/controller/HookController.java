package com.group11.ctfish.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.Hook;
import com.group11.ctfish.model.ModelFacade;
import com.group11.ctfish.model.fish.Fish;

import java.util.List;

public class HookController {


    private Hook hook;
    ModelFacade facade = ModelFacade.getInstance();



    public HookController(Hook hook) {
        this.hook = hook;
    }

    public void update() {
        if (Gdx.input.isTouched()) {

            hook.setHookY(CtFish.SCREEN_HEIGHT - Gdx.input.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) hook.setHookY(hook.getHook().y - 20 * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) hook.setHookY(hook.getHook().y + 20 * Gdx.graphics.getDeltaTime());

        if(hook.getHook().y < 0) hook.setHookY(0);
        if(hook.getHook().y > CtFish.SCREEN_HEIGHT-125) hook.setHookY(CtFish.SCREEN_HEIGHT-125);
    }
}
