package com.group11.ctfish.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;
import com.group11.ctfish.CtFish;
import com.group11.ctfish.model.Hook;

public class HookController {
    private Hook hook;

    public HookController(Hook hook) {
        this.hook = hook;
    }

    public void update() {
        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(0, Gdx.input.getY(), 0);
            hook.setHookY(touchPos.y);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) hook.setHookY(hook.getHook().y - 20 * Gdx.graphics.getDeltaTime());
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) hook.setHookY(hook.getHook().y + 20 * Gdx.graphics.getDeltaTime());

        if(hook.getHook().y < 0) hook.setHookY(0);
        if(hook.getHook().y > CtFish.SCREEN_HEIGHT-125) hook.setHookY(CtFish.SCREEN_HEIGHT-125);
    }
}
