package com.group11.ctfish.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.Hook;
import com.group11.ctfish.model.ModelFacade;

public class HookController {

    private final Hook hook;

    public HookController(Hook hook) {
        this.hook = hook;
    }

    public void update() {
        if (Gdx.input.isTouched()) {
            hook.setY(CtFish.SCREEN_HEIGHT - Gdx.input.getY());
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) hook.setY(hook.getY() -  Gdx.graphics.getDeltaTime()*CtFish.SCREEN_HEIGHT);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) hook.setY(hook.getY() + Gdx.graphics.getDeltaTime()*CtFish.SCREEN_HEIGHT);

        if(hook.getY() < 0) hook.setY(0);
        if(hook.getY() > CtFish.SCREEN_HEIGHT-95) hook.setY(CtFish.SCREEN_HEIGHT-95);
    }


}

